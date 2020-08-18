package com.taco.demo

/**
 * 配置列表类型
 */
data class Ingredient(val id: String, val name: String, val type: Type) {
    enum class Type {
        WRAP, PROTEIN, VEGGTES, CHEESE, SAUCE
    }
}