package com.qiqi.account.errorCode;

public enum ReturnStatusCode {  
	
	Success("0", "success"),
	VerificationCodeError("1", "verification code error"),
	VerificationCodeExpired("2", "verification code expire"),
	NotVerifiedByOldPhone("3", "not verified by old phone"),
	OldPassWordError("4", "old pass word error"),
	InvalidToken("5", "invalid token"),
	InvalidRefreshToken("6", "invalid refresh token"),
	UserNameNotExist("7", "user not exist"),
	PasswordError("8", "password error"),
	ClientIdNotExist("9", "client id not exist"),
	ClientSecretError("10", "client secret error"),
	AuthorizationCodeError("11", "authorization code error"),
	ParameterError("12", "parameter code error"),
	GetVerificationCodeFaliure("13", "get verification code failure"),
	AccountPhonenumberAlreadyExist("14", "account phone number already exist"),
	PwdNotSetError("15", "passwd not set"),
	GetUserDetailError("16", "get user detail error"),
	PermissionError("17", " permission error"),
	PicFormatError("18", "picture format error"),
	PicEmptyError("19", "picture is empty error"),
	AvatarNotSetError("20", "avatar not set error"),
	TokenMgrError("21", "token is error"),
	AccountNotActive("22", "account not active"),
	VerificationCodeUsed("23", "verification code used"),
	AccountNameAlreadyExist("24", "account name already exist"),
	AccountMailaddressAlreadyExist("25", "account mail address already exist"),
    AccountAlreadyLogout("26","account has log out"),
    NeedRefreshToken("27", "need refresh token"),  //这个异常不会抛向用户
    SecurityQANotSetError("28", "securityQA not set"),
    SecurityQAError("29", "securityQA is wrong"),
    AccountKickedOut("30", "this account has logged in another device"),
    EmailFormatError("31","mailaddress format wrong"),
    PasswordFormatError("32","password format wrong"),
	UserNameFormatError("33","username format wrong"),
    PhoneFormatError("34","phonenumber format wrong"),
	CaptchaNotExist("36","picture not exist"),
	CaptchaWrong("37","captcha is wrong or null"),
	VerificationCodeRequestTooFast("38","VerificationCode has been requested too fast"),
	VerificationCodeRequestTooMuch("39","VerificationCode has been requested too much"),
	VerificationCodeNeeded("40", "need to send verification code to verify"),
	AccountNotBind("41", "not bind to feixun account"),
    ServerError("50", "server error"),
	ServerMaintenance("51", "server maintenance error"),
	MACNotExist("100", "mac address not exist"),
	MACHasRelateDevice("101", "mac address has related to device"),
	DeviceCannotCommunication("102", "Device cannot communication"),
	DeviceHasnotConnectKeepAliveServer("103", "device has not connect to keep-alive server"),
	AccountNotBindingDevice("111", "account not binding on device"),
	DeviceNotBindingAccount("112", "device not binding on account"),
	AccountNotBindingAnyDevice("113", "account not binding on any device"),
	DeviceNotBindingAnyAccount("114", "device not binding on any account"),
	APPVersionNotSupport("120", "app version not support"),
	
	AccountBeenLocked("42", "this account has been locked"),
	IpBeenLocked("43", "this ip has been locked"),
	
	
//	0.表示成功；
//	1.表示验证码错误；
//	2.表示验证码过期;
//	3.尚未经过旧手机号验证;
//	4.旧密码错误;
//	5.token过期;
//	6.refreshtoken过期;
//	7.用户名不存在;
//	8.密码错误;
//	9. client_id不存在；
//	10. client_secret错误；
//	11. 授权码错误；
//	12. 授权码错误；
//	13. 获取验证码失败；
//
//	50.服务器异常;
	
	
    OK("200", "None"),  
    NO_CODE("30001", "No Found Access Code"),
    INVALID_CODE("30002", "Invalid Code"),
	INVALID_PASSWORD("30003", "Invalid Password"),
	INVALID_CLIENT("30004", "Invalid client"),
	
	
    SYSTEM_ERR("3000", "System Error");  
      
    private String errorCode;  
    private String errorInfo;  
    public String getErrorCode() {  
        return errorCode;  
    }  
  
    public void setErrcode(String errorCode) {  
        this.errorCode = errorCode;  
    }  
  
    public String getErrorInfo() {  
        return errorInfo;  
    }  
  
    public void setErrorInfo(String errorInfo) {  
        this.errorInfo = errorInfo;  
    }  
    private ReturnStatusCode(String ErrorCode, String ErrorInfo)  
    {  
        this.errorCode = ErrorCode;  
        this.errorInfo = ErrorInfo;  
    }  
}  