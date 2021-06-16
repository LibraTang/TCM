package com.tcm.community.controller;

import com.tcm.community.model.UserAcc;
import com.tcm.community.service.UserService;
import com.tcm.community.util.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 *@version 1.0
 *@author rajon
 *<p>Function:  LoginController,use to register or login ...
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * <p>Function:  register
     * <p>API:       User/Institude:  /register
     * <p>needparams: uname="(telephone)",pword="",auth=0/1
     * <p>true return: {"returnMsg":"true"}
     * <p>false return: {
     *                  "returnMsg":
     *                  "params cant all empty!/username cant empty!/
     *                  username error length!/password cant empty!/
     *                  auth cant empty!/auth error!"/username has existed!
     *                  }
     */
    @RequestMapping(value = "/register",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> register(UserAcc userAcc){

        Map<String,Object> map =  userService.register(userAcc);
        map = ReturnData.mapIsNull(map,"returnMsg","true");

        return map;
    }

    /**
     * <p>Function:  login
     * <p>API:       User/Institude:  /login
     * <p>needparams: uname="(telephone)",pword=""
     * <p>true return: {"returnMsg":"true","token":"","expired":""}
     * <p>false return: {
     *                  "returnMsg":
     *                  "params cant all empty!/username cant empty!/
     *                  password cant empty!/password wrong!/null/
     *                  auth cant empty!/auth error!"/username not exist!
     *                  }
     */
    @PostMapping("/login")
    @ResponseBody
    public Map<String,Object> login(UserAcc userAcc){
        Map<String,Object> map = userService.login(userAcc);
        map = ReturnData.mapIsNull(map,"returnMsg","null");
        return map;
    }

    /**
     * <p>Function:  logout
     * <p>API:       User/Institude:  /logout
     * <p>needparams: token=""
     * <p>true return: {"returnMsg":"true"}
     * <p>false return: {
     *                  "returnMsg":
     *                  "empty string!/user not login!
     *                  }
     */
    @RequestMapping(value = "/logout",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> logout(String token){
        Map<String,Object> map = userService.logout(token);

        if(map.containsKey("uid") && map.get("uid") != null){
            map.remove("uid");                     //not provide uid to app
            map = ReturnData.mapIsNull(map,"returnMsg","true");
            return map;
        }

        return  map;
    }

    /**
     * <p>Function:  delete user
     * <p>API:       User/Institude:  /delete
     * <p>needparams: token=""
     * <p>true return: {"returnMsg":"true"}
     * <p>false return: {
     *                  "returnMsg":
     *                  "empty string!/user not login!/user not exist!
     *                  }
     */
    @RequestMapping(value = "/delete",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> delete(String token){
        Map<String,Object> map = userService.delete(token);

        if(map.containsKey("uid") && map.get("uid") != null){
            map.remove("uid");                     //not provide uid to app
            map = ReturnData.mapIsNull(map,"returnMsg","true");
            return map;
        }

        return  map;
    }
}
