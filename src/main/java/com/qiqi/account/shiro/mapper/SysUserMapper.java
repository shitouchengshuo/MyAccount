package com.qiqi.account.shiro.mapper;

import com.qiqi.account.shiro.model.SysUser;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成，请不要手动修改
 */
public interface SysUserMapper {
    List<SysUser> selectAll();

    int deleteByPrimaryKey(Integer id);

    SysUser selectByPrimaryKey(Integer id);

    int insert(SysUser record);

    int updateByPrimaryKey(SysUser record);
}