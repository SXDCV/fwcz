package com.hu.entity;

import java.io.Serializable;

public class UserEntity implements Serializable
{

	private int uid;
	private String username;
	private String password;
	
	
	private String name;
	private String avatar;
	private String address;
	private String utel;
	
	
	

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAvatar()
	{
		return avatar;
	}

	public void setAvatar(String avatar)
	{
		this.avatar = avatar;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getUtel()
	{
		return utel;
	}

	public void setUtel(String utel)
	{
		this.utel = utel;
	}

	public int getUid()
	{
		return uid;
	}

	public void setUid(int uid)
	{
		this.uid = uid;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}
