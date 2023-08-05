package com.hu.util;

import com.alibaba.druid.util.StringUtils;  
import io.jsonwebtoken.*; 
import java.util.Date;

public class JwtHelper
{

	// 有效时常
	private static long tokenExpiration = 365 * 24 * 60 * 60 * 1000;
	// 签名，根据它签名加密密钥//加盐（搅屎的功能）
	private static String tokenSignKey = "123456";

	// 根据用户ID和用户名称生成token字符
	public static String createToken(Long userId, String username)
	{
		String token = Jwts.builder()
				// 分类
				.setSubject("AUTH-USER")
				// 设置token有效时常（当前时常加上设定时常就超时）
				.setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
				// 设置主体部分
				.claim("userId", userId).claim("username", username)
				// 签名部分
				.signWith(SignatureAlgorithm.HS512, tokenSignKey).compressWith(CompressionCodecs.GZIP).compact();
		return token;
	}

	// 从生成的token中获取id
	public static Long getUserId(String token)
	{
		try
		{
			if (StringUtils.isEmpty(token)) return null;
			Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
			Claims claims = claimsJws.getBody();
			Integer userId = (Integer) claims.get("userId");
			return userId.longValue();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	// 从token中获取用户名称
	public static String getUsername(String token)
	{
		try
		{
			if (StringUtils.isEmpty(token)) return "";

			Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
			Claims claims = claimsJws.getBody();
			return (String) claims.get("username");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	// 测试
	public static void main(String[] args)
	{
		String token = JwtHelper.createToken(1L, "admin");
		System.out.println(token);
		System.out.println(JwtHelper.getUserId(token));
		System.out.println(JwtHelper.getUsername(token));
	}
}
