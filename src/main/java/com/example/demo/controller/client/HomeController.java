package com.example.demo.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String getMethodName(Model model) {
        return "client/home";
    }

    @GetMapping("/about")
    public String getaboutPage() {
        return "/client/about";
    }

    @GetMapping("/cart")
    public String getcartPage() {
        return "client/cart";
    }

    @GetMapping("/detail")
    public String getdetailPage() {
        return "client/detailProduct";
    }

    @GetMapping("/menu")
    public String getMenu() {
        return "client/menu";
    }
}
