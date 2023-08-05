package com.hu.util;

import lombok.Getter;
@Getter
public enum ResultCodeEnum {
	
    SUCCESS(20000,"成功"),
    ACCOUNT_ERROR(20001, "账号不正确"),
    PASSWORD_ERROR(20002, "其它错误"),
    FAIL(201, "你的账号或密码错误 ！"),
    SERVICE_ERROR(2012, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    ILLEGAL_REQUEST(205, "非法请求"),
    REPEAT_SUBMIT(206, "重复提交"),
    ARGUMENT_VALID_ERROR(210, "参数校验异常"),
    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限"),
    LOGIN_MOBLE_ERROR( 216, "账号不正确"),
    ACCOUNT_STOP( 217, "账号已停用"),
    NODE_ERROR( 218, "该节点下有子节点，不可以删除");


    private Integer code;

    private String message;
    
    

    public Integer getCode()
	{
		return code;
	}



	public void setCode(Integer code)
	{
		this.code = code;
	}



	public String getMessage()
	{
		return message;
	}



	public void setMessage(String message)
	{
		this.message = message;
	}



	private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
