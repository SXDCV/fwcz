package com.hu.util;

import lombok.Data;

@Data
public class GuiguException extends RuntimeException
{

	private Integer code;// 状态码
	private String msg;

	public GuiguException(Integer code, String msg)
	{
		super(msg);
		this.msg = msg;
		this.code = code;
	}

	/**
	 * 接收枚举类型对象
	 * @param resultCodeEnum
	 */
	public GuiguException(ResultCodeEnum resultCodeEnum)
	{
		super(resultCodeEnum.getMessage());
		this.code = resultCodeEnum.getCode();
		this.msg = resultCodeEnum.getMessage();
	}

	@Override
	public String toString()
	{
		return "GuliException{" + "code=" + code + ", message=" + this.getMessage() + '}';
	}

}
