package com.turnip.aiadmin.mapper;

import com.turnip.aiadmin.model.entity.SysUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author Turnip
 * @since 2024-11-14
 */
public interface SysUserMapper extends BaseMapper<SysUserEntity> {
    public List<SysUserEntity> findByUsername(String username);
}
