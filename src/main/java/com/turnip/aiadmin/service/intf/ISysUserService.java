package com.turnip.aiadmin.service.intf;

import com.turnip.aiadmin.model.entity.SysUserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author Turnip
 * @since 2024-11-14
 */
public interface ISysUserService extends IService<SysUserEntity> {
    List<SysUserEntity> findByUsername(String username);
}
