package com.hd.temp.user.service;

import com.hd.temp.dto.LoginUser;
import com.hd.temp.user.entity.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author huidong.liu
 * @since 2020-11-10
 */
public interface UmsAdminService extends IService<UmsAdmin> {

    void add(UmsAdmin umsAdmin);

    UmsAdmin getUser(Long id);

    List<UmsAdmin> getByCondition(UmsAdmin umsAdmin);

    void updateUser(UmsAdmin umsAdmin);

    void delete(Long id);

    LoginUser loadUserByUsername(String username);
}
