package com.frostfire.budgetapp.controller;


import com.frostfire.budgetapp.dao.TransactionDao;
import com.frostfire.budgetapp.model.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = "/transaction")
public class TransactionController {

    private final TransactionDao transDao;

    public TransactionController(final TransactionDao transDao){
        this.transDao = transDao;
    }

    @RequestMapping("/")
    public String index(Model model) throws ParseException {
        String today = LocalDate.now().toString();
        String previous = LocalDate.now().minusMonths(1).toString();
        List<Transaction> transList = transDao.getAllTransaction(previous,today);
        model.addAttribute("transactions",transList);
        return "transaction";
    }
}
