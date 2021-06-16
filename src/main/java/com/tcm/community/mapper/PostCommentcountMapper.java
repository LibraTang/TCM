package com.tcm.community.mapper;

import com.tcm.community.model.PostCommentcount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCommentcountMapper {

    PostCommentcount findByPid(Long pid);

    void insertPostCommentcount(PostCommentcount postCommentcount);

    void updatePostCommentcount(PostCommentcount postCommentcount);
}
