package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author super
 * @email gscgoon@163.com
 * @date 2020-04-30 13:33:20
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
