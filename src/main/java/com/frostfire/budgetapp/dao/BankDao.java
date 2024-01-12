package com.frostfire.budgetapp.dao;

import com.frostfire.budgetapp.model.Bank;

import java.util.List;

public interface BankDao {
    List<Bank> getAllBanks();
    void addBank(Bank bank);
    void deleteBank(int id);
    void updateBank(Bank bank);
    void commit();
}
