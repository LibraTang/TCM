package com.tcm.community.controller;

import com.tcm.community.model.UserInfo;
import com.tcm.community.model.UserSurvey;
import com.tcm.community.service.UserService;
import com.tcm.community.util.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *@version 1.0
 *@author rajon
 *<p>Function:  relevent to user's infomation and follow infomation
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * <p>Function:  provide user's detail infomation
     * <p>API:       User/Institude:  /user/info
     * <p>needparams: token:""
     * <p>true return: {"returnMsg":"true",
     *                  "name":""
     *                  "age":"",
     *                  "email":"",
     *                  "province":"",
     *                  "city":"",
     *                  "region":"",
     *                  "location":"",
     *                  "selfintro":"",
     *                  "pic":"",
     *                  "tag":"",
     *                  "sex":"",
     *                  "isidenti":""
     *                  "type":""
     *                  }
     * <p>false return: {
     *                  "returnMsg":
     *                  "empty string!/user not exist!/null
     *                  }
     */
    @RequestMapping(value = "/info",method = {RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> selectDetailInfo(@RequestHeader("token") String token){
        Map<String,Object> map = userService.displayInfo(token);
        map = ReturnData.mapIsNull(map,"returnMsg","null");

        return map;
    }

    @GetMapping("/othersInfo/{uid}")
    @ResponseBody
    public Map<String, Object> getOthersInfo(@RequestHeader("token") String token, @PathVariable Integer uid) {
        Map<String, Object> map = userService.getOthersInfo(token, uid);
        return map;
    }

    /**
     * <p>Function:  change user's detail infomation
     * <p>API:       User:   /user/userinfo
     * <p>needparams: token:"",
     *                "age":"",
     *                "sex":"",
     *                "email":"",
     *                "province":"",
     *                "city":"",
     *                "region":"",
     *                "location":"",
     *                "selfintro":"",
     *                "tag":"",
     *                "type":"",
     * <p>true return: {"returnMsg":"true"}
     * <p>false return: {
     *                  "returnMsg":
     *                  "empty string!/user not exist!
     *                  }
     */
    @PutMapping("/userinfo")
    @ResponseBody
    public Map<String,Object> changeUserInfo(@RequestHeader("token") String token, @RequestBody UserInfo userInfo){
        Map<String,Object> map = userService.changeUserInfo(token,userInfo);
        map = ReturnData.mapIsNull(map,"returnMsg","true");

        return map;
    }

    /**
     * 更改用户昵称
     * @param token
     * @param name 昵称
     * @return
     */
    @PutMapping("/userAcc")
    @ResponseBody
    public Map<String, Object> changeUsername(@RequestHeader("token") String token, String name) {
        Map<String, Object> map = userService.changeUsername(token, name);
        return map;
    }

    /**
     * <p>Function:  change user's headpic
     * <p>API:       User:   /user/header
     * <p>needparams: token:"",
     *                upload pic file
     * <p>true return: {"returnMsg":"true"}
     * <p>false return: {
     *                  "returnMsg":
     *                  "empty string!/user not exist!/error file format!/null
     *                  }
     */
    @RequestMapping(value = "/header",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> changeHeadPic(String token, MultipartFile header){

        Map<String,Object> map = userService.changeHeader(token,header);
        map = ReturnData.mapIsNull(map,"returnMsg","true");

        return map;
    }

    /**
     * <p>Function:  change user's password
     * <p>API:       User/Institude:  /user/changepd
     * <p>needparams: token="",
     *                "oldPword":"",
     *                "newPword":""
     * <p>true return: "returnMsg":"true"
     * <p>false return: {
     *                  "returnMsg":
     *                  "empty string!/user not exist!/old password wrong!
     *                  }
     */
    @RequestMapping(value = "/changepd",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> changePassword(String token,String oldpword,String newpword){

        Map<String,Object> map = new HashMap<>();
        if(oldpword.equals(newpword)){
            map.put("returnMsg","twice the same!");
            return map;
        }else {
            map = userService.changePassword(token,oldpword,newpword);
            map = ReturnData.mapIsNull(map,"returnMsg","true");

            return map;
        }
    }

    /**
     * <p>Function:  provide user's homepage
     * <p>API:       User/Institude:  /user/homepage
     * <p>needparams: token:""
     * <p>true return: "returnMsg":"true",
     *                "name":"",
     *                "pic":"",
     *                "tag":"",
     *                "followcount":"",
     *                "fanscount":"",
     *                "sex":"",
     *                "isidenti":""
     * <p>false return: {
     *                  "returnMsg":
     *                  "empty string!/user not exist!/null
     *                  }
     */
    @RequestMapping(value = "/homepage",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> displayHomepage(String token){

        Map<String,Object> map = userService.displayHomepage(token,-1);
        map = ReturnData.mapIsNull(map,"returnMsg","null");

        return map;
    }

    /**
     * <p>Function:  provide user's homepage
     * <p>API:       User/Institude:  /user/homepage/{pid}
     * <p>needparams: pid:""
     * <p>true return: "returnMsg":"true",
     *                "name":"",
     *                "pic":"",
     *                "tag":"",
     *                "followcount":"",
     *                "fanscount":"",
     *                "sex":"",
     *                "isidenti":""
     * <p>false return: {
     *                  "returnMsg":
     *                  "empty string!/user not exist!/null
     *                  }
     */
    @RequestMapping(value = "/homepage/{pid}",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> displayHomepage(@PathVariable("pid") int pid){

        Map<String,Object> map = userService.displayHomepage("null",pid);
        map = ReturnData.mapIsNull(map,"returnMsg","null");

        return map;
    }

    @PostMapping("/userSurvey")
    @ResponseBody
    public Map<String, Object> insertUserSurvey(@RequestHeader("token") String token, @RequestBody UserSurvey userSurvey) {
        Map<String, Object> map = userService.insertUserSurvey(userSurvey, token);
        map = ReturnData.mapIsNull(map, "returnMsg", "null");

        return map;
    }

    @PutMapping("/userSurvey")
    @ResponseBody
    public Map<String, Object> updateUserSurvey(@RequestHeader("token") String token, @RequestBody UserSurvey userSurvey) {
        Map<String, Object> map = userService.updateUserSurvey(userSurvey, token);
        map = ReturnData.mapIsNull(map, "returnMsg", "null");

        return map;
    }

    @GetMapping("/userSurvey/{uid}")
    @ResponseBody
    public Map<String, Object> findUserSurveyByUsid(@RequestHeader("token") String token, @PathVariable Integer uid) {
        Map<String, Object> map = userService.getUserSurveyByUid(uid, token);
        return map;
    }

    @GetMapping("/userRecommend/{type}")
    @ResponseBody
    public Map<String, Object> listUserRecommendByType(@RequestHeader("token") String token, @PathVariable Integer type) {
        Map<String, Object> map = userService.listUserRecommendByType(type, token);
        return map;
    }
}
