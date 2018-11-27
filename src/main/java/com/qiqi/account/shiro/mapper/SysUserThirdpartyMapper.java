package com.qiqi.account.shiro.mapper;

import com.qiqi.account.shiro.model.SysUserThirdparty;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserThirdpartyMapper {

    List<SysUserThirdparty> selectAll();

    int deleteByPrimaryKey(Integer id);

    SysUserThirdparty selectByPrimaryKey(Integer id);

    int insert(SysUserThirdparty record);

    int updateByPrimaryKey(SysUserThirdparty record);

    void deleteByOpenIdAndProvider(String openId, String provider);

    List<String> findProviderByUid(Integer uid);
}