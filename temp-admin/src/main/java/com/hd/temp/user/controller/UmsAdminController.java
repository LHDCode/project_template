package com.hd.temp.user.controller;


import com.hd.temp.api.CommonResult;
import com.hd.temp.dto.LoginUser;
import com.hd.temp.user.entity.UmsAdmin;
import com.hd.temp.user.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author huidong.liu
 * @since 2020-11-10
 */
@RestController
@RequestMapping("/user")
@Api(tags = "UmsAdminController", description = "后台用户管理")
@Slf4j
public class UmsAdminController {

    @Autowired
    private UmsAdminService umsAdminService;

    /**
     * 新增用户
     * @param umsAdmin
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增用户")
    public CommonResult add(@RequestBody UmsAdmin umsAdmin) {
        umsAdminService.add(umsAdmin);
        return CommonResult.success("操作成功");
    }

    /**
     * 根据主键获取用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据主键获取用户信息")
    public CommonResult<UmsAdmin> getUser(@PathVariable Long id) {
        UmsAdmin umsAdmin = umsAdminService.getUser(id);
        log.info("根据id获取用户信息，用户名称为：{}",umsAdmin.getUsername());
        return CommonResult.success(umsAdmin);
    }

    @GetMapping("/getUserById")
    @ApiOperation("根据主键获取用户信息")
    public CommonResult<UmsAdmin> getUserById(@RequestParam Long id) {
        UmsAdmin umsAdmin = umsAdminService.getUser(id);
        log.info("根据id获取用户信息，用户名称为：{}",umsAdmin.getUsername());
        return CommonResult.success(umsAdmin);
    }

    /**
     * 根据条件获取用户信息
     * @param umsAdmin
     * @return
     */
    @PostMapping("/getByCondition")
    @ApiOperation("根据条件获取用户信息")
    public CommonResult<List<UmsAdmin>> getByCondition(@RequestParam UmsAdmin umsAdmin) {
        List<UmsAdmin> umsAdminList = umsAdminService.getByCondition(umsAdmin);
        return CommonResult.success(umsAdminList);
    }

    /**
     * 修改用户信息
     * @param umsAdmin
     * @return
     */
    @PostMapping("/update")
    @ApiOperation("修改用户信息")
    public CommonResult updateUser(@RequestBody UmsAdmin umsAdmin) {
        umsAdminService.updateUser(umsAdmin);
        return CommonResult.success("操作成功");
    }

    /**
     * 修改用户信息
     * @param id
     * @return
     */
    @PostMapping("/delete/{id}")
    @ApiOperation("修改用户信息")
    public CommonResult delete(@PathVariable Long id) {
        umsAdminService.delete(id);
        return CommonResult.success("操作成功");
    }

    /**
     * 根据用户名获取通用用户信息
     * @param username
     * @return
     */
    @ApiOperation("根据用户名获取通用用户信息")
    @GetMapping("/loadByUsername")
    public LoginUser loadUserByUsername(@RequestParam String username) {
        LoginUser loginUser = umsAdminService.loadUserByUsername(username);
        return loginUser;
    }
}
