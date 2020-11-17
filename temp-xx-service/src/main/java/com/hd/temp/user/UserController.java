package com.hd.temp.user;

import com.hd.temp.api.CommonResult;
import com.hd.temp.user.api.service.UserService;
import com.hd.temp.user.entity.UmsAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 使用RestTemplate来调用其他服务，Ribbon实现负载均衡功能
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @Autowired
    private UserService userService;

    /**
     * 根据主键获取用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    // @HystrixCommand(fallbackMethod = "getDefaultUser")
    public CommonResult getUser(@PathVariable Long id) {
        // 使用 Ribbon + restTemplate 实现远程调用
        // return restTemplate.getForObject(userServiceUrl + "/user/{1}", CommonResult.class, id);
        // 使用 OpenFeign 实现远程调用
        return userService.getUser(id);
    }

    /*public CommonResult getDefaultUser(@PathVariable Long id) {
        UmsAdmin defaultUser = new UmsAdmin();
        defaultUser.setUsername("defaultUser");
        defaultUser.setPassword("123456");
        return CommonResult.success(defaultUser);
    }*/

    /**
     * 根据条件获取用户信息
     * @param umsAdmin
     * @return
     */
    @PostMapping("/getByCondition")
    public CommonResult getByCondition(@RequestParam UmsAdmin umsAdmin) {
        return restTemplate.postForObject(userServiceUrl + "/user/getByCondition",umsAdmin,CommonResult.class);
    }

    /**
     * 新增用户
     * @param umsAdmin
     * @return
     */
    @PostMapping("/add")
    public CommonResult add(@RequestBody UmsAdmin umsAdmin) {
        return restTemplate.postForObject(userServiceUrl + "/user/add", umsAdmin, CommonResult.class);
    }

    /**
     * 修改用户信息
     * @param umsAdmin
     * @return
     */
    @PostMapping("/update")
    public CommonResult update(@RequestBody UmsAdmin umsAdmin) {
        return restTemplate.postForObject(userServiceUrl + "/user/update", umsAdmin, CommonResult.class);
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        return restTemplate.postForObject(userServiceUrl + "/user/delete/{1}", null, CommonResult.class, id);
    }
}
