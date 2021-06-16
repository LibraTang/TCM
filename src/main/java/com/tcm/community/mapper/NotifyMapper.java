package com.tcm.community.mapper;

import com.tcm.community.model.Notify;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotifyMapper {

    List<Notify> findAll(Notify notify);

    void saveNotify(Notify notify);

    void updateNotify(Notify notify);

    void deleteNotify(Integer nid);

}
