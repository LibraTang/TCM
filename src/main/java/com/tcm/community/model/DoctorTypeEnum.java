package com.tcm.community.model;

public enum DoctorTypeEnum {
    NEPHROLOGY("1", "肾内科"), ENDOCRINOLOGY("2", "内分泌科"),
    CARDIOLOGY("3", "心内科"), RESPIRATORY("4", "呼吸科"),
    GASTROENTEROLOGY("5", "消化科"), NEUROLOGY("6", "神经内科"),
    GYNECOLOGY("7", "妇科"), PEDIATRICS("8", "儿科"),
    FIVESENSE("9", "五官科"), HEMATOLOGY("10", "血液肿瘤科");

    private String code;
    private String value;

    DoctorTypeEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public static String getValue(String code) {
        DoctorTypeEnum[] doctorTypeEnums = values();
        for (DoctorTypeEnum doctorTypeEnum : doctorTypeEnums) {
            if (doctorTypeEnum.getCode().equals(code)) {
                return doctorTypeEnum.value;
            }
        }
        return null;
    }
}
