package com.qiqi.account.exception;


import com.qiqi.account.errorCode.ReturnStatusCode;

public class GetVerificationCodeFaliureException extends Exception implements ExceptionInterface {
	private static final long serialVersionUID = 1L;

	private String reason;
	
	public GetVerificationCodeFaliureException() {
		super();
	}
	
	public GetVerificationCodeFaliureException(String message) {
		super(message);
	}
	
	public GetVerificationCodeFaliureException(String message, String reason) {
		super(message);
		this.reason = reason;
	}
	
	public GetVerificationCodeFaliureException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public String getErrorCode() {
		return ReturnStatusCode.GetVerificationCodeFaliure.getErrorCode();
	}
	
	@Override
	public String getReason() {
		return this.reason;
	}
	
	@Override
	public String getMessage() {
		return ReturnStatusCode.GetVerificationCodeFaliure.getErrorInfo();
	}
}
