package com.frostfire.budgetapp.dao;

import com.frostfire.budgetapp.model.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public class TransactionDaoImpl implements TransactionDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Transaction> getAllTransaction(Date startDate,Date endDate) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Transaction> transactionList = session.createQuery("from Transaction").list();
        return transactionList;
    }

    @Override
    public void addNewTransaction(Transaction transaction) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.persist(transaction);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Transaction> findTransactionByName(String transactionName) {
        return null;
    }

    @Override
    public List<Transaction> findTransactionByAmount(String transactionAmount) {
        return null;
    }
}
