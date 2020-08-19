package com.taco.demo.controller

import com.taco.demo.model.Ingredient
import com.taco.demo.model.Taco
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/design")
@Controller
class DesignTacoController {


    /**
     * 页面数据
     */
    @GetMapping
    fun showDesignForm(model: Model): String {

        val datas = mutableListOf<Ingredient>()
        datas.add(Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP))
        datas.add(Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP))
        datas.add(Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN))
        datas.add(Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN))
        datas.add(Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGTES))
        datas.add(Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGTES))
        datas.add(Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE))
        datas.add(Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE))
        datas.add(Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE))
        datas.add(Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE))

        val types = Ingredient.Type.values()
        for (t in types) {
            model.addAttribute(t.toString().toLowerCase(), filterByType(datas, t))
        }
        model.addAttribute("tacologo", logoUrl())
        model.addAttribute("design", Taco())

        return "design";
    }

    /**
     * 处理同一页面的 post 请求
     *
     * 会根据 视图 页面form 中指定的 th:object 的值进行自动搜集数据
     *
     * 并重定向到别的页面
     */
    @PostMapping
    fun processDesign(design: Taco): String {
        System.out.println("The form data: " + design)
        return "redirect:/orders/current"
    }


    private fun filterByType(data: List<Ingredient>, type: Ingredient.Type): List<Ingredient> {
        return data.filter { ingredient -> ingredient.type == type }.toList()
    }

    private fun logoUrl(): String {
        return "images/cat041.png"
    }

}