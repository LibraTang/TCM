package com.tcm.community.service;

import com.tcm.community.mapper.*;
import com.tcm.community.model.*;
import com.tcm.community.util.RandomUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserAccMapper userAccMapper;

    @Autowired
    private UserAinfoMapper userAinfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserTokenMapper userTokenMapper;

    @Autowired
    private UserFollowMapper userFollowMapper;

    @Autowired
    private PostDetailMapper postDetailMapper;

    @Autowired
    private UserSurveyMapper userSurveyMapper;

    @Autowired
    private UserRecommendMapper userRecommendMapper;

    @Value("${community.path.url}")
    private String url;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${community.path.uploadLocation}")
    private String uploadPathLocation;

    @Value("${community.path.upload}")
    private String uploadPath;

    @Transactional(rollbackFor = Exception.class)//isolation = isolatin.READ_COMMITED,propagation = Propagation.REQUIRED
    public Map<String,Object> register(UserAcc userAcc){

        Map<String,Object> map = new HashMap<>();

        //verify null
        if(userAcc == null){
            //throw new IllegalArgumentException("参数不能为空!");
            map.put("returnMsg","params cant all empty!");
            return map;
        }
        if(StringUtils.isBlank(userAcc.getUname())){
            map.put("returnMsg","username cant empty!");
            return map;
        }
        if(userAcc.getUname().length() != 11){
            map.put("returnMsg","username error length!");
            return map;
        }
        if(StringUtils.isBlank(userAcc.getPword())){
            map.put("returnMsg","password cant empty!");
            return map;
        }
        if(userAcc.getAuth() == null){
            map.put("returnMsg","auth cant empty!");
            return map;
        }else if(userAcc.getAuth() != 0 && userAcc.getAuth() != 1){
            map.put("returnMsg","auth error!");
            return map;
        }

        UserAcc existedUser = userAccMapper.findByUname(userAcc.getUname());
        if(existedUser != null && existedUser.getIsdel() == 0){
            map.put("returnMsg","username has existed!");
            return map;
        }

        userAcc.setSalt(RandomUtil.generateUUID().substring(0,7));
        userAcc.setPword(RandomUtil.md5Encode(userAcc.getPword()+userAcc.getSalt()));
        userAcc.setName("User"+RandomUtil.generateUUID().substring(0,15));
        userAcc.setAuth(userAcc.getAuth());
        userAcc.setIsdel(0);

        UserInfo userInfo = new UserInfo();
        Date date = new Date();
        Long time = date.getTime();
        userInfo.setCtime(time);
        userInfo.setAge(0);
        userInfo.setSex(0);
        userInfo.setEmail("");
        userInfo.setProvince("");
        userInfo.setCity("");
        userInfo.setRegion("");
        userInfo.setLocation("");
        userInfo.setSelfintro("");
        userInfo.setPic(String.format("headpic/header/%dh.png",new Random().nextInt(100)));
        userInfo.setTag("");
        userInfo.setIsidenti(0);
        userInfo.setType(0);

        userAccMapper.insertUserAcc(userAcc);
        userInfoMapper.insertUserInfo(userInfo);

        //如果身份是医生，需要在推荐表里加一条记录
        if (1 == userAcc.getAuth()) {
            UserRecommend userRecommend = new UserRecommend();
            userRecommend.setUid(userAcc.getUid());
            userRecommend.setAnswerNumber(0);
            userRecommend.setRate(0.0);
            userRecommend.setType(userInfo.getType());
            userRecommendMapper.insertUserRecommend(userRecommend);
        }

        //user_ainfo
        UserAinfo userAinfo = new UserAinfo();
        userAinfo.setUid(userAcc.getUid());
        userAinfo.setUiid(userInfo.getUiid());

        userAinfoMapper.insertUserAinfo(userAinfo);

        //user_token
        UserToken userToken = new UserToken();
        userToken.setUid(userAcc.getUid());
        userToken.setToken("0");
        userToken.setExpired(0L);
        userToken.setStatus(0);
        userToken.setLogintime(time);

        userTokenMapper.insertUserToken(userToken);

        return map;
    }

    public Map<String,Object> login(UserAcc userAcc){

        Map<String,Object> map = new HashMap<>();

        if(userAcc == null){
            map.put("returnMsg","params cant all empty!");
            return map;
        }
        if(StringUtils.isBlank(userAcc.getUname())){
            map.put("returnMsg","username cant empty!");
            return map;
        }
        if(StringUtils.isBlank(userAcc.getPword())){
            map.put("returnMsg","password cant empty!");
            return map;
        }
        //verify the same username
        UserAcc existedUser = userAccMapper.findByUname(userAcc.getUname());
        if(existedUser == null || existedUser.getIsdel() == 1){
            map.put("returnMsg","username not exist!");
            return map;
        }
        if(!(RandomUtil.md5Encode(userAcc.getPword()+existedUser.getSalt())).equals(existedUser.getPword())){
            map.put("returnMsg","password wrong!");
            return  map;
        }

        Map<String,Object> token= obtainToken(existedUser.getUid());
        map.put("token", token.get("token"));
        map.put("expired", token.get("expired"));
        map.put("auth", existedUser.getAuth());
        if(map.get("token") != null && map.get("expired") != null){
            map.put("returnMsg","true");
        }

        return map;

    }

    public Map<String,Object> obtainToken(Integer uid){    //generate and obtain token

        Date date = new Date();
        Long ctime = date.getTime();
        date.setTime(date.getTime()+1000*3600*24);//24h expired
        Long expired = date.getTime();
        String token = RandomUtil.generateUUID();

        UserToken userToken = new UserToken();
        userToken.setUid(uid);
        userToken.setToken(token);
        userToken.setExpired(expired);
        userToken.setStatus(1);
        userToken.setLogintime(ctime);

        UserToken existedToken = userTokenMapper.findByUid(uid);

        if(existedToken != null){
            userTokenMapper.updateUserToken(userToken);
        }else{
            userTokenMapper.insertUserToken(userToken);
        }

        Map<String,Object> tokenMap = new HashMap<>();//provide token and expired time
        tokenMap.put("token",userToken.getToken());
        tokenMap.put("expired",userToken.getExpired());

        return tokenMap;
    }

    public  Map<String,Object> logout(String token){    //update user_token

        Map<String,Object> map = new HashMap<>();

        if(token == null || token == ""){
            map.put("returnMsg","empty string!");
            return map;
        }
        UserToken existedToken = userTokenMapper.findByToken(token);

        if(existedToken  != null){
            Date date = new Date();
            Long time = date.getTime();
            UserToken userToken = new UserToken();
            userToken.setUid(existedToken .getUid());
            userToken.setToken("0");
            userToken.setExpired(0L);
            userToken.setStatus(0);
            userToken.setLogintime(time);

            userTokenMapper.updateUserToken(userToken);

            map.put("uid",userToken.getUid());
        }else{
            map.put("returnMsg","user not login!");
            return map;
        }

        return  map;
    }

    @Transactional(rollbackFor = Exception.class)
    public Map<String,Object> delete(String token){  //update user_acc

        Map<String,Object> map = logout(token);
        Integer uid = 0;

        if(map.containsKey("uid")){
            uid = (Integer)map.get("uid");
        }else if(map.get("returnMsg") != null) {
            return map;
        }else{
            map.put("returnMsg","user not exist!");
            return map;
        }

        UserAcc existedUser = userAccMapper.findById(uid);
        if(existedUser != null){
            existedUser.setUname(existedUser.getUname()+"d");
            existedUser.setIsdel(1);

            userAccMapper.updateUnameIsdel(existedUser);
        }else{
            map.put("returnMsg","user not exist!");
        }

        return map;

    }

    public Map<String,Object> displayInfo(String token){

        Map<String,Object> map = new HashMap<>();

        if(token == null || token == ""){
            map.put("returnMsg","empty string!");
            return map;
        }
        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null){
            map.put("returnMsg","user not exist!");
            return map;
        }
        UserAcc userAcc = userAccMapper.findById(existedToken.getUid());

        if(userAcc == null){
            map.put("returnMsg","user not exist!");
            return map;
        }

        UserAinfo userAinfo = userAinfoMapper.findByUid(existedToken.getUid());
        UserInfo userInfo = userInfoMapper.findByUiid(userAinfo.getUiid());
        if(userInfo != null) {
            map.put("returnMsg", "true");
            map.put("name", userAcc.getName());
            map.put("age", userInfo.getAge().toString());
            map.put("email", userInfo.getEmail());
            map.put("province", userInfo.getProvince());
            map.put("city", userInfo.getCity());
            map.put("region", userInfo.getRegion());
            map.put("location", userInfo.getLocation());
            map.put("selfintro", userInfo.getSelfintro());
            map.put("pic", userInfo.getPic());
            map.put("tag", userInfo.getTag());
            map.put("sex", userInfo.getSex().toString());
            map.put("isidenti", userInfo.getIsidenti().toString());
            map.put("type", DoctorTypeEnum.getValue(userInfo.getType().toString()));
        }

        return map;
    }

    /**
     * 获取其他用户信息
     * @param token
     * @param uid
     * @return
     */
    public Map<String, Object> getOthersInfo(String token, Integer uid) {
        Map<String,Object> map = new HashMap<>();

        if(token == null || token == ""){
            map.put("returnMsg","empty string!");
            return map;
        }

        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null){
            map.put("returnMsg","user not exist!");
            return map;
        }

        UserAcc userAcc = userAccMapper.findById(uid);
        if(userAcc == null){
            map.put("returnMsg","user not exist!");
            return map;
        }

        UserAinfo userAinfo = userAinfoMapper.findByUid(uid);
        UserInfo userInfo = userInfoMapper.findByUiid(userAinfo.getUiid());
        if(userInfo != null) {
            map.put("returnMsg", "success");
            map.put("name", userAcc.getName());
            map.put("age", userInfo.getAge().toString());
            map.put("email", userInfo.getEmail());
            map.put("province", userInfo.getProvince());
            map.put("city", userInfo.getCity());
            map.put("region", userInfo.getRegion());
            map.put("location", userInfo.getLocation());
            map.put("selfintro", userInfo.getSelfintro());
            map.put("pic", userInfo.getPic());
            map.put("tag", userInfo.getTag());
            map.put("sex", userInfo.getSex().toString());
            map.put("isidenti", userInfo.getIsidenti().toString());
            map.put("type", DoctorTypeEnum.getValue(userInfo.getType().toString()));
        }

        return map;
    }

    public Map<String,Object> changeUserInfo(String token,UserInfo userInfo){

        Map<String,Object> map = new HashMap<>();

        if(token == null || token == ""){
            map.put("returnMsg","empty string!");
            return map;
        }

        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null){
            map.put("returnMsg","user not exist!");
            return map;
        }
        UserAcc userAcc = userAccMapper.findById(existedToken.getUid());

        if(userAcc == null){
            map.put("returnMsg","user not exist!");
            return map;
        }

        UserAinfo userAinfo = userAinfoMapper.findByUid(existedToken.getUid());
        if(userAinfo == null){
            map.put("returnMsg","user not exist!");
            return map;
        }
        UserInfo existedUserInfo = userInfoMapper.findByUiid(userAinfo.getUiid());
        userInfo.setUiid(existedUserInfo.getUiid());
        userInfoMapper.updateUserInfo(userInfo);

        // 同时更新医生推荐表里的所属科室
        if (userInfo.getType() != 0) {
            UserRecommend userRecommend = userRecommendMapper.findByUid(userAcc.getUid());
            userRecommend.setType(userInfo.getType());
            userRecommendMapper.updateUserRecommendByUid(userRecommend);
        }

        return map;
    }

    /**
     * 改变用户昵称
     * @param token
     * @param name
     * @return
     */
    public Map<String, Object> changeUsername(String token, String name) {
        Map<String,Object> map = new HashMap<>();

        if(token == null || "".equals(token)){
            map.put("returnMsg","empty string!");
            return map;
        }

        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null){
            map.put("returnMsg","user not exist!");
            return map;
        }
        UserAcc userAcc = userAccMapper.findById(existedToken.getUid());

        if(userAcc == null){
            map.put("returnMsg","user not exist!");
            return map;
        }

        userAcc.setName(name);
        userAccMapper.updateName(userAcc);
        map.put("returnMsg", "true");

        return map;
    }

    public Map<String,Object> changeHeader(String token, MultipartFile header){

        Map<String,Object> map = new HashMap<>();
        if(header == null){
            map.put("returnMsg","null");
            return map;
        }
        String fileName = header.getOriginalFilename();
        if(!fileName.contains(".png")){
            map.put("returnMsg","null");
            return map;
        }

        String suffix = fileName.substring(fileName.lastIndexOf("."));
        if(StringUtils.isBlank(suffix)){
            map.put("returnMsg","error file format!");
            return map;
        }

        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null){
            map.put("returnMsg","user not exist!");
            return map;
        }
        UserAcc userAcc = userAccMapper.findById(existedToken.getUid());

        if(userAcc == null){
            map.put("returnMsg","user not exist!");
            return map;
        }
        Date date = new Date();
        long time = date.getTime();
        fileName = RandomUtil.md5Encode(RandomUtil.generateUUID().substring(0,6).replace("-","") + time) + suffix;
        File dest = new File(uploadPathLocation + uploadPath + "/" + fileName);
/*        System.out.println(contextPath);
        System.out.println(uploadPathLocation + uploadPath + fileName);*/
        try {
            header.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException("upload fail!",e);
        }
        String headerUrl = uploadPath + "/" + fileName;

        UserAinfo userAinfo = userAinfoMapper.findByUid(existedToken.getUid());
        if(userAinfo == null){
            map.put("returnMsg","user not exist!");
            return map;
        }
        UserInfo userInfo = userInfoMapper.findByUiid(userAinfo.getUiid());
        userInfo.setPic(headerUrl);
        userInfoMapper.updateUserHeader(userInfo);

        return map;
    }

    public Map<String,Object> changePassword(String token,String oldPword,String newPword){

        Map<String,Object> map = new HashMap<>();

        if(token == null || token == ""){
            map.put("returnMsg","empty string!");
            return map;
        }

        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null){
            map.put("returnMsg","user not exist!");
            return map;
        }
        UserAcc userAcc = userAccMapper.findById(existedToken.getUid());
        if(userAcc == null){
            map.put("returnMsg","user not exist!");
            return map;
        }
        oldPword = RandomUtil.md5Encode(oldPword + userAcc.getSalt());


        if(userAcc.getPword().equals(oldPword)){
            String newSalt = RandomUtil.generateUUID().substring(0, 7);
            newPword = RandomUtil.md5Encode(newPword + newSalt);
            userAcc.setPword(newPword);
            userAcc.setSalt(newSalt);

            userAccMapper.updatePwordSalt(userAcc);
        }else{
            map.put("returnMsg","old password wrong!");
        }

        return map;
    }

    public Map<String,Object> displayHomepage(String token,int pid){

        Map<String,Object> map = new HashMap<>();
        UserAcc userAcc = new UserAcc();

        if(token == null || token == ""){
            map.put("returnMsg","empty string!");
            return map;
        }
        if(pid != -1){
            PostDetail postDetail = postDetailMapper.findByPid(pid);
            userAcc = userAccMapper.findById(postDetail.getUid());
        }else{
            UserToken existedToken = userTokenMapper.findByToken(token);
            if(existedToken == null){
                map.put("returnMsg","user not exist!");
                return map;
            }
            userAcc = userAccMapper.findById(existedToken.getUid());
        }

        if(userAcc == null){
            map.put("returnMsg","user not exist!");
            return map;
        }

        UserAinfo userAinfo = userAinfoMapper.findByUid(userAcc.getUid());
        if(userAinfo == null){
            map.put("returnMsg","user not exist!");
            return map;
        }
        UserInfo userInfo = userInfoMapper.findByUiid(userAinfo.getUiid());
        if(userInfo == null){
            map.put("returnMsg","user not exist!");
            return map;
        }

        Integer followcount = userFollowMapper.getAttentionCount(userAcc.getUid());
        Integer fanscount = userFollowMapper.getFollowCount(userAcc.getUid());

        map.put("name",userAcc.getName());
        map.put("pic",userInfo.getPic());
        map.put("tag",userInfo.getTag());
        map.put("followcount",followcount.toString());
        map.put("fanscount",fanscount.toString());
        map.put("sex",userInfo.getSex().toString());
        map.put("isidenti",userInfo.getIsidenti().toString());
        map.put("returnMsg","true");

        return map;
    }

    /**
     * 插入用户问诊问卷，若已存在则更新
     * @param userSurvey
     * @param token
     * @return
     */
    public Map<String, Object> insertUserSurvey(UserSurvey userSurvey, String token) {
        Map<String, Object> map = new HashMap<>();
        if(token == null || "".equals(token)){
            map.put("returnMsg","empty token!");
            return map;
        }
        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null){
            map.put("returnMsg","user not exist!");
            return map;
        }

        userSurvey.setUid(existedToken.getUid());
        userSurveyMapper.insertUserSurvey(userSurvey);

        if (null != userSurvey.getUsid()) {
            map.put("returnMsg", "success");
            map.put("result", userSurvey);
        } else {
            map.put("returnMsg", "failed");
        }

        return map;
    }

    /**
     * 根据uid获取用户问诊问卷
     * @param uid
     * @param token
     * @return
     */
    public Map<String, Object> getUserSurveyByUid(Integer uid, String token) {
        Map<String, Object> map = new HashMap<>();

        if (token == null || "".equals(token)) {
            map.put("returnMsg", "empty token!");
            return map;
        }
        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null){
            map.put("returnMsg","user not exist!");
            return map;
        }

        if (0 == uid) {
            uid = existedToken.getUid();
        }

        UserSurvey userSurvey = userSurveyMapper.findByUid(uid);

        if (null == userSurvey) {
            map.put("returnMsg", "failed");
            return map;
        }
        map.put("returnMsg", "success");
        map.put("result", userSurvey);

        return map;
    }

    /**
     * 修改用户问诊问卷
     * @param userSurvey
     * @param token
     * @return
     */
    public Map<String, Object> updateUserSurvey(UserSurvey userSurvey, String token) {
        Map<String, Object> map = new HashMap<>();

        if (token == null || "".equals(token)) {
            map.put("returnMsg", "empty token!");
            return map;
        }

        userSurveyMapper.updateUserSurvey(userSurvey);
        map.put("returnMsg", "success");

        return map;
    }

    /**
     * 根据科室推荐医生
     * @param type 科室
     * @param token
     * @return
     */
    public Map<String, Object> listUserRecommendByType(Integer type, String token) {
        Map<String, Object> map = new HashMap<>();

        if (token == null || "".equals(token)) {
            map.put("returnMsg", "empty token!");
            return map;
        }

        List<UserRecommend> recommendList = userRecommendMapper.listByType(type);
        if (recommendList.isEmpty()) {
            map.put("returnMsg", "no recommend");
            return map;
        }
        // 默认按回答数优先排序
        recommendList.sort((doctor1, doctor2) -> doctor2.getAnswerNumber().compareTo(doctor1.getAnswerNumber()));

        List<RecommendDoctorBo> recommendDoctorBoList = new ArrayList<>();
        for (UserRecommend userRecommend : recommendList) {
            UserAcc userAcc = userAccMapper.findById(userRecommend.getUid());
            RecommendDoctorBo recommendDoctorBo = new RecommendDoctorBo();
            recommendDoctorBo.setUid(userAcc.getUid());
            recommendDoctorBo.setName(userAcc.getName());
            recommendDoctorBo.setType(DoctorTypeEnum.getValue(userRecommend.getType().toString()));
            recommendDoctorBo.setAnswerNumber(userRecommend.getAnswerNumber());
            recommendDoctorBoList.add(recommendDoctorBo);
        }

        map.put("returnMsg", "success");
        map.put("result", recommendDoctorBoList);

        return map;
    }

}
