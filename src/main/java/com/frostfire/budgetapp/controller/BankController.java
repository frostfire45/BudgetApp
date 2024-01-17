package com.frostfire.budgetapp.controller;

import com.frostfire.budgetapp.dao.BankDao;
import com.frostfire.budgetapp.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/banks")
public class BankController {
    @Autowired
    private BankDao dao;

    @RequestMapping(value = {"/getAllBank","/"},method = RequestMethod.GET)
    public String getBank(Model model){
        List<Bank> banks = dao.getAllBanks();
        model.addAttribute("banks",banks);
        return "bankView";
    }
}
