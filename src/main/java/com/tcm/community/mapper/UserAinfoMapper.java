package com.tcm.community.mapper;

import com.tcm.community.model.UserAinfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAinfoMapper {

    UserAinfo findByUid(Integer uid);

    void insertUserAinfo(UserAinfo userAinfo);

    List<Integer> listUiidByUid(List<Integer> uidList);

}
