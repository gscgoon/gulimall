package com.atguigu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author super
 * @email gscgoon@163.com
 * @date 2020-04-30 00:40:26
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 商品三级列表
     * @return
     */
    List<CategoryEntity> listTree();

    /**
     * 删除三级分类
     * @param catIds
     */
    void removeMenuByIds(List<Long> catIds);
}

