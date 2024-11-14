package com.turnip.aiadmin.service.impl;

import com.turnip.aiadmin.model.entity.SysUserEntity;
import com.turnip.aiadmin.mapper.SysUserMapper;
import com.turnip.aiadmin.service.intf.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author Turnip
 * @since 2024-11-14
 */
@Log4j2
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUserEntity> findByUsername(String username) {
        log.info("find by username " + username);
        return sysUserMapper.findByUsername(username);
    }
}
