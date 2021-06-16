package com.tcm.community.mapper;

import com.tcm.community.model.NotifyFollow;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotifyFollowMapper {

    List<NotifyFollow> findAll();

    void saveNotifyFollow(NotifyFollow notifyFollow);

    void updateNotifyFollow(NotifyFollow notifyFollow);

    void deleteNotifyFollow(Integer nfid);

}
