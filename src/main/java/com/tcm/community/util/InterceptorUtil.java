package com.tcm.community.util;

import javax.servlet.http.HttpServletRequest;

public class InterceptorUtil {

    public static String getValue(HttpServletRequest request,String key){
        if(request == null || key == null){
            throw new IllegalArgumentException("params cant empty!");
        }

        String value = request.getParameter(key);
        if(value != null){
            return value;
        }
        return null;
    }
}
