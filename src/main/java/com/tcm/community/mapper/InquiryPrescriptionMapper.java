package com.tcm.community.mapper;

import com.tcm.community.model.InquiryPrescription;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryPrescriptionMapper {
    void insertInquiryPrescription(InquiryPrescription inquiryPrescription);

    InquiryPrescription getInquiryPrescriptionByIdid(Integer idid);
}
