package com.oauth.config;

import com.oauth.domain.PermissionInfo;
import com.oauth.domain.UserInfo;
import com.oauth.mapper.PermissonMapper;
import com.oauth.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private PermissonMapper permissonMapper;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("---------->"+s);
        UserInfo userInfo = userMapper.selectUserInfoByUserName(s);
        System.out.println(userInfo+"------------");
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();

        if(userInfo==null){
            return null;
        }

        List<PermissionInfo> permissionInfoList = permissonMapper.selectPermissionInfoByUserId(userInfo.getId());
        System.out.println(permissionInfoList);
        permissionInfoList.forEach(permissionInfo -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permissionInfo.getEnname());
            grantedAuthorityList.add(grantedAuthority);
        });
        return new User(userInfo.getUsername(),userInfo.getPassword(),grantedAuthorityList);
    }
}
