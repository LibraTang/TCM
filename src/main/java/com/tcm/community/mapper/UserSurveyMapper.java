package com.tcm.community.mapper;

import com.tcm.community.model.UserSurvey;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSurveyMapper {

    /**
     * 根据usid查询问诊问卷
     * @param uid
     * @return
     */
    UserSurvey findByUid(Integer uid);

    /**
     * 插入问诊问卷问卷
     * @param userSurvey
     */
    void insertUserSurvey(UserSurvey userSurvey);

    /**
     * 修改问诊问卷
     * @param userSurvey
     */
    void updateUserSurvey(UserSurvey userSurvey);
}
