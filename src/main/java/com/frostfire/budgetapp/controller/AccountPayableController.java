package com.frostfire.budgetapp.controller;

import com.frostfire.budgetapp.manager.AccountPayableManager;
import com.frostfire.budgetapp.model.AccountPayable;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/accountPayable")
public class AccountPayableController {
    private final AccountPayableManager accntPayMng;

    public AccountPayableController(AccountPayableManager accntPayMng){
        this.accntPayMng = accntPayMng;
    }
    @RequestMapping(value = "/getByDateRange", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AccountPayable> getByDateRangeApi(
            @RequestParam("start_date") String startDate,
            @RequestParam("end_date") String endDate,
            Model model){

        List<AccountPayable> accountPayableList = accntPayMng.getAll(startDate,endDate);
        model.addAttribute(accountPayableList);
        return accountPayableList;
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@RequestBody AccountPayable accnt){
        accntPayMng.updateAccountPayable(accnt);
    }
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insertSingle(@RequestBody AccountPayable accnt){
        accntPayMng.addAccountPayable(accnt);
    }
}
