package com.qiqi.account.exception;

import org.apache.shiro.authc.AuthenticationException;

public class AccountNotExistException extends AuthenticationException {
	private static final long serialVersionUID = 1L;
	private String reason;

	public AccountNotExistException() {
		super();
	}
	
	public AccountNotExistException(String message) {
		super(message);
	}

}
