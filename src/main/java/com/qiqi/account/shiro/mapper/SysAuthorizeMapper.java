package com.qiqi.account.shiro.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysAuthorizeMapper {

	void deleteUserMenu(Integer userId);

	void deleteUserRole(Integer userId);

	void deleteRoleMenu(Integer roleId);

	List<Integer> getAuthorize(Integer userId);

	List<String> queryPermissionByUserId(@Param("userId") Integer userId);

}
