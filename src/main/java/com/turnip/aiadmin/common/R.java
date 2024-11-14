package com.turnip.aiadmin.common;


import com.turnip.aiadmin.constant.consist.ErrorCode;
import com.turnip.aiadmin.constant.consist.GlobalErrorCodeConstants;
import io.jsonwebtoken.lang.Assert;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class R<T> implements Serializable {

    /**
     * 错误码
     *
     * @see ErrorCode#getCode()
     */
    private Integer code;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 错误提示，用户可阅读
     *
     * @see ErrorCode#getMsg() ()
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
        Assert.isTrue(!GlobalErrorCodeConstants.SUCCESS.getCode().equals(code));
        R<T> r = new R<>();
        r.code = code;
        r.msg = msg;
        return r;
    }
    public static <T> R<T> error(ErrorCode errorCode){
        return error(errorCode.getCode(), errorCode.getMsg());
    }
    public static <T> R<T> success(T data){
        R<T> r = new R<>();
        r.code = GlobalErrorCodeConstants.SUCCESS.getCode();
        r.data = data;
        r.msg = GlobalErrorCodeConstants.SUCCESS.getMsg();
        r.success = Boolean.TRUE;
        return r;
    }

}
