package com.tcm.community.mapper;

import com.tcm.community.model.PostDc;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDcMapper {

    List<PostDc> findByPid(long pid);

    void insertPostDc(PostDc postDc);

    void updatePostDc(PostDc postDc);

    void delete(Integer pdcid);

}
