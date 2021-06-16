package com.tcm.community.mapper;

import com.tcm.community.model.PostBravocount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostBravocountMapper {

    PostBravocount findByPid(Long pid);

    void insertPostBravocount(PostBravocount postBravocount);

    void updatePostBravocount(PostBravocount postBravocount);

    void deletePostBravocount(Integer pbvid);

}
