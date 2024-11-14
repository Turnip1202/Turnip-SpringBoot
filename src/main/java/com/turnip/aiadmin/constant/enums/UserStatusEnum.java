package com.turnip.aiadmin.constant.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserStatusEnum {
    USER_ACTIVE( 0, "active"),
    USER_INACTIVE(1, "inactive"),
    USER_LOCKED(2, "locked");
    private final Integer code;
    @EnumValue
    private final String desc;
    UserStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public Integer getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }
    @JsonValue
    public String getDescForJson() {
        return desc;
    }

}
