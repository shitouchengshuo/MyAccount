package com.qiqi.account.shiro.mapper;

import com.qiqi.account.shiro.model.SysSession;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成，请不要手动修改
 */
public interface SysSessionMapper{
    List<SysSession> selectAll();

    int deleteByPrimaryKey(Integer id);

    SysSession selectByPrimaryKey(Integer id);

    int insert(SysSession record);

    int updateByPrimaryKey(SysSession record);
}