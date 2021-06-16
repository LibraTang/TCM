package com.tcm.community.service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.tcm.community.model.Address;
import com.tcm.community.model.PlaceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddressService {

    @Value("${tencent.location.key}")
    private String key;

    /**
     * 获取地址的详细信息如经纬度
     * @param fullAddress 市-区-详细地址
     * @return
     */
    public Map<String, Object> getLocation(String fullAddress) {
        Map<String, Object> map = new HashMap<>();

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://apis.map.qq.com/ws/geocoder/v1/?address={?}&key={?}";
        String jsonData = restTemplate.getForObject(url, String.class, fullAddress, key);
        JSONObject jsonObject = JSONObject.parseObject(jsonData);

        map.put("lat", jsonObject.getJSONObject("result").getJSONObject("location").get("lat"));
        map.put("lng", jsonObject.getJSONObject("result").getJSONObject("location").get("lng"));
        map.put("returnMsg", "success");

        return map;
    }

    /**
     * 根据关键词匹配地点
     * @param keyword 关键词
     * @param region 区域（市）
     * @return
     */
    public PlaceList getPlaceList(String keyword, String region) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://apis.map.qq.com/ws/place/v1/suggestion/?region={?}&keyword={?}&key={?}";
        PlaceList placeList = restTemplate.getForObject(url, PlaceList.class, region, keyword, key);
        return placeList;
    }
}
