package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 商品的三级分类列表
     * @return
     */
    @Override
    public List<CategoryEntity> listTree()
    {
        //1.所有分类
        List<CategoryEntity> categoryList = baseMapper.selectList(null);
        //2.将分类封装为树形结构
//        List<CategoryEntity> finalList = new ArrayList<>();
//        for(CategoryEntity categoryEntity : categoryList)
//        {
//            //如果父id为0，说明是一级分类，在设置子分类
//            if(categoryEntity.getParentCid() == 0)
//            {
//                categoryEntity.setChildren(getChildrens(categoryEntity,categoryList));
//                finalList.add(categoryEntity);
//            }
//        }

        List<CategoryEntity> finalList = categoryList.stream().filter(categoryEntity ->
                categoryEntity.getParentCid() == 0
        ).map((menu)->{
            menu.setChildren(getChildrens(menu,categoryList));
            return menu;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());
        return finalList;
    }

    /**
     * 删除三级分类
     * @param catIds
     */
    @Override
    public void removeMenuByIds(List<Long> catIds) {

        //TODO 删除时，有没有被引用的三级分类
        baseMapper.deleteBatchIds(catIds);
    }

    /**
     * 查商品子分类
     * @param root
     * @param all
     * @return
     */
    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all)
    {
//        List<CategoryEntity> children =  new ArrayList<>();
//        System.out.println("root========"+root);
////        System.out.println("all========="+all);
//        //当前的商品分类对象的分类id跟集合中的数据的父id进行比较，相等就添加当前商品分类对象的children属性
//        for(CategoryEntity categoryEntity : all)
//        {
//            if(root.getCatId().equals(categoryEntity.getParentCid()))
//            {
//                System.out.println("当前id=========="+root.getCatId());
//                System.out.println("父id==============="+categoryEntity.getParentCid());
//                root.setChildren(getChildrens(categoryEntity,all));
//                children.add(root);
//            }
//        }

        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid().equals( root.getCatId());
        }).map(categoryEntity -> {
            //1、找到子菜单
            categoryEntity.setChildren(getChildrens(categoryEntity,all));
            return categoryEntity;
        }).sorted((menu1,menu2)->{
            //2、菜单的排序
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());

        return children;
    }


}