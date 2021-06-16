package com.tcm.community.controller;

import com.tcm.community.model.Address;
import com.tcm.community.model.PlaceList;
import com.tcm.community.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author tjm
 * @desc 位置相关服务
 */
@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/geoCoder")
    @ResponseBody
    public Map<String, Object> geoCoder(String fullAddress) {
        return addressService.getLocation(fullAddress);
    }

    @GetMapping("/suggestion")
    @ResponseBody
    public PlaceList suggestion(String keyword, String region) {
        return addressService.getPlaceList(keyword, region);
    }
}
