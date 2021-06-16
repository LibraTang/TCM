package com.tcm.community.mapper;

import com.tcm.community.model.UserAcc;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccMapper {

    UserAcc findById(Integer uid);

    UserAcc findByUname(String uname);

    List<UserAcc> findByName(String uname);

    void insertUserAcc(UserAcc userAcc);

    void updateUserAcc(UserAcc userAcc);

    void updatePwordSalt(UserAcc userAcc);
    void updateName(UserAcc userAcc);
    void updateAuth(UserAcc userAcc);
    void updateUnameIsdel(UserAcc userAcc);

    void deleteUserAcc(UserAcc userAcc);
}