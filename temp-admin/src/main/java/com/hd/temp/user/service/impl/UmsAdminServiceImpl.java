package com.hd.temp.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hd.temp.dto.LoginUser;
import com.hd.temp.user.entity.UmsAdmin;
import com.hd.temp.user.mapper.UmsAdminMapper;
import com.hd.temp.user.service.UmsAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author huidong.liu
 * @since 2020-11-10
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Override
    public void add(UmsAdmin umsAdmin) {
        umsAdminMapper.insert(umsAdmin);
    }

    @Override
    public UmsAdmin getUser(Long id) {
        return umsAdminMapper.selectById(id);
    }

    @Override
    public List<UmsAdmin> getByCondition(UmsAdmin umsAdmin) {
        QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", umsAdmin.getUsername());
        return umsAdminMapper.selectList(queryWrapper);
    }

    @Override
    public void updateUser(UmsAdmin umsAdmin) {
        umsAdminMapper.updateById(umsAdmin);
    }

    @Override
    public void delete(Long id) {
        umsAdminMapper.deleteById(id);
    }

    @Override
    public LoginUser loadUserByUsername(String username) {
        QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", username);
        List<UmsAdmin> umsAdminList = umsAdminMapper.selectList(queryWrapper);
        if(umsAdminList.size() > 0){
            LoginUser loginUser = new LoginUser();
            BeanUtils.copyProperties(umsAdminList.get(0),loginUser);
        }
        return null;
    }
}
