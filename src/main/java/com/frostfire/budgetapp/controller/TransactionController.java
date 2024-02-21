package com.frostfire.budgetapp.controller;


import com.frostfire.budgetapp.dao.BankTransactionDao;
import com.frostfire.budgetapp.manager.BankManager;
import com.frostfire.budgetapp.model.BankTransaction;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = {"/bankTransaction","/transaction"})
public class TransactionController {

    private final BankTransactionDao transDao;
    private final BankManager.BankTransactionManager btm;

    public TransactionController(final BankTransactionDao transDao, final BankManager.BankTransactionManager btm){
        this.transDao = transDao;
        this.btm = btm;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) throws ParseException {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = LocalDate.now().minusMonths(1);
        List<BankTransaction> transList = btm.getBankTransByRange(startDate,endDate);
        model.addAttribute("transactions",transList);
        return "transaction";
    }

    @RequestMapping(value = "/addTransaction", method = RequestMethod.POST)
    public String addTransaction(@ModelAttribute BankTransaction bankTransaction){
        if(bankTransaction != null) {
            btm.addTransaction(bankTransaction);
        }
        return "redirect:/bankTransaction/index";

    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id){
        if(id != null && id > -1) {
            btm.deleteTransaction(id);
        }
        return "redirect:/bankTransaction/index";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update_get(@PathVariable Long id,Model model){
        BankTransaction bankTransaction = null;
        //if(id != null && id > -1) {
            bankTransaction = btm.getSingleTransaction(id);
        //}
        model.addAttribute("trans",bankTransaction);
        return "transactionEdit";
    }
    @RequestMapping(value = "/search/{string}", method = RequestMethod.GET)
    public String searchByString(@PathVariable String searchString,Model model){
        List<BankTransaction> transList = btm.searchForTransaction(searchString);
        model.addAttribute(searchString);
        return "transaction";
    }
    @RequestMapping(value = "/api/search/{string}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String searchByStringApi(@PathVariable String searchString, Model model){
        List<BankTransaction> listTransactions = btm.searchForTransaction(searchString);
        model.addAttribute(listTransactions);
        return "jsonmembertemplate";
    }
}
