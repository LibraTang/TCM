package com.tcm.community.mapper;

import com.tcm.community.model.PostDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PostDetailMapper {

    PostDetail findByPid(int pid);

    List<PostDetail> getPostList();

    void insertPostDetail(PostDetail postDetail);

    void updatePostDetail(PostDetail postDetail);

    void deletePostDetail(long pid);

    List<PostDetail> findByUid(Set<Integer> userSet);

}
