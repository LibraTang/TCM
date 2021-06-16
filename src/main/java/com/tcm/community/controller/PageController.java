package com.tcm.community.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")  //localhost:8080/    *recommend to use this method
    public String index(){
        return "index";      //templates/index.html  and have kv
    }

    @RequestMapping("/registerpg")
    public String registerpg(){
        return "page/login/register";
    }

    @RequestMapping("/loginpg")
    public String loginpg(){
        return "page/login/login";
    }

    @RequestMapping("/homepagepg")
    public String homepagepg(){
        return "page/user/homepage";
    }

    @RequestMapping("/detailinfopg")
    public String detailinfopg(){
        return "page/user/detailinfo";
    }

    @RequestMapping("/changeinfopg")
    public String changeinfopg(){
        return "page/user/changeinfo";
    }

}
