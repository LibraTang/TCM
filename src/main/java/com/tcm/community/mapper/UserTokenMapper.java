package com.tcm.community.mapper;

import com.tcm.community.model.UserToken;
import org.springframework.stereotype.Repository;


@Repository
public interface UserTokenMapper {

    UserToken findByUid(Integer uid);

    UserToken findByToken(String token);

    void insertUserToken(UserToken userToken);

    void updateUserToken(UserToken userToken);

}
