package com.turnip.aiadmin.constant.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserRoleEnum {
    USER_ROLE_SUPERADMIN(0, "superAdmin"),
    USER_ROLE_MODERATOR(1, "admin"),
    USER_ROLE_USER(2, "user");
    private final Integer code;
    @EnumValue
    private final String desc;

    UserRoleEnum(Integer code, String desc) {
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
