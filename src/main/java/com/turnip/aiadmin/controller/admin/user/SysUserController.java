package com.turnip.aiadmin.controller.admin.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.turnip.aiadmin.common.R;
import com.turnip.aiadmin.constant.consist.StateCodeConstants;
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
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
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

    @GetMapping("/")
    public R<String> user(){
        return R.success("user");
    }
}
