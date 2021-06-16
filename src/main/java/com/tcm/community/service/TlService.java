package com.tcm.community.service;


import com.tcm.community.mapper.*;
import com.tcm.community.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TlService {

    @Autowired
    private TlMapper tlMapper;

    @Autowired
    private TlTpMapper tlTpMapper;

    @Autowired
    private UserAccMapper userAccMapper;

    @Autowired
    private UserAinfoMapper userAinfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private PostCommentcountMapper postCommentcountMapper;

    @Autowired
    private PostBravocountMapper postBravocountMapper;

    public List<Map<String,Object>> visitorHomePage(int offset,int limit){

        List returnList = new ArrayList();
        List<Tl> list = tlMapper.getVisitorHomepage(offset,limit);

        for(Tl tl : list){
            Map<String,Object> map = new HashMap<>();
            TlTp tlTp = tlTpMapper.getTlTpByTlid(tl.getTlid());
            UserAcc userAcc = userAccMapper.findById(tlTp.getUid());
            UserAinfo userAinfo = userAinfoMapper.findByUid(tlTp.getUid());
            UserInfo userInfo = userInfoMapper.findByUiid(userAinfo.getUiid());
            PostCommentcount postCommentcount = postCommentcountMapper.findByPid(tlTp.getPid());
            PostBravocount postBravocount = postBravocountMapper.findByPid(tlTp.getPid());

            map.put("uid",userAcc.getUid());
            map.put("name",userAcc.getName());
            map.put("pic",userInfo.getPic());
            map.put("isidenti",userInfo.getIsidenti());

            map.put("tlid",tl.getTlid());
            map.put("title",tl.getTitle());
            map.put("intro",tl.getIntro());
            map.put("mtime",tl.getMtime());

            map.put("commentcount",postCommentcount.getCount());
            map.put("bravocount",postBravocount.getBravocount());

            returnList.add(map);
        }

        return returnList;
    }

    public int getTlCount(){

        int count = tlMapper.getTlCount();
        return count;
    }
}
