/**
 * 
 */
package com.qiqi.account.shiro.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SysUserExpandMapper{

	/** 条件分页查询 */
	//Page<Integer> query(Map<String, Object> params);

	Integer queryUserIdByThirdParty(@Param("provider") String provider, @Param("openId") String openId);
}
