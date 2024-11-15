package com.turnip.aiadmin.controller.admin.user;


import com.turnip.aiadmin.common.R;
import com.turnip.aiadmin.constant.consist.StateCodeConstants;
import com.turnip.aiadmin.model.entity.SysUserEntity;
import com.turnip.aiadmin.service.intf.ISysUserService;
import com.turnip.aiadmin.utils.MD5Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@Log4j2
@RestController
@RequestMapping("/admin/user")
public class SysUserRegistryController {
    @Autowired
    private ISysUserService sysUserService;
    @PostMapping("/register")
    public R<String> register(@RequestBody SysUserEntity registerInfo) {
        log.info("register user info:{}", registerInfo);
        SysUserEntity registerData = new SysUserEntity();
        registerData = registerInfo;
        registerData.setPassword(MD5Utils.encrypt(registerInfo.getPassword()));
        try {
            sysUserService.save(registerData);
        }catch (Exception e) {
            return R.error(StateCodeConstants.REGISTER_ERROR);
        }

        return R.success(StateCodeConstants.REGISTER_SUCCESS,"注册成功");
    }
}
