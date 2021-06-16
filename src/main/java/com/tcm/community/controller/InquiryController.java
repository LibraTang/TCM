package com.tcm.community.controller;

import com.tcm.community.model.InquiryDetail;
import com.tcm.community.model.InquiryPrescription;
import com.tcm.community.model.InquiryRate;
import com.tcm.community.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {
    @Autowired
    private InquiryService inquiryService;

    /**
     * 用户创建问诊
     * @param token
     * @param inquiryDetail
     * @return
     */
    @PostMapping("/detail")
    @ResponseBody
    public Map<String, Object> createInquiry(@RequestHeader("token") String token,
                                             @RequestBody InquiryDetail inquiryDetail) {
        Map<String, Object> map = inquiryService.createInquiry(token, inquiryDetail);
        return map;
    }

    /**
     * 获取问诊详情
     * @param token
     * @param idid
     * @return
     */
    @GetMapping("/detail/{idid}")
    @ResponseBody
    public Map<String, Object> getInquiry(@RequestHeader("token") String token,
                                          @PathVariable("idid") Integer idid) {
        Map<String, Object> map = inquiryService.getInquiry(token, idid);
        return map;
    }

    /**
     * 获取用户的问诊列表
     * @param token
     * @return
     */
    @GetMapping("/detailList")
    @ResponseBody
    public Map<String, Object> listInquiry(@RequestHeader("token") String token) {
        Map<String, Object> map = inquiryService.getInquiryList(token);
        return map;
    }

    /**
     * 获取医生的问诊列表
     * @param token
     * @return
     */
    @GetMapping("/doctor")
    @ResponseBody
    public Map<String, Object> listDoctorInquiry(@RequestHeader("token") String token) {
        Map<String, Object> map = inquiryService.getDoctorInquiryList(token);
        return map;
    }

    /**
     * 医生提供问诊处方
     * @param token
     * @param inquiryPrescription
     * @return
     */
    @PostMapping("/prescription")
    @ResponseBody
    public Map<String, Object> createInquiryPrescription(@RequestHeader("token") String token,
                                                         @RequestBody InquiryPrescription inquiryPrescription) {
        Map<String, Object> map = inquiryService.createInquiryPrescription(token, inquiryPrescription);
        return map;
    }

    /**
     * 获取问诊处方
     * @param token
     * @param idid
     * @return
     */
    @GetMapping("/prescription/{idid}")
    @ResponseBody
    public Map<String, Object> getInquiryPrescription(@RequestHeader("token") String token,
                                                      @PathVariable("idid") Integer idid) {
        Map<String, Object> map = inquiryService.getInquiryPrescriptionByIdid(token, idid);
        return map;
    }

    /**
     * 用户给问诊评分
     * @param token
     * @param inquiryRate
     * @return
     */
    /*
    @PostMapping("/rate")
    @ResponseBody
    public Map<String, Object> createInquiryRate(@RequestHeader("token") String token,
                                                 @RequestBody InquiryRate inquiryRate) {
        Map<String, Object> map = inquiryService.createInquiryRate(token, inquiryRate);
        return map;
    }
     */


}
