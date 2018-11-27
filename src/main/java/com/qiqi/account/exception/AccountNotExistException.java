package com.qiqi.account.exception;

import com.qiqi.account.errorCode.ReturnStatusCode;

public class AccountNotExistException extends Exception implements ExceptionInterface {
	private static final long serialVersionUID = 1L;
	private String reason;

	public AccountNotExistException() {
		super();
	}
	
	/*public AccountNotExistException(String message) {
		super(message);
	}*/
	
    public AccountNotExistException(String reason) {
        this.reason=reason;
    }
	public AccountNotExistException(String message, String reason) {
		super(message);
		this.reason = reason;
	}
	
	public AccountNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public String getErrorCode() {
		return ReturnStatusCode.UserNameNotExist.getErrorCode();
	}
	
	@Override
	public String getReason() {
		return this.reason;
	}
	
	@Override
	public String getMessage() {
		return ReturnStatusCode.UserNameNotExist.getErrorInfo();
	}
}
