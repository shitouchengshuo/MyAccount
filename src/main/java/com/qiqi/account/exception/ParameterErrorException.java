package com.qiqi.account.exception;

import com.qiqi.account.errorCode.ReturnStatusCode;

public class ParameterErrorException extends Exception implements ExceptionInterface {
	private static final long serialVersionUID = 1L;
	private String reason;
	
	public ParameterErrorException() {
		super();
	}

	public ParameterErrorException(String message) {
		super(message);
	}

	public ParameterErrorException(String message, String reason) {
		super(message);
		this.reason = reason;
	}

	public ParameterErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public String getErrorCode() {
		return ReturnStatusCode.ParameterError.getErrorCode();
	}
	
	@Override
	public String getReason() {
		return reason;
	}
	
	@Override
	public String getMessage() {
		String customMessage = super.getMessage();
		if(customMessage == null || customMessage.equals("")) {
			return ReturnStatusCode.ParameterError.getErrorInfo();
		}
		return customMessage;
	}
}
