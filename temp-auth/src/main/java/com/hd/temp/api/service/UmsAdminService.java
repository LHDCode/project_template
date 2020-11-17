package com.hd.temp.api.service;

import com.hd.temp.dto.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("temp-admin")
public interface UmsAdminService {

    @PostMapping("/admin/getByCondition")
    LoginUser loadUserByUsername(@RequestParam String userName);
}
