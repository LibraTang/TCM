package com.tcm.community.mapper;

import com.tcm.community.model.PostCc;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCcMapper {

    List<PostCc> findByPcmid(long pcmid);
}
