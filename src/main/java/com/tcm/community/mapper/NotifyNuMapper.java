package com.tcm.community.mapper;

import com.tcm.community.model.NotifyNu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotifyNuMapper {

    List<NotifyNu> findAll();

    void saveNotifyNu(NotifyNu notifyNu);

    void updateNotifyNu(NotifyNu notifyNu);

    void deleteNotifyNu(Integer nuid);

}
