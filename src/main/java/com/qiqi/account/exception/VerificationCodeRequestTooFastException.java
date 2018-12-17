package com.qiqi.account.exception;

import com.qiqi.account.errorCode.ReturnStatusCode;

public class VerificationCodeRequestTooFastException extends Exception implements ExceptionInterface {
	private static final long serialVersionUID = 1L;
	private String reason;

	public VerificationCodeRequestTooFastException() {
		super();
	}

	public VerificationCodeRequestTooFastException(String message) {
		super(message);
	}

	public VerificationCodeRequestTooFastException(String message, String reason) {
		super(message);
		this.reason = reason;
	}

	public VerificationCodeRequestTooFastException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public String getErrorCode() {
		return ReturnStatusCode.VerificationCodeRequestTooFast.getErrorCode();
	}
	
	@Override
	public String getReason() {
		return this.reason;
	}
	
	@Override
	public String getMessage() {
		return ReturnStatusCode.VerificationCodeRequestTooFast.getErrorInfo();
	}
}
