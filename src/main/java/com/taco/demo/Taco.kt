package com.taco.demo

data class Taco(val name: String = "", val ingredients: MutableList<Ingredient> = mutableListOf()) {
}