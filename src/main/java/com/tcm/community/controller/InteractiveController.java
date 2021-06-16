package com.tcm.community.controller;

import com.tcm.community.model.UserFollow;
import com.tcm.community.service.InteractiveService;
import com.tcm.community.util.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 *@version 1.0
 *@author rajon
 *<p>Function:  relevent to interactive behavior like bravo,follow,fans
 */
@Controller
@RequestMapping(value = "/interactive")
public class InteractiveController {

    @Autowired
    private InteractiveService interactiveService;

    /**
     * <p>Function:  bravo
     * <p>API:       User/Institude:  /interactive/bravo
     * <p>needparams: token=""
     * <p>return: {"province": "","city": "","sex":"0"/"isidenti": "0","location": "","tag": "","pic": "","type": "","age": "0","email": "","selfintro": ""}
     * <p>        {"logoutMsg":"empty string!"}/{"logoutMsg":"user not exist!"}/{"fail":"null"}/{"authorityMsg":"auth error!"}
     */
    @RequestMapping(value = "/bravo",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> bravo(String token){
        Map<String,Object> map = new HashMap<>();
        map = ReturnData.mapIsNull(map,"fail","null");

        return map;
    }

    /**
     * <p>Function:  unbravo
     * <p>API:       User/Institude:  /interactive/unbravo
     * <p>needparams: token=""
     * <p>return: {"province": "","city": "","sex":"0"/"isidenti": "0","location": "","tag": "","pic": "","type": "","age": "0","email": "","selfintro": ""}
     * <p>        {"logoutMsg":"empty string!"}/{"logoutMsg":"user not exist!"}/{"fail":"null"}/{"authorityMsg":"auth error!"}
     */
    @RequestMapping(value = "/unbravo",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> unbravo(String token){
        Map<String,Object> map = new HashMap<>();
        map = ReturnData.mapIsNull(map,"fail","null");

        return map;
    }

    @GetMapping("/findFollow/{uid}")
    @ResponseBody
    public Map<String, Object> findFollow(@RequestHeader("token") String token, @PathVariable Integer uid) {
        return interactiveService.findFollow(token, uid);
    }

    /**
     * <p>Function:  follow
     * <p>API:       User/Institude:  /interactive/follow
     * <p>needparams: token=""
     * <p>return: {"province": "","city": "","sex":"0"/"isidenti": "0","location": "","tag": "","pic": "","type": "","age": "0","email": "","selfintro": ""}
     * <p>        {"logoutMsg":"empty string!"}/{"logoutMsg":"user not exist!"}/{"fail":"null"}/{"authorityMsg":"auth error!"}
     */
    @RequestMapping(value = "/follow",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> follow(@RequestHeader("token") String token, @RequestBody UserFollow userFollow){
        return interactiveService.follow(token, userFollow);
    }

    /**
     * <p>Function:  unfollow
     * <p>API:       User/Institude:  /interactive/unfollow
     * <p>needparams: token=""
     * <p>return: {"province": "","city": "","sex":"0"/"isidenti": "0","location": "","tag": "","pic": "","type": "","age": "0","email": "","selfintro": ""}
     * <p>        {"logoutMsg":"empty string!"}/{"logoutMsg":"user not exist!"}/{"fail":"null"}/{"authorityMsg":"auth error!"}
     */
    @RequestMapping(value = "/unFollow",method = {RequestMethod.PUT})
    @ResponseBody
    public Map<String,Object> unFollow(@RequestHeader("token") String token, @RequestBody UserFollow userFollow) {
        return interactiveService.unFollow(token, userFollow);
    }

    @GetMapping("/attentionFollowCount/{uid}")
    @ResponseBody
    public Map<String, Object> getAttentionFollowCount(@RequestHeader("token") String token, @PathVariable Integer uid) {
        return interactiveService.getAttentionFollowCount(token, uid);
    }

    @GetMapping("/attentionDetail")
    @ResponseBody
    public Map<String, Object> getAttentionSet(@RequestHeader("token") String token) {
        return interactiveService.getAttentionSet(token);
    }

    @GetMapping("/followDetail")
    @ResponseBody
    public Map<String, Object> getFollowSet(@RequestHeader("token") String token) {
        return interactiveService.getFollowSet(token);
    }
}
