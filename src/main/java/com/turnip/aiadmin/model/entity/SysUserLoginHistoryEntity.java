package com.turnip.aiadmin.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户登录历史记录
 * </p>
 *
 * @author Turnip
 * @since 2024-11-14
 */
@Getter
@Setter
@TableName("sys_user_login_history")
public class SysUserLoginHistoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 登录时间
     */
    @TableField("login_time")
    private LocalDateTime loginTime;

    /**
     * IP地址
     */
    @TableField("ip_address")
    private String ipAddress;

    /**
     * 登录类型：1-账号密码，2-手机验证码，3-微信，4-其他
     */
    @TableField("login_type")
    private Boolean loginType;

    /**
     * 登录状态：0-失败，1-成功
     */
    @TableField("login_status")
    private Boolean loginStatus;

    /**
     * 设备类型
     */
    @TableField("device_type")
    private String deviceType;

    /**
     * 浏览器代理信息
     */
    @TableField("user_agent")
    private String userAgent;

    /**
     * IP归属地
     */
    @TableField("login_location")
    private String loginLocation;
}
