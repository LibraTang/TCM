package com.tcm.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Component
public class RandomUtil {

    public static String generateUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static String md5Encode(String key){
        if(StringUtils.isBlank(key)){
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
