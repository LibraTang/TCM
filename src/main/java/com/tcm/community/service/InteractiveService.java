package com.tcm.community.service;

import com.tcm.community.mapper.UserAccMapper;
import com.tcm.community.mapper.UserFollowMapper;
import com.tcm.community.mapper.UserTokenMapper;
import com.tcm.community.model.UserAcc;
import com.tcm.community.model.UserFollow;
import com.tcm.community.model.UserToken;
import com.tcm.community.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InteractiveService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserAccMapper userAccMapper;
    @Autowired
    private UserFollowMapper userFollowMapper;
    @Autowired
    private UserTokenMapper userTokenMapper;

    //bravo
    public void bravo(int uid,int entityType,int entityId){
        String entityBravoKey = RedisKeyUtil.getBravoEntityKey(entityType,entityId);

        boolean isMember = redisTemplate.opsForSet().isMember(entityBravoKey,uid);
        if(isMember){
            redisTemplate.opsForSet().remove(entityBravoKey,uid);
        }else {
            redisTemplate.opsForSet().add(entityBravoKey,uid);
        }
    }

    //select bravo count
    public long findEntityBravoCount(int entityType,int entityId){
        String entityBravoKey = RedisKeyUtil.getBravoEntityKey(entityType,entityId);

        return redisTemplate.opsForSet().size(entityBravoKey);
    }

    //select someone whether bravo
    public int findEntityBravoStatus(int uid,int entityType,int entityId){
        String entityBravoKey = RedisKeyUtil.getBravoEntityKey(entityType,entityId);

        return redisTemplate.opsForSet().isMember(entityBravoKey,uid) ? 1 : 0;
    }

    /**
     * 查找是否有关注关系
     * @param token
     * @param uid 被关注人id
     * @return
     */
    public Map<String, Object> findFollow(String token, Integer uid) {
        Map<String, Object> map = new HashMap<>();
        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null) {
            map.put("returnMsg","user not exist!");
            return map;
        }

        UserFollow userFollow = userFollowMapper.findByUidFid(uid, existedToken.getUid());
        map.put("returnMsg", "success");
        map.put("result", userFollow);
        return map;
    }

    /**
     * 关注
     * @param userFollow
     * @return
     */
    public Map<String, Object> follow(String token, UserFollow userFollow) {
        Map<String, Object> map = new HashMap<>();
        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null) {
            map.put("returnMsg","user not exist!");
            return map;
        }

        userFollow.setFid(existedToken.getUid());

        userFollowMapper.insertUserFollow(userFollow);

        if (null == userFollow.getUfid()) {
            map.put("returnMsg", "failed");
            return map;
        }
        map.put("returnMsg", "success");

        return map;
    }

    /**
     * 取消关注
     * @param userFollow
     * @return
     */
    public Map<String, Object> unFollow(String token, UserFollow userFollow) {
        Map<String, Object> map = new HashMap<>();
        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null) {
            map.put("returnMsg","user not exist!");
            return map;
        }

        userFollowMapper.deleteUserFollow(userFollow.getUid(), existedToken.getUid());
        map.put("returnMsg", "success");
        return map;
    }

    /**
     * 获取关注和粉丝数量
     * @param uid
     * @return
     */
    public Map<String, Object> getAttentionFollowCount(String token, Integer uid) {
        Map<String, Object> map = new HashMap<>();
        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null) {
            map.put("returnMsg","user not exist!");
            return map;
        }

        if (0 == uid) {
            uid = existedToken.getUid();
        }

        Integer attentionCount = userFollowMapper.getAttentionCount(uid);
        Integer followCount = userFollowMapper.getFollowCount(uid);
        map.put("returnMsg", "success");
        map.put("attentionCount", attentionCount);
        map.put("followCount", followCount);
        return map;
    }

    /**
     * 获取关注列表
     * @return
     */
    public Map<String, Object> getAttentionSet(String token) {
        Map<String, Object> map = new HashMap<>();
        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null) {
            map.put("returnMsg","user not exist!");
            return map;
        }

        Set<Integer> attentionSet = userFollowMapper.getAttentionSet(existedToken.getUid());
        List<UserAcc> userAccList = new ArrayList<>();
        for (Integer id : attentionSet) {
            UserAcc userAcc = userAccMapper.findById(id);
            userAccList.add(userAcc);
        }
        map.put("returnMsg", "success");
        map.put("result", userAccList);
        return map;
    }

    /**
     * 获取粉丝列表
     * @return
     */
    public Map<String, Object> getFollowSet(String token) {
        Map<String, Object> map = new HashMap<>();
        UserToken existedToken = userTokenMapper.findByToken(token);
        if(existedToken == null) {
            map.put("returnMsg","user not exist!");
            return map;
        }

        Set<Integer> followSet = userFollowMapper.getFollowSet(existedToken.getUid());
        List<UserAcc> userAccList = new ArrayList<>();
        for (Integer id : followSet) {
            UserAcc userAcc = userAccMapper.findById(id);
            userAccList.add(userAcc);
        }
        map.put("returnMsg", "success");
        map.put("result", userAccList);
        return map;
    }

}
