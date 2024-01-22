package com.frostfire.budgetapp.ControllerAPI;

import com.frostfire.budgetapp.manager.BankManager;
import com.frostfire.budgetapp.model.BankTransaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = {"/bankTransaction"})
public class BankTranApiController {

    private final BankManager.BankTransactionManager btm;
    public BankTranApiController(final BankManager.BankTransactionManager bankTransactionManager){
        this.btm = bankTransactionManager;
    }

    @RequestMapping(value = {"/api/getall"}, method = RequestMethod.GET)
    public String getAllApi(Model model) throws ParseException {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = LocalDate.now().minusMonths(1);
        List<BankTransaction> transList = btm.getBankTransByRange(startDate, endDate);
        model.addAttribute("transactions", transList);
        return "jsonMemberTemplate";
    }
}
