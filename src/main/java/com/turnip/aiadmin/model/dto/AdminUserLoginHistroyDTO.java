package com.turnip.aiadmin.model.dto;

import com.turnip.aiadmin.model.entity.SysUserLoginHistoryEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminUserLoginHistroyDTO extends SysUserLoginHistoryEntity {
    private Long id;
    private Integer userId;
    private String ipAddress;
    private LocalDateTime loginTime;
}
