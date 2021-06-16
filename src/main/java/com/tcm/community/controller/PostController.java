package com.tcm.community.controller;

import com.tcm.community.model.PostComment;
import com.tcm.community.model.PostDetail;
import com.tcm.community.service.PostService;
import com.tcm.community.util.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 *@version 1.0
 *@author rajon
 *<p>Function:  relevent to post and comment
 */
@Controller
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * <p>Function:  add post detail
     * <p>API:       User/Institude:  /post/addpost
     * <p>needparams: postdetail="......",token=""
     * <p>return: {"province": "","city": "","sex":"0"/"isidenti": "0","location": "","tag": "","pic": "","type": "","age": "0","email": "","selfintro": ""}
     * <p>        {"logoutMsg":"empty string!"}/{"logoutMsg":"user not exist!"}/{"fail":"null"}/{"authorityMsg":"auth error!"}
     */
    @PostMapping("/addpost")
    @ResponseBody
    public Map<String,Object> addPost(@RequestBody PostDetail postDetail, @RequestHeader("token") String token){
        Map<String,Object> map = postService.addPost(postDetail,token);
        if(map.containsKey("pid")){
            map.put("returnMsg","true");
            return map;
        }
        map.put("returnMsg","failed");
        return map;
    }

    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> getPostList(@RequestHeader("token") String token) {
        Map<String, Object> map = postService.getPostList(token);
        return map;
    }

    /**
     * <p>Function:  post detail page
     * <p>API:       User/Institude:  /post/detail/{pid}
     * <p>needparams: token=""
     * <p>return: {"province": "","city": "","sex":"0"/"isidenti": "0","location": "","tag": "","pic": "","type": "","age": "0","email": "","selfintro": ""}
     * <p>        {"logoutMsg":"empty string!"}/{"logoutMsg":"user not exist!"}/{"fail":"null"}/{"authorityMsg":"auth error!"}
     */
    @GetMapping("/detail/{pid}")
    @ResponseBody
    public Map<String,Object> getPostDetail(@RequestHeader("token") String token, @PathVariable("pid") int pid){
        Map<String,Object> map = postService.getPostDetail(pid);
        return map;
    }

    /**
     * <p>Function:  change post detail
     * <p>API:       User/Institude:  /post/changepost
     * <p>needparams: token="",postdteail(have pid)
     * <p>return: {"province": "","city": "","sex":"0"/"isidenti": "0","location": "","tag": "","pic": "","type": "","age": "0","email": "","selfintro": ""}
     * <p>        {"logoutMsg":"empty string!"}/{"logoutMsg":"user not exist!"}/{"fail":"null"}/{"authorityMsg":"auth error!"}
     */
    @RequestMapping(value = "/changepost",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> changePostDetail(PostDetail postDetail,String token){
        Map<String,Object> map = postService.changePostDetail(postDetail,token);
        map = ReturnData.mapIsNull(map,"success","true");

        return map;
    }

    /**
     * <p>Function:  delete post
     * <p>API:       User/Institude:  /post/delete
     * <p>needparams: token=""
     * <p>return: {"province": "","city": "","sex":"0"/"isidenti": "0","location": "","tag": "","pic": "","type": "","age": "0","email": "","selfintro": ""}
     * <p>        {"logoutMsg":"empty string!"}/{"logoutMsg":"user not exist!"}/{"fail":"null"}/{"authorityMsg":"auth error!"}
     */
    @RequestMapping(value = "/delete",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> deletePost(String token, int pid){
        Map<String,Object> map = postService.deletePostDetail(pid,token);
        map = ReturnData.mapIsNull(map,"success","true");

        return map;
    }

    /**
     * <p>Function:  comment post
     * <p>API:       User/Institude:  /post/comment/{pid}
     * <p>needparams: token=""
     * <p>return: {"province": "","city": "","sex":"0"/"isidenti": "0","location": "","tag": "","pic": "","type": "","age": "0","email": "","selfintro": ""}
     * <p>        {"logoutMsg":"empty string!"}/{"logoutMsg":"user not exist!"}/{"fail":"null"}/{"authorityMsg":"auth error!"}
     */
    @RequestMapping(value = "/comment/{pid}",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> addPostComment(@RequestHeader("token") String token,
                                             @PathVariable("pid") Long pid,
                                             @RequestBody PostComment postComment){
        Map<String,Object> map = new HashMap<>();
        map = postService.insertPostComment(token, pid, postComment);

        return map;
    }

    /**
     * <p>Function:  reply comment post
     * <p>API:       User/Institude:  /post/reply/{pcid}
     * <p>needparams: token=""
     * <p>return: {"province": "","city": "","sex":"0"/"isidenti": "0","location": "","tag": "","pic": "","type": "","age": "0","email": "","selfintro": ""}
     * <p>        {"logoutMsg":"empty string!"}/{"logoutMsg":"user not exist!"}/{"fail":"null"}/{"authorityMsg":"auth error!"}
     */
    @RequestMapping(value = "/reply/{pcid}",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> addReplyComment(String token, @PathVariable("pcid") int pcid){
        Map<String,Object> map = new HashMap<>();
        map = ReturnData.mapIsNull(map,"fail","null");

        return map;
    }

    /**
     * <p>Function:  comment delete
     * <p>API:       User/Institude:  /post/dcomment/{pcid}
     * <p>needparams: token=""
     * <p>return: {"province": "","city": "","sex":"0"/"isidenti": "0","location": "","tag": "","pic": "","type": "","age": "0","email": "","selfintro": ""}
     * <p>        {"logoutMsg":"empty string!"}/{"logoutMsg":"user not exist!"}/{"fail":"null"}/{"authorityMsg":"auth error!"}
     */
    @RequestMapping(value = "/dcomment/{pcid}",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> deletePostComment(String token, @PathVariable("pcid") int pcid){
        Map<String,Object> map = new HashMap<>();
        map = ReturnData.mapIsNull(map,"fail","null");

        return map;
    }

    /**
     * <p>Function:  reply delete
     * <p>API:       User/Institude:  /post/dreply/{pcid}
     * <p>needparams: token=""
     * <p>return: {"province": "","city": "","sex":"0"/"isidenti": "0","location": "","tag": "","pic": "","type": "","age": "0","email": "","selfintro": ""}
     * <p>        {"logoutMsg":"empty string!"}/{"logoutMsg":"user not exist!"}/{"fail":"null"}/{"authorityMsg":"auth error!"}
     */
    @RequestMapping(value = "/dreply/{pcrid}",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> deleteReplyComment(String token, @PathVariable("pcrid") int pcrid){
        Map<String,Object> map = new HashMap<>();
        map = ReturnData.mapIsNull(map,"fail","null");

        return map;
    }

    @GetMapping("/attention")
    @ResponseBody
    public Map<String, Object> getAttentionPost(@RequestHeader("token") String token) {
        return postService.getAttentionPost(token);
    }
}
