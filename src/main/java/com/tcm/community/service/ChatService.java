package com.tcm.community.service;

import com.tcm.community.mapper.ChatMapper;
import com.tcm.community.model.Chat;
import com.tcm.community.util.SensitiveFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatMapper chatMapper;

    @Autowired
    private SensitiveFilter sensitiveFilter;

    public List<Chat> findChat(int uid,int offset,int limit){
        return chatMapper.findChat(uid,offset,limit);
    }

    public int findChatCount(int uid){
        return chatMapper.findChatCount(uid);
    }

    public List<Chat> findContents(String chatid,int offset,int limit){
        return chatMapper.findContents(chatid,offset,limit);
    }

    public  int findContentsCount(String chatid){
        return chatMapper.findContentsCount(chatid);
    }

    public int findUnreadContentsCount(int uid,String chatid){
        return chatMapper.findUnreadContentsCount(uid,chatid);
    }

    public int addChat(Chat chat){
        chat.setContent(sensitiveFilter.filter(HtmlUtils.htmlEscape(chat.getContent())));
        return chatMapper.insertChat(chat);
    }

    public int readChat(List<Integer> cids){
        return chatMapper.updateStatus(cids,1);
    }
}
