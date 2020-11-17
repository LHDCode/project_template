package com.hd.temp.user.api.service;

import com.hd.temp.api.CommonResult;
import com.hd.temp.user.api.service.impl.UserFallbackService;
import com.hd.temp.user.entity.UmsAdmin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Feign远程调用
 */
@FeignClient(value = "temp-admin",fallback = UserFallbackService.class)
public interface UserService {

    /**
     * 根据主键获取用户信息
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    CommonResult getUser(@PathVariable Long id);

    /**
     * 根据条件获取用户信息
     * @param umsAdmin
     * @return
     */
    @PostMapping("/getByCondition")
    CommonResult getByCondition(@RequestParam UmsAdmin umsAdmin);

    /**
     * 新增用户
     * @param umsAdmin
     * @return
     */
    @PostMapping("/add")
    CommonResult add(@RequestBody UmsAdmin umsAdmin);

    /**
     * 修改用户信息
     * @param umsAdmin
     * @return
     */
    @PostMapping("/update")
    CommonResult update(@RequestBody UmsAdmin umsAdmin);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @PostMapping("/delete/{id}")
    CommonResult delete(@PathVariable Long id);
}
