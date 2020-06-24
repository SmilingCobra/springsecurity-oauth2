package com.oauth.mapper;

import com.oauth.domain.UserInfo;


public interface UserMapper {

     UserInfo selectUserInfoByUserName(String username);


}
