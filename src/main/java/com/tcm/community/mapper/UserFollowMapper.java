package com.tcm.community.mapper;

import com.tcm.community.model.UserFollow;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserFollowMapper {

    UserFollow findByUidFid(Integer uid,Integer fid);

    Set<Integer> getAttentionSet(Integer uid); //guanzhuxiangxi

    Set<Integer> getFollowSet(Integer fid); //fensixiangxi

    Integer getFollowCount(Integer uid);//fensishuliang

    Integer getAttentionCount(Integer uid);//guanzhushuliang

    void insertUserFollow(UserFollow userFollow);

    void deleteUserFollow(Integer uid, Integer fid);

}
