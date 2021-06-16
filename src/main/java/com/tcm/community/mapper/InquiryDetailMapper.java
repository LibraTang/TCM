package com.tcm.community.mapper;

import com.tcm.community.model.InquiryDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryDetailMapper {
    void insertInquiryDetail(InquiryDetail inquiryDetail);

    InquiryDetail getInquiryDetailByIdid(Integer idid);

    List<InquiryDetail> getInquiryListByUid(Integer uid);

    List<InquiryDetail> getInquiryListByDoctor(Integer uid);
}
