package com.hd.temp.service;

import com.hd.temp.api.service.UmsAdminService;
import com.hd.temp.constant.AuthConstant;
import com.hd.temp.constant.MessageConstant;
import com.hd.temp.domain.SecurityUser;
import com.hd.temp.dto.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 实现UserDetailsService接口，用于加载用户信息
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UmsAdminService umsAdminService;


    /**
     * 根据用户名用户信息
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        String clientId = request.getParameter("client_id");
        LoginUser loginUser;
        if(AuthConstant.ADMIN_CLIENT_ID.equals(clientId)){
            loginUser = umsAdminService.loadUserByUsername(userName);
        }else{
            loginUser = umsAdminService.loadUserByUsername(userName);
        }
        if (loginUser == null) {
            throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        loginUser.setClientId(clientId);
        SecurityUser securityUser = new SecurityUser(loginUser);
        if (!securityUser.isEnabled()) {
            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
        }
        return securityUser;
    }
}
