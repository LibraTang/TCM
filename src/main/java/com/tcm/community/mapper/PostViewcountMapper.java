package com.tcm.community.mapper;

import com.tcm.community.model.PostViewcount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostViewcountMapper {

    PostViewcount findByPid(Long pid);

    void insertPostViewcount(PostViewcount postViewcount);
}
