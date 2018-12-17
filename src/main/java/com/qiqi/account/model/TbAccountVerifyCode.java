package com.qiqi.account.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbAccountVerifyCode implements Serializable {

	private String id;
	private String phonenumber;
	private String emailaddress;
	private String verifycode;
	private String vfccreatetime;
	private String vfcexpiretime;
	private int vfcstatus;
	private int count;
}
