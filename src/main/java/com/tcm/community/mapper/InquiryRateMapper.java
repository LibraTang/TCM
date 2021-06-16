package com.tcm.community.mapper;

import com.tcm.community.model.InquiryRate;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryRateMapper {
    void insertInquiryRate(InquiryRate inquiryRate);
}
