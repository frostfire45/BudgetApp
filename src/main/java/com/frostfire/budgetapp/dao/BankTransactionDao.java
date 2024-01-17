package com.frostfire.budgetapp.dao;

import com.frostfire.budgetapp.model.BankTransaction;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

public interface BankTransactionDao extends Dao {
    List<BankTransaction> getAllTransaction(LocalDate startDate, LocalDate endDate) throws ParseException;
    void insertSingleTransaction(BankTransaction bankTransaction);
    void insertMulpleTransaction(List<BankTransaction> transList);
    List<BankTransaction> findTransactionByName(String transactionName);
    List<BankTransaction> findTransactionByAmount(String transactionAmount);
    void deleteTransaction(Long id);
}
