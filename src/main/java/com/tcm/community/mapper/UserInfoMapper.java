package com.tcm.community.mapper;

import com.tcm.community.model.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {

    UserInfo findByUiid(Integer uiid);

    void insertUserInfo(UserInfo userInfo);

    void updateUserInfo(UserInfo userInfo);

    void updateUserSex(UserInfo userInfo);

    void updateUserIsidenti(UserInfo userInfo);

    void updateUserHeader(UserInfo userInfo);

    List<UserInfo> listUserInfoByUiid(List<Integer> recommendUiidList);
}
