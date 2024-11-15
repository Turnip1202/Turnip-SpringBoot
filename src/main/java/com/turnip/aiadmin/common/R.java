package com.turnip.aiadmin.common;


import com.turnip.aiadmin.constant.consist.StateCode;
import com.turnip.aiadmin.constant.consist.StateCodeConstants;
import io.jsonwebtoken.lang.Assert;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class R<T> implements Serializable {

    /**
     * 错误码
     *
     * @see StateCode#getCode()
     */
    private Integer code;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 错误提示，用户可阅读
     *
     * @see StateCode#getMsg() ()
     */
    private String msg;
    /**
     * 请求路径
     */
    private String path;
    /**
     * 成功标志
     */
    private Boolean success;
    /**
     * 时间戳
     */
    private  LocalDateTime timestamp = LocalDateTime.now();
    public static <T> R<T> error(R<?> result){
        return error(result.getCode(), result.getMsg());
    }
    public static <T> R<T> error(Integer code, String msg){
        Assert.isTrue(!StateCodeConstants.SUCCESS.getCode().equals(code));
        R<T> r = new R<>();
        r.code = code;
        r.msg = msg;
        return r;
    }
    public static <T> R<T> error(StateCode stateCode){
        return error(stateCode.getCode(), stateCode.getMsg());
    }
    /**
     * 成功返回，使用默认成功状态码
     */
    public static <T> R<T> success(T data) {
        return success(StateCodeConstants.SUCCESS, data);
    }

    /**
     * 成功返回，可以指定成功状态码
     */
    public static <T> R<T> success(StateCode stateCode, T data) {
        R<T> r = new R<>();
        r.code = stateCode.getCode();
        r.data = data;
        r.msg = stateCode.getMsg();
        r.success = Boolean.TRUE;
        return r;
    }

    /**
     * 成功返回，无数据
     */
    public static <T> R<T> success() {
        return success(StateCodeConstants.SUCCESS, null);
    }

    /**
     * 成功返回，仅状态码
     */
    public static <T> R<T> success(StateCode stateCode) {
        return success(stateCode, null);
    }

}
