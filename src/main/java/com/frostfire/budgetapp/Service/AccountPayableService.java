package com.frostfire.budgetapp.Service;

import com.frostfire.budgetapp.dao.AccountPayableDao;
import com.frostfire.budgetapp.model.AccountPayable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountPayableService implements AccountPayableDao {
    final private AccountPayableDao accountPayableDao;

    public AccountPayableService(AccountPayableDao accountPayableDao){
        this.accountPayableDao = accountPayableDao;
    }

    @Override
    public void saveAll(List<AccountPayable> objs) {

    }

    @Override
    public void delete(Long num) {

    }

    @Override
    public void add(AccountPayable obj) {

    }

    @Override
    public List<AccountPayable> getAll() {
        return null;
    }

    @Override
    public boolean enityExist() {
        return false;
    }
}
