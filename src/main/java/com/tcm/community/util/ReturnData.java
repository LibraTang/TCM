package com.tcm.community.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ReturnData {

    public static Map<String,Object> mapIsNull(Map<String,Object> map, String key, String value){        //verify map is null

        if(map == null || map.isEmpty()){               //verify null
            map.put(key,value);

            return map;
        }else if(map.get("returnMsg") != null){
            map.put("returnMsg", map.get("returnMsg"));
            return map;
        }
        map.clear();
        return map;
    }

    public static List listIsNull(List list){        //verify map is null

        if(list == null || list.isEmpty()){               //verify null
            list.add(0,null);

            return list;
        }

        return list;
    }

    //alibaba's fastjson
    public static String getJSONString(int code,String msg,Map<String,Object> map){

        JSONObject json = new JSONObject();
        json.put("code",code);
        json.put("msg",msg);
        if(map != null){
            for(String key:map.keySet()){
                json.put(key,map.get(key));
            }
        }
        return json.toJSONString();
    }

    public static String getJSONString(int code,String msg){

        return getJSONString(code,msg,null);
    }

    public static String getJSONString(int code){

        return getJSONString(code,null,null);
    }
}
