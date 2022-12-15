package com.example.baitap.controller;

import com.example.baitap.service.MoneyChangeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MoneyController {
    private MoneyChangeService moneyChangeService = new MoneyChangeService();
    @GetMapping("/moneyChange")
    public String displayMoneyChange(){
        return "view_money_change";
    }
    @PostMapping("/moneyChange")
    public String moneyChange(Model model, HttpServletRequest request){
        model.addAttribute("amount",moneyChangeService.moneyChange(request));
        return "view_money_change";
    }

}
