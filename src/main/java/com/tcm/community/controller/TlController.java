package com.tcm.community.controller;

import com.tcm.community.service.TlService;
import com.tcm.community.util.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@version 1.0
 *@author rajon
 *<p>Function:  relevent to timeline
 */
@Controller
@RequestMapping(value = "/tl")
public class TlController {

    @Autowired
    private TlService tlService;

    /**
     * <p>Function:  add post detail
     * <p>API:       User/Institude:  /tl/visitor
     * <p>needparams: token=""
     * <p>return: {"province": "","city": "","sex":"0"/"isidenti": "0","location": "","tag": "","pic": "","type": "","age": "0","email": "","selfintro": ""}
     * <p>        {"logoutMsg":"empty string!"}/{"logoutMsg":"user not exist!"}/{"fail":"null"}/{"authorityMsg":"auth error!"}
     */
    @RequestMapping(value = "/visitor",method = {RequestMethod.POST})
    @ResponseBody
    public List<Map<String,Object>> visitorHomePage(int offset,int limit){
        List<Map<String,Object>> list = tlService.visitorHomePage(offset,limit);
        list = ReturnData.listIsNull(list);

        return list;
    }
}
