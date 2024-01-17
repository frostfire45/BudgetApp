package com.frostfire.budgetapp.manager;

import com.frostfire.budgetapp.dao.BankTransactionDao;
import com.frostfire.budgetapp.model.BankTransaction;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class BankTransactionManager {

    private final BankTransactionDao dao;

    public BankTransactionManager(final BankTransactionDao dao,final SessionFactory sessionFactory){
        this.dao = dao;
    }

    @Transactional
    public void deleteTransaction(Long id){
        dao.deleteTransaction(id);
    }

    @Transactional
    public void addTransaction(BankTransaction bankTransaction){
        dao.insertSingleTransaction(bankTransaction);
    }
    @Transactional
    public void addMultipleTransaction(List<BankTransaction> bankTransactions){
        dao.insertMulpleTransaction(bankTransactions);
    }
}
