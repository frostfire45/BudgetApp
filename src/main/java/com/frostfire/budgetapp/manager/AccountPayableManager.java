package com.frostfire.budgetapp.manager;

import com.frostfire.budgetapp.Service.AccountPayableService;
import com.frostfire.budgetapp.model.AccountPayable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountPayableManager {
    final private AccountPayableService accountPayableService;

    public AccountPayableManager(AccountPayableService accountPayableService){
        this.accountPayableService = accountPayableService;
    }

    @Transactional
    public List<AccountPayable> getAll(){
        return accountPayableService.getAll();
    }

    @Transactional
    public void addAccountPayable(AccountPayable ap){
        accountPayableService.add(ap);
    }
    @Transactional
    public void deleteAccountPayable(Long Id){
        
    }
    @Transactional
    public void updateAccountPayable(Long id, AccountPayable ap){

    }

}
