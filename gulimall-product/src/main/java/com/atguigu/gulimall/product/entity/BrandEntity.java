package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author super
 * @email gscgoon@163.com
 * @date 2020-04-30 00:40:26
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空")
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank(message = "品牌地址不能为空")
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]$",message = "检索首字母必须是一个字母")
	//regexp = "/^[a-zA-Z]$/"不能这样写，就会匹配以“/”开头，而不是以a-zA-Z开头
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull
	@Min(value = 0,message = "排序必须大于等于0")
	private Integer sort;

}
