package com.turnip.aiadmin.controller.admin.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.turnip.aiadmin.common.R;
import com.turnip.aiadmin.constant.consist.StateCodeConstants;
import com.turnip.aiadmin.controller.admin.user.vo.login.UserLoginVO;
import com.turnip.aiadmin.model.dto.AdminUserLoginDTO;
import com.turnip.aiadmin.model.dto.AdminUserLoginHistroyDTO;
import com.turnip.aiadmin.model.entity.SysUserEntity;
import com.turnip.aiadmin.service.intf.ISysUserLoginHistoryService;
import com.turnip.aiadmin.service.intf.ISysUserService;
import com.turnip.aiadmin.utils.IPUtil;
import com.turnip.aiadmin.utils.JwtUtil;
import com.turnip.aiadmin.utils.MD5Utils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.UUID;


@Log4j2
@RestController
@RequestMapping("/admin/user")
public class SysUserLoginController {
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysUserLoginHistoryService sysUserLoginHistoryService;


    @PostMapping("/login")
    public R<UserLoginVO> login(@RequestBody AdminUserLoginDTO loginInfo, HttpServletRequest request) {
        String remoteHost = IPUtil.getIpAddr(request);
        String deviceType = request.getHeader("User-Agent");
        log.info("remoteHost:{}", remoteHost);
        log.info("login user info:{}", loginInfo);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", loginInfo.getName());
        queryWrapper.eq("password", MD5Utils.encrypt(loginInfo.getPassword()));
        SysUserEntity userEntities = sysUserService.getOne(queryWrapper);
        if( userEntities != null ) {
            //用户存在
            AdminUserLoginHistroyDTO adminUserLoginDTO = new AdminUserLoginHistroyDTO();
            adminUserLoginDTO.setUserId(userEntities.getId());
            adminUserLoginDTO.setIpAddress(remoteHost);
            adminUserLoginDTO.setDeviceType(deviceType);
            sysUserLoginHistoryService.save(adminUserLoginDTO);
        }

        // 生成token
        String token = JwtUtil.createToken(UUID.randomUUID().toString(),loginInfo.getName(),new HashMap<>(){{put("name", "test");}});

        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setId(1);
        userLoginVO.setToken(token);

        return R.success(StateCodeConstants.LOGIN_SUCCESS,userLoginVO);
    }
}
