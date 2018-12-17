package com.qiqi.account.exception;


import com.qiqi.account.errorCode.ReturnStatusCode;

public class VerificationCodeExpiredException extends Exception implements ExceptionInterface {
	private static final long serialVersionUID = 1L;
	private String reason;

	public VerificationCodeExpiredException() {
		super();
	}
	
	public VerificationCodeExpiredException(String message) {
		super(message);
	}
	
	public VerificationCodeExpiredException(String message, String reason) {
		super(message);
		this.reason = reason;
	}
	
	public VerificationCodeExpiredException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public String getErrorCode() {
		return ReturnStatusCode.VerificationCodeExpired.getErrorCode();
	}
	
	@Override
	public String getReason() {
		return reason;
	}
	
	@Override
	public String getMessage() {
		return ReturnStatusCode.VerificationCodeExpired.getErrorInfo();
	}
	
}
