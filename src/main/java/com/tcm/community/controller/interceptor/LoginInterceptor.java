package com.tcm.community.controller.interceptor;

import com.tcm.community.mapper.UserTokenMapper;
import com.tcm.community.model.UserToken;
import com.tcm.community.util.InterceptorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserTokenMapper userTokenMapper;

    //before controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = InterceptorUtil.getValue(request,"token");
        if(token != null){
            UserToken existedToken = userTokenMapper.findByToken(token);
            Date date = new Date();
            Long time = date.getTime();
            if(existedToken != null && existedToken.getExpired() > time){
                return true;
            }
            return false;
        }
        return false;
    }
}
