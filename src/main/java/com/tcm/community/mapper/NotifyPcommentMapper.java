package com.tcm.community.mapper;

import com.tcm.community.model.NotifyPcomment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotifyPcommentMapper {

    List<NotifyPcomment> findAll();

    void saveNotifyPcomment(NotifyPcomment notifyPcomment);

    void updateNotifyPcomment(NotifyPcomment notifyPcomment);

    void deleteNotifyPcomment(Integer npcmid);

}
