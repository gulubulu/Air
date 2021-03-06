package com.air.dao;

import com.air.bean.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryDao {

    @Select("select * from tb_category")
    List<Category> selectCategoryList();

    Category selectCategoryBySubcategoryId(@Param("id") Long id);

    Category selectCategoryByItemId(@Param("id")Long id);

    List<Category> selectDetailedCategoryList();
}