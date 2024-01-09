package com.frostfire.budgetapp.controller;

import com.frostfire.budgetapp.dao.BankDao;
import com.frostfire.budgetapp.dao.BankRepository;
import com.frostfire.budgetapp.model.Bank;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import java.util.List;

@Controller
@RequestMapping(value = "/banks")
public class BankController {
    @Autowired
    private BankDao dao;

    @RequestMapping(value = "/getAllBank")
    public String getBank(Model model){
        List<Bank> banks = dao.getAllBanks();
        model.addAttribute("banks",banks);
        return "bankView";
    }
}