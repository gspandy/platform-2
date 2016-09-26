package com.raycloud.module.util;

import com.raycloud.module.model.CategoryModel;

import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/9/26.
 */
public class CategoryUtil {
    //左侧导航
    private static List<CategoryModel> left;
    //下侧栏目
    private static List<CategoryModel> program;


    public static List<CategoryModel> getLeft() {
        return left;
    }

    public static void setLeft(List<CategoryModel> left) {
        CategoryUtil.left = left;
    }

    public static List<CategoryModel> getProgram() {
        return program;
    }

    public static void setProgram(List<CategoryModel> program) {
        CategoryUtil.program = program;
    }
}
