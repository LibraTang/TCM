package com.tcm.community.mapper;

import com.tcm.community.model.UserRecommend;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRecommendMapper {
    /**
     * 获取对应医生的推荐信息
     * @param uid
     * @return
     */
    UserRecommend findByUid(Integer uid);

    /**
     * 获取对应科室的医生列表
     * @param type
     * @return
     */
    List<UserRecommend> listByType(Integer type);

    /**
     * 插入一个新的医生推荐信息
     * @param userRecommend
     */
    void insertUserRecommend(UserRecommend userRecommend);

    /**
     * 修改一个医生的推荐信息
     * @param userRecommend
     */
    void updateUserRecommendByUid(UserRecommend userRecommend);
}
