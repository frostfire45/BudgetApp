package com.frostfire.budgetapp.Service;

import com.frostfire.budgetapp.dao.BankDao;
import com.frostfire.budgetapp.model.Bank;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankingService{
    private final BankDao bankDao;

    public BankingService(final BankDao bankDao){
        this.bankDao = bankDao;
    }
    public List<Bank> getAllBanks(){
        return bankDao.getAll();
    }
}
