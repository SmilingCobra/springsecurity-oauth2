package com.oauth.mapper;

import com.oauth.domain.PermissionInfo;

import java.util.List;

public interface PermissonMapper {

    List<PermissionInfo> selectPermissionInfoByUserId(String userId);


}
