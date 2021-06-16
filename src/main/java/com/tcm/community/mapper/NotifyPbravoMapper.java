package com.tcm.community.mapper;

import com.tcm.community.model.NotifyPbravo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotifyPbravoMapper {

    List<NotifyPbravo> findAll();

    void saveNotifyPbravo(NotifyPbravo notifyPbravo);

    void updateNotifyPbravo(NotifyPbravo notifyPbravo);

    void deleteNotifyPbravo(Integer npbid);

}
