package com.tcm.community.service;

import com.tcm.community.mapper.*;
import com.tcm.community.model.*;
import com.tcm.community.util.SensitiveFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import java.util.*;

@Service
public class PostService {

    @Autowired
    private PostDetailMapper postDetailMapper;

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Autowired
    private UserTokenMapper userTokenMapper;

    @Autowired
    private PostBravocountMapper postBravocountMapper;

    @Autowired
    private PostCommentcountMapper postCommentcountMapper;

    @Autowired
    private PostViewcountMapper postViewcountMapper;

    @Autowired
    private UserAccMapper userAccMapper;

    @Autowired
    private UserAinfoMapper userAinfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private PostDcMapper postDcMapper;

    @Autowired
    private PostCommentMapper postCommentMapper;

    @Autowired
    private UserFollowMapper userFollowMapper;

    @Transactional(rollbackFor = Exception.class)
    public Map<String,Object> addPost(PostDetail postDetail,String token){

        Map<String,Object> map = new HashMap<>();
        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null) {
            map.put("logoutMsg","user not exist!");
            return map;
        }
        if(postDetail == null){
            throw new IllegalArgumentException("params cant empty!");
        }

        //html tag cancel   //seneitive words filter
        Date date = new Date();
        Long time = date.getTime();
        PostBravocount postBravocount = new PostBravocount();
        PostCommentcount postCommentcount = new PostCommentcount();
        PostViewcount postViewcount = new PostViewcount();

        postDetail.setUid(existedToken.getUid());
        postDetail.setIsdel(0);
        postDetail.setCtime(time);
        postDetail.setMtime(time);
        postDetail.setWord(sensitiveFilter.filter(HtmlUtils.htmlEscape(postDetail.getWord())));
        postDetail.setTag("");
        postDetail.setTitle(sensitiveFilter.filter(HtmlUtils.htmlEscape(postDetail.getTitle())));
        postDetail.setTop(0);

        postDetailMapper.insertPostDetail(postDetail);

        postBravocount.setPid(postDetail.getPid());
        postBravocount.setBravocount(0);
        postCommentcount.setPid(postDetail.getPid());
        postCommentcount.setCount(0);
        postViewcount.setPid(postDetail.getPid());
        postViewcount.setViewcount(0);

        postBravocountMapper.insertPostBravocount(postBravocount);
        postCommentcountMapper.insertPostCommentcount(postCommentcount);
        postViewcountMapper.insertPostViewcount(postViewcount);

        map.put("pid",postDetail.getPid());

        return map;
    }

    /**
     * 获取全部帖子
     * @param token
     * @return
     */
    public Map<String, Object> getPostList(String token) {
        Map<String,Object> map = new HashMap<>();
        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null) {
            map.put("returnMsg","user not exist!");
            return map;
        }

        List<PostDetail> postDetailList = postDetailMapper.getPostList();

        List<PostDetailBo> postDetailBoList = new ArrayList<>();
        for (PostDetail postDetail : postDetailList) {
            PostDetailBo postDetailBo = new PostDetailBo();
            postDetailBo.setPid(postDetail.getPid());
            postDetailBo.setUid(postDetail.getUid());
            postDetailBo.setName(userAccMapper.findById(postDetail.getUid()).getName());
            postDetailBo.setTitle(postDetail.getTitle());
            postDetailBo.setContent(postDetail.getWord());
            postDetailBoList.add(postDetailBo);
        }

        map.put("returnMsg", "true");
        map.put("result", postDetailBoList);

        return map;
    }

    public Map<String,Object> getPostDetail(int pid){

        Map<String,Object> map = new HashMap<>();
        PostDetail postDetail = postDetailMapper.findByPid(pid);
        if(postDetail == null){
            map.put("returnMsg","post not exist!");
            return map;
        }
        UserAcc userAcc = userAccMapper.findById(postDetail.getUid());
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

        PostBravocount postBravocount = postBravocountMapper.findByPid(postDetail.getPid());
        PostCommentcount postCommentcount = postCommentcountMapper.findByPid(postDetail.getPid());
        PostViewcount postViewcount = postViewcountMapper.findByPid(postDetail.getPid());

        map.put("uid", userAcc.getUid());
        map.put("name",userAcc.getName());
        map.put("isidenti",userInfo.getIsidenti());
        map.put("pic",userInfo.getPic());
        map.put("pid",postDetail.getPid());
        map.put("title",postDetail.getTitle());
        map.put("mtime",postDetail.getMtime());
        map.put("word",postDetail.getWord());
        map.put("bravocount",postBravocount.getBravocount());
        map.put("commentcount",postCommentcount.getCount());
        map.put("viewcount",postViewcount.getViewcount());

        List<PostDc> postDcs = postDcMapper.findByPid(postDetail.getPid());
        List commentList = new ArrayList();
        for(PostDc postDc : postDcs){
            Map<String,Object> commentMap = new HashMap<>();
            PostComment postComment = postCommentMapper.findCommentByPcmid(postDc.getPcmid());
            userAinfo = userAinfoMapper.findByUid(postDc.getUid());
            userInfo = userInfoMapper.findByUiid(userAinfo.getUiid());
            userAcc = userAccMapper.findById(postDc.getUid());
            commentMap.put("uid", userAcc.getUid());
            commentMap.put("name",userAcc.getName());
            commentMap.put("isidenti",userInfo.getIsidenti());
            commentMap.put("pic",userInfo.getPic());
            commentMap.put("pcmid",postDc.getPcmid());
            commentMap.put("detail",postComment.getDetail());
            commentMap.put("ctime",postComment.getCtime());

            commentList.add(commentMap);
        }

        map.put("comment",commentList);
        map.put("returnMsg", "true");

        return map;
    }

    public Map<String,Object> changePostDetail(PostDetail postDetail,String token){

        Map<String,Object> map = new HashMap<>();
        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null){
            map.put("logoutMsg","user not exist!");
            return map;
        }
        if(postDetail == null){
            throw new IllegalArgumentException("params cant empty!");
        }

        //html tag cancel   //seneitive words filter
        Date date = new Date();
        Long time = date.getTime();

        postDetail.setPid(postDetail.getPid());
        postDetail.setMtime(time);
        postDetail.setWord(sensitiveFilter.filter(HtmlUtils.htmlEscape(postDetail.getWord())));
        postDetail.setImg(sensitiveFilter.filter(HtmlUtils.htmlEscape(postDetail.getImg())));
        postDetail.setVideo(sensitiveFilter.filter(HtmlUtils.htmlEscape(postDetail.getVideo())));
        postDetail.setAudio(sensitiveFilter.filter(HtmlUtils.htmlEscape(postDetail.getAudio())));
        postDetail.setTag(sensitiveFilter.filter(HtmlUtils.htmlEscape(postDetail.getTag())));
        postDetail.setTitle(sensitiveFilter.filter(HtmlUtils.htmlEscape(postDetail.getTitle())));

        postDetailMapper.updatePostDetail(postDetail);

        return map;
    }

    public Map<String,Object> deletePostDetail(long pid,String token){

        Map<String,Object> map = new HashMap<>();
        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null){
            map.put("logoutMsg","user not exist!");
            return map;
        }

        postDetailMapper.deletePostDetail(pid);

        return map;
    }

    /**
     * 插入帖子评论
     * @param token
     * @param postComment
     * @return
     */
    public Map<String, Object> insertPostComment(String token, Long pid, PostComment postComment) {
        Map<String,Object> map = new HashMap<>();
        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null){
            map.put("returnMsg","user not exist!");
            return map;
        }

        // 插入评论内容表
        postCommentMapper.insertPostComment(postComment);

        // 建立帖子和评论对应关系
        PostDc postDc = new PostDc();
        postDc.setPcmid(postComment.getPcmid());
        postDc.setPid(pid);
        postDc.setUid(existedToken.getUid());
        postDcMapper.insertPostDc(postDc);

        // 帖子评论数+1
        PostCommentcount postCommentcount = postCommentcountMapper.findByPid(pid);
        Integer count = postCommentcount.getCount();
        count += 1;
        postCommentcount.setCount(count);
        postCommentcountMapper.updatePostCommentcount(postCommentcount);

        map.put("returnMsg", "true");
        return map;
    }

    /**
     * 获取关注人的帖子列表
     * @param token
     * @return
     */
    public Map<String, Object> getAttentionPost(String token) {
        Map<String,Object> map = new HashMap<>();
        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null){
            map.put("returnMsg","user not exist!");
            return map;
        }

        // 获取关注人列表
        Set<Integer> attentionSet = userFollowMapper.getAttentionSet(existedToken.getUid());

        List<PostDetail> postDetailList = postDetailMapper.findByUid(attentionSet);

        List<PostDetailBo> postDetailBoList = new ArrayList<>();
        for (PostDetail postDetail : postDetailList) {
            PostDetailBo postDetailBo = new PostDetailBo();
            postDetailBo.setPid(postDetail.getPid());
            postDetailBo.setUid(postDetail.getUid());
            postDetailBo.setName(userAccMapper.findById(postDetail.getUid()).getName());
            postDetailBo.setTitle(postDetail.getTitle());
            postDetailBo.setContent(postDetail.getWord());
            postDetailBoList.add(postDetailBo);
        }

        map.put("returnMsg", "success");
        map.put("result", postDetailBoList);

        return map;
    }

}
