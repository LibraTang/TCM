package com.tcm.community.util;

public class RedisKeyUtil {

    private static final String SPLIT = ":";
    private static final String PREFIX_BRAVO_ENTITY = "bravo:entity";

    //entity's bravo    bravo:entity:entityType:entityId -> set(uid)
    public static String getBravoEntityKey(int entityType,int entityId){
        return PREFIX_BRAVO_ENTITY + entityType + SPLIT + entityId;
    }
}
