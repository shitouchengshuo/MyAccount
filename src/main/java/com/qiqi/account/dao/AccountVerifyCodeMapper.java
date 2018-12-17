package com.qiqi.account.dao;

import com.qiqi.account.model.TbAccountVerifyCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountVerifyCodeMapper {
	public TbAccountVerifyCode getByPhone(@Param("phonenumber") String phonenumber);
	public TbAccountVerifyCode getByMail(@Param("emailaddress") String emailaddress);
	public void saveOrUpdateById(TbAccountVerifyCode verificationCode);
}
