package com.hu.util;

import lombok.Data;

/**
 * 全局统一返回结果类
 *
 */
@Data
public class Result<T>
{

	// 返回码
	private Integer code;

	// 返回消息
	private String message;

	// 返回数据
	private T data;
	
	
	

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

	public T getData()
	{
		return data;
	}

	public void setData(T data)
	{
		this.data = data;
	}

	public Result()
	{
	}

	// 返回数据
	protected static <T> Result<T> build(T data)
	{
		Result<T> result = new Result<T>();
		if (data != null) result.setData(data);
		return result;
	}

	public static <T> Result<T> build(T body, Integer code, String message)
	{
		Result<T> result = build(body);
		result.setCode(code);
		result.setMessage(message);
		return result;
	}

	public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum)
	{
		Result<T> result = build(body);
		result.setCode(resultCodeEnum.getCode());
		result.setMessage(resultCodeEnum.getMessage());
		return result;
	}

	public static <T> Result<T> ok()
	{
		return Result.ok(null);
	}

	/**
	 * 操作成功
	 * 
	 * @param data
	 *            baseCategory1List
	 * @param <T>
	 * @return
	 */
	public static <T> Result<T> ok(T data)
	{
		Result<T> result = build(data);
		return build(data, ResultCodeEnum.SUCCESS);
	}

	public static <T> Result<T> fail()
	{
		return Result.fail(null,null);
	}

	/**
	 * 操作失败
	 * 
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> Result<T> fail(T data,int code)
	{
		Result<T> result = build(data);
		if(code==201)
		{
			//你的账号或密码错误
			return build(data, ResultCodeEnum.FAIL);
		}
		else if(code==20001)
		{
			//账号不正确
			return build(data, ResultCodeEnum.ACCOUNT_ERROR);
		}
		else if(code==2012)
		{
			//服务异常
			return build(data, ResultCodeEnum.SERVICE_ERROR);
			
		}
		else if(code==205)
		{
			//非法请求
			return build(data, ResultCodeEnum.ILLEGAL_REQUEST);
		}
		else if(code==206)
		{
			//重复提交
			return build(data, ResultCodeEnum.REPEAT_SUBMIT);
		}
		else if(code==208)
		{
			//未登陆
			return build(data, ResultCodeEnum.LOGIN_AUTH);
		}
		else if(code==209)
		{
			//没有权限
			return build(data, ResultCodeEnum.PERMISSION);
		}
		else if(code==217)
		{
			//账号已停用
			return build(data, ResultCodeEnum.ACCOUNT_STOP);
		}
		else if(code==218)
		{
			//该节点下有子节点，不可以删除
			return build(data, ResultCodeEnum.NODE_ERROR);
		}
		else
		{
			return build(data, ResultCodeEnum.PASSWORD_ERROR);
		}
		
	}

	public static Result fail(Object o, ResultCodeEnum illegalRequest)
	{
		return null;
	}

	public Result<T> message(String msg)
	{
		this.setMessage(msg);
		return this;
	}

	public Result<T> code(Integer code)
	{
		this.setCode(code);
		return this;
	}
}