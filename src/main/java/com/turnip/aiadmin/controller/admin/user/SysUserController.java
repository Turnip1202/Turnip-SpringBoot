package com.turnip.aiadmin.controller.admin.user;

import com.turnip.aiadmin.common.R;
import com.turnip.aiadmin.model.dto.AdminUserLoginDTO;
import com.turnip.aiadmin.controller.admin.user.vo.login.UserLoginVO;
import com.turnip.aiadmin.model.dto.AdminUserLoginHistroyDTO;
import com.turnip.aiadmin.model.entity.SysUserEntity;
import com.turnip.aiadmin.service.intf.ISysUserLoginHistoryService;
import com.turnip.aiadmin.service.intf.ISysUserService;
import com.turnip.aiadmin.utils.IPUtil;
import com.turnip.aiadmin.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author Turnip
 * @since 2024-11-14
 */
@Log4j2
@RestController
@RequestMapping("/admin/user")
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysUserLoginHistoryService sysUserLoginHistoryService;

    @PostMapping("/register")
    public R<String> register(@RequestBody SysUserEntity registerInfo) {
        log.info("register user info:{}", registerInfo);
        sysUserService.save(registerInfo);
        return R.success("注册成功");
    }

    @PostMapping("/login")
    public R<UserLoginVO> login(@RequestBody AdminUserLoginDTO loginInfo, HttpServletRequest request) {
        String remoteHost = IPUtil.getIpAddr(request);
        log.info("remoteHost:{}", remoteHost);
        log.info("login user info:{}", loginInfo);
        List<SysUserEntity> userEntities = sysUserService.findByUsername(loginInfo.getName());
        if( userEntities != null && !userEntities.isEmpty()) {
            //用户存在
            AdminUserLoginHistroyDTO adminUserLoginDTO = new AdminUserLoginHistroyDTO();
            adminUserLoginDTO.setUserId(userEntities.getFirst().getId());
            adminUserLoginDTO.setIpAddress(remoteHost);
            sysUserLoginHistoryService.save(adminUserLoginDTO);
        }

        // 生成token
        String token = JwtUtil.createToken(UUID.randomUUID().toString(),loginInfo.getName(),new HashMap<>(){{put("name", "test");}});

        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setId(1);
        userLoginVO.setToken(token);

        return R.success(userLoginVO);
    }

}
