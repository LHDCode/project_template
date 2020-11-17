package com.hd.temp.user.api.service.impl;

import com.hd.temp.api.CommonResult;
import com.hd.temp.user.api.service.UserService;
import com.hd.temp.user.entity.UmsAdmin;
import org.springframework.stereotype.Component;

/**
 * Feign中的服务降级
 */
@Component
public class UserFallbackService implements UserService {

    @Override
    public CommonResult getUser(Long id) {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setUsername("defaultUser");
        umsAdmin.setPassword("123456");
        return CommonResult.success(umsAdmin);
    }

    @Override
    public CommonResult getByCondition(UmsAdmin umsAdmin) {
        return null;
    }

    @Override
    public CommonResult add(UmsAdmin umsAdmin) {
        return null;
    }

    @Override
    public CommonResult update(UmsAdmin umsAdmin) {
        return null;
    }

    @Override
    public CommonResult delete(Long id) {
        return null;
    }
}
