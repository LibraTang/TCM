package com.tcm.community.mapper;

import com.tcm.community.model.PostBravo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostBravoMapper {

    List<PostBravo> findAll();

    void savePostBravo(PostBravo postBravo);

    void updatePostBravo(PostBravo postBravo);

    void delete(Integer pbid);

}
