package com.tcm.community.service;

import com.tcm.community.mapper.*;
import com.tcm.community.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InquiryService {

    @Autowired
    private InquiryDetailMapper inquiryDetailMapper;

    @Autowired
    private InquiryPrescriptionMapper inquiryPrescriptionMapper;

    @Autowired
    private InquiryRateMapper inquiryRateMapper;

    @Autowired
    private UserTokenMapper userTokenMapper;

    @Autowired
    private UserAccMapper userAccMapper;

    @Autowired
    private UserRecommendMapper userRecommendMapper;

    /**
     * 用户创建问诊详情
     * @param token
     * @param inquiryDetail
     * @return
     */
    public Map<String, Object> createInquiry(String token, InquiryDetail inquiryDetail) {
        Map<String, Object> map = new HashMap<>();

        if(token == null || "".equals(token)){
            map.put("returnMsg","empty token!");
            return map;
        }

        UserToken userToken = userTokenMapper.findByToken(token);
        if (null == userToken) {
            map.put("returnMsg", "user not existed!");
            return map;
        }

        inquiryDetail.setUid(userToken.getUid());
        inquiryDetailMapper.insertInquiryDetail(inquiryDetail);
        if (null != inquiryDetail.getIdid()) {
            map.put("returnMsg", "success");
            map.put("result", inquiryDetail);
        } else {
            map.put("returnMsg", "failed");
        }

        return map;
    }

    /**
     * 获取问诊详情
     * @param token
     * @param idid
     * @return
     */
    public Map<String, Object> getInquiry(String token, Integer idid) {
        Map<String, Object> map = new HashMap<>();

        if(token == null || "".equals(token)){
            map.put("returnMsg","empty token!");
            return map;
        }
        UserToken userToken = userTokenMapper.findByToken(token);
        UserAcc userAcc = userAccMapper.findById(userToken.getUid());

        InquiryDetail inquiryDetail = inquiryDetailMapper.getInquiryDetailByIdid(idid);
        if (null == inquiryDetail) {
            map.put("returnMsg", "failed");
            return map;
        }

        InquiryDetailBo inquiryDetailBo = new InquiryDetailBo();
        inquiryDetailBo.setIdid(inquiryDetail.getIdid());
        inquiryDetailBo.setUid(inquiryDetail.getUid());
        inquiryDetailBo.setName(userAccMapper.findById(inquiryDetail.getUid()).getName());
        inquiryDetailBo.setDoctorId(inquiryDetail.getDoctor());
        inquiryDetailBo.setDoctor(userAccMapper.findById(inquiryDetail.getDoctor()).getName());
        inquiryDetailBo.setContent(inquiryDetail.getContent());
        inquiryDetailBo.setType(DoctorTypeEnum.getValue(inquiryDetail.getType().toString()));

        map.put("returnMsg", "success");
        map.put("result", inquiryDetailBo);

        return map;
    }

    /**
     * 获取用户的问诊列表
     * @param token
     * @return
     */
    public Map<String, Object> getInquiryList(String token) {
        Map<String, Object> map = new HashMap<>();

        if(token == null || "".equals(token)){
            map.put("returnMsg","empty token!");
            return map;
        }

        // 获取用户token
        UserToken userToken = userTokenMapper.findByToken(token);
        if (null == userToken) {
            map.put("returnMsg", "user not existed!");
            return map;
        }
        UserAcc userAcc = userAccMapper.findById(userToken.getUid());

        List<InquiryDetail> inquiryDetailList = inquiryDetailMapper.getInquiryListByUid(userToken.getUid());

        // 组装返回数据
        List<InquiryDetailBo> inquiryDetailBoList = new ArrayList<>();
        for (InquiryDetail inquiryDetail : inquiryDetailList) {
            InquiryDetailBo inquiryDetailBo = new InquiryDetailBo();
            inquiryDetailBo.setIdid(inquiryDetail.getIdid());
            inquiryDetailBo.setUid(inquiryDetail.getUid());
            inquiryDetailBo.setName(userAccMapper.findById(inquiryDetail.getUid()).getName());
            inquiryDetailBo.setContent(inquiryDetail.getContent());
            inquiryDetailBo.setType(DoctorTypeEnum.getValue(inquiryDetail.getType().toString()));
            inquiryDetailBo.setDoctorId(inquiryDetail.getDoctor());
            inquiryDetailBo.setDoctor(userAccMapper.findById(inquiryDetail.getDoctor()).getName());
            inquiryDetailBoList.add(inquiryDetailBo);
        }

        map.put("returnMsg", "success");
        map.put("result", inquiryDetailBoList);

        return map;
    }

    /**
     * 获取医生的问诊列表
     * @param token
     * @return
     */
    public Map<String, Object> getDoctorInquiryList(String token) {
        Map<String, Object> map = new HashMap<>();

        if(token == null || "".equals(token)){
            map.put("returnMsg","empty token!");
            return map;
        }

        // 获取用户token
        UserToken userToken = userTokenMapper.findByToken(token);
        if (null == userToken) {
            map.put("returnMsg", "user not existed!");
            return map;
        }

        // 判断是否是医生
        UserAcc userAcc = userAccMapper.findById(userToken.getUid());
        if (1 != userAcc.getAuth()) {
            map.put("returnMsg", "not doctor");
            return map;
        }

        List<InquiryDetail> inquiryDetailList = inquiryDetailMapper.getInquiryListByDoctor(userToken.getUid());

        // 组装返回数据
        List<InquiryDetailBo> inquiryDetailBoList = new ArrayList<>();
        for (InquiryDetail inquiryDetail : inquiryDetailList) {
            InquiryDetailBo inquiryDetailBo = new InquiryDetailBo();
            inquiryDetailBo.setIdid(inquiryDetail.getIdid());
            inquiryDetailBo.setUid(inquiryDetail.getUid());
            inquiryDetailBo.setName(userAccMapper.findById(inquiryDetail.getUid()).getName());
            inquiryDetailBo.setContent(inquiryDetail.getContent());
            inquiryDetailBo.setType(DoctorTypeEnum.getValue(inquiryDetail.getType().toString()));
            inquiryDetailBo.setDoctorId(inquiryDetail.getDoctor());
            inquiryDetailBo.setDoctor(userAcc.getName());
            inquiryDetailBoList.add(inquiryDetailBo);
        }

        map.put("returnMsg", "success");
        map.put("result", inquiryDetailBoList);

        return map;
    }

    /**
     * 创建问诊处方，同时医生回答数加一
     * @param token
     * @param inquiryPrescription
     * @return
     */
    public Map<String, Object> createInquiryPrescription(String token, InquiryPrescription inquiryPrescription) {
        Map<String, Object> map = new HashMap<>();

        if(token == null || "".equals(token)){
            map.put("returnMsg","empty token!");
            return map;
        }

        UserToken userToken = userTokenMapper.findByToken(token);
        if (null == userToken) {
            map.put("returnMsg", "user not existed!");
            return map;
        }

        inquiryPrescriptionMapper.insertInquiryPrescription(inquiryPrescription);
        if (null == inquiryPrescription.getIpid()) {
            map.put("returnMsg", "failed");
            return map;
        }

        // 医生回答数加一
        UserRecommend userRecommend = userRecommendMapper.findByUid(userToken.getUid());
        Integer answerNumber = userRecommend.getAnswerNumber();
        answerNumber += 1;
        userRecommend.setAnswerNumber(answerNumber);
        userRecommendMapper.updateUserRecommendByUid(userRecommend);

        map.put("returnMsg", "success");
        map.put("result", inquiryPrescription);

        return map;
    }

    /**
     * 根据问诊id获取处方
     * @param token
     * @param idid
     * @return
     */
    public Map<String, Object> getInquiryPrescriptionByIdid(String token, Integer idid) {
        Map<String, Object> map = new HashMap<>();

        if(token == null || "".equals(token)) {
            map.put("returnMsg","empty token!");
            return map;
        }

        InquiryPrescription inquiryPrescription = inquiryPrescriptionMapper.getInquiryPrescriptionByIdid(idid);
        if (null == inquiryPrescription) {
            map.put("returnMsg", "prescription not existed!");
            return map;
        }

        InquiryDetail inquiryDetail = inquiryDetailMapper.getInquiryDetailByIdid(inquiryPrescription.getIdid());

        InquiryPrescriptionBo inquiryPrescriptionBo = new InquiryPrescriptionBo();
        inquiryPrescriptionBo.setIpid(inquiryPrescription.getIpid());
        inquiryPrescriptionBo.setIdid(inquiryPrescription.getIdid());
        inquiryPrescriptionBo.setContent(inquiryPrescription.getContent());
        inquiryPrescriptionBo.setDoctorId(inquiryDetail.getDoctor());
        inquiryPrescriptionBo.setDoctor(userAccMapper.findById(inquiryDetail.getDoctor()).getName());

        map.put("returnMsg", "success");
        map.put("result", inquiryPrescriptionBo);

        return map;
    }

    /**
     * 用户给问诊评分，同时重新计算医生评分
     * @param token
     * @param inquiryRate
     * @return
     */
    /*
    public Map<String, Object> createInquiryRate(String token, InquiryRate inquiryRate) {
        Map<String, Object> map = new HashMap<>();

        if(token == null || "".equals(token)){
            map.put("returnMsg","empty token!");
            return map;
        }

        UserToken userToken = userTokenMapper.findByToken(token);
        if (null == userToken) {
            map.put("returnMsg", "user not existed!");
            return map;
        }

        InquiryDetail inquiryDetail = (InquiryDetail) getInquiry(token, inquiryRate.getIdid()).get("result");

        inquiryRateMapper.insertInquiryRate(inquiryRate);
        if (null == inquiryRate.getIrid()) {
            map.put("returnMsg", "failed");
            return map;
        }
        map.put("returnMsg", "success");
        map.put("result", inquiryRate);

        // 医生回答数加一
        UserRecommend userRecommend = userRecommendMapper.findByUid(inquiryDetail.getDoctor());
        Integer answerNumber = userRecommend.getAnswerNumber();
        answerNumber += 1;
        userRecommend.setAnswerNumber(answerNumber);
        userRecommendMapper.updateUserRecommendByUid(userRecommend);

        // 重新计算医生评分
        Double rate = userRecommend.getRate();
        Double newRate = inquiryRate.getRate();
        Double averageRate = ((answerNumber-1)*rate+newRate)/answerNumber;
        userRecommend.setRate(averageRate);
        userRecommendMapper.updateUserRecommendByUid(userRecommend);

        return map;
    }
    */
}
