package com.frostfire.budgetapp.dao;

import com.frostfire.budgetapp.model.Transaction;

import java.util.Date;
import java.util.List;

public interface TransactionDao {
    List<Transaction> getAllTransaction(Date startDate, Date endDate);
    void addNewTransaction(Transaction transaction);
    List<Transaction> findTransactionByName(String transactionName);
    List<Transaction> findTransactionByAmount(String transactionAmount);
}
