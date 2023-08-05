package com.hu.util;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class MyPageVO implements Serializable {

		@TableField(exist = false)
		private int begin;
		@TableField(exist = false)
		private int pages;
		

		
		
		

}
