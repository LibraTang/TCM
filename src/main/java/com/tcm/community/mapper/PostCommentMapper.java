package com.tcm.community.mapper;

import com.tcm.community.model.PostComment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCommentMapper {

    PostComment findCommentByPcmid(long pcmid);

    void insertPostComment(PostComment postComment);

    void updatePostComment(PostComment postComment);

    void deletePostComment(Integer pcmid);

}
