package com.taco.demo.controller

import com.taco.demo.Ingredient
import com.taco.demo.Taco
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/design")
@Controller
class DesignTacoController {

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
    @PostMapping
    fun sss(model: Model){
        val attribute = model.getAttribute("design")
        System.out.println("The form data: "+ attribute)
    }


    private fun filterByType(data: List<Ingredient>, type: Ingredient.Type): List<Ingredient> {
        return data.filter { ingredient -> ingredient.type == type }.toList()
    }

    private fun logoUrl(): String {
        return "images/cat041.png"
    }

}