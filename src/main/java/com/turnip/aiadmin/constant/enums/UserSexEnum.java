package com.turnip.aiadmin.constant.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserSexEnum {
    GENDER_WOMAN(0, "女"),
    GENDER_MAN(1, "男"),
    GENDER_UNKNOWN(2, "未知");

    private final Integer code;
    @EnumValue
    private final String desc;

    UserSexEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    // 序列化时使用描述
    @JsonValue
    public String getDescForJson() {
        return this.desc;
    }
}
