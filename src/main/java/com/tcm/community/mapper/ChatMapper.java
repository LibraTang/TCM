package com.tcm.community.mapper;

import com.tcm.community.model.Chat;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMapper {

    List<Chat> findChat(int uid,int offset,int limit);//user's chat list   sysuser uid = 1

    int findChatCount(int uid);//current user chat count

    List<Chat> findContents(String chatid,int offset,int limit);//contents in one chat

    int findContentsCount(String chatid);//contents count in one chat

    int findUnreadContentsCount(int uid,String chatid);//contents unread count

    int insertChat(Chat chat);//add chat

    int updateStatus(List<Integer> cids,int status);//change status

}
