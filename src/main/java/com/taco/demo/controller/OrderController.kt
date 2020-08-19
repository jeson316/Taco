package com.taco.demo.controller

import com.taco.demo.model.Order
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid


/**
 * 订单order 控制器
 */
@Controller
@RequestMapping("/orders")
class OrderController {

    @GetMapping("/current")
    fun orderForm(model: Model): String {

        model.addAttribute("order", Order())
        return "orderForm"
    }

    /**
     * 添加校验注解，才能支持校验
     */
    @PostMapping
    fun processOrder(@Valid order: Order, error: Errors): String {
//        如果有校验不通过的，重新回到提交页面
        if (error.hasErrors()) {
            System.out.println("Has errors: " + error.allErrors)
            return "orderForm"
        }
        System.out.println("The order detail: " + order)
        return "redirect:/"
    }
}