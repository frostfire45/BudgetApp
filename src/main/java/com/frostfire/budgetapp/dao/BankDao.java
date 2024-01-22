package com.frostfire.budgetapp.dao;

import com.frostfire.budgetapp.model.Bank;

import java.util.List;

public interface BankDao extends Dao<Bank> {
    List<Bank> getAll();
}
