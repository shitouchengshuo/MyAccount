package com.qiqi.account.exception;

import com.qiqi.account.errorCode.ReturnStatusCode;

public class VerificationCodeRequestTooMuchException extends Exception implements ExceptionInterface {
	private static final long serialVersionUID = 1L;
	private String reason;

	public VerificationCodeRequestTooMuchException() {
		super();
	}

	public VerificationCodeRequestTooMuchException(String message) {
		super(message);
	}

	public VerificationCodeRequestTooMuchException(String message, String reason) {
		super(message);
		this.reason = reason;
	}

	public VerificationCodeRequestTooMuchException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public String getErrorCode() {
		return ReturnStatusCode.VerificationCodeRequestTooMuch.getErrorCode();
	}
	
	@Override
	public String getReason() {
		return this.reason;
	}
	
	@Override
	public String getMessage() {
		return ReturnStatusCode.VerificationCodeRequestTooMuch.getErrorInfo();
	}
}
