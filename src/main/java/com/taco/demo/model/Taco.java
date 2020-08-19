package com.taco.demo.model;

import java.util.List;


/**
 * kotlin 写法在 thymeleaf 模板中无法自动回去到参数信息， 改为普通的java 形式
 */
public class Taco {


    private String name;

    /**
     * 要跟 design.html 视图中的 input 标签的 name 值保持一致，才能保证数据的正确收集
     */
    private List<String> ingredient;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredient() {
        return ingredient;
    }

    public void setIngredient(List<String> ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return "Taco{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredient +
                '}';
    }
}
