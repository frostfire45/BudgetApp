package com.frostfire.budgetapp.dao;

import com.frostfire.budgetapp.model.Transaction;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TransactionDao extends Dao {
    List<Transaction> getAllTransaction(String startDate, String endDate) throws ParseException;
    void insertSingleTransaction(Transaction transaction);
    void insertMulpleTransaction(List<Transaction> transList);
    List<Transaction> findTransactionByName(String transactionName);
    List<Transaction> findTransactionByAmount(String transactionAmount);
}
