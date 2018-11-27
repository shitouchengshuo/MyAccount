package com.qiqi.account.shiro.mapper;

import java.util.List;

public interface SysSessionExpandMapper {

	void deleteBySessionId(String sessionId);

	Integer queryBySessionId(String sessionId);

	List<String> querySessionIdByAccount(String account);

	//Page<Integer> query(Map<String, Object> params);

}
