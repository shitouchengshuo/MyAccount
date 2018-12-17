package com.qiqi.account.exception;


import com.qiqi.account.errorCode.ReturnStatusCode;

public class VerificationCodeNeededException extends Exception implements ExceptionInterface {
	private static final long serialVersionUID = 1L;
	private String reason;

	public VerificationCodeNeededException() {
		super();
	}
	
	public VerificationCodeNeededException(String reason) {
		this.reason = reason;
	}
	
	public VerificationCodeNeededException(String message, String reason) {
		super(message);
		this.reason = reason;
	}
	
	public VerificationCodeNeededException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public String getErrorCode() {
		return ReturnStatusCode.VerificationCodeNeeded.getErrorCode();
	}
	
	@Override
	public String getReason() {
		return reason;
	}
	
	@Override
	public String getMessage() {
		return ReturnStatusCode.VerificationCodeNeeded.getErrorInfo();
	}
}
