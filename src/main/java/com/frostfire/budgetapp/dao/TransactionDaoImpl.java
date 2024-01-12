package com.frostfire.budgetapp.dao;

import com.frostfire.budgetapp.model.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Repository
public class TransactionDaoImpl implements TransactionDao{

    private final SessionFactory sessionFactory;

    public TransactionDaoImpl(final SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Transaction> getAllTransaction(String startDate, String endDate) throws ParseException {
        Session session = this.sessionFactory.getCurrentSession();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(startDate);
        Date date2 = format.parse(endDate);

        Query que = session.createQuery("from Transaction T " +
                "where T.posted_date BETWEEN :stDate AND :edDate");
        que.setParameter("stDate",date2);
        que.setParameter("edDate",date1);

        return que.list();

    }
    @Override
    public void insertSingleTransaction(Transaction transaction) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.persist(transaction);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void insertMulpleTransaction(List<Transaction> transList) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        for( Transaction trans : transList){
            session.persist(trans);
        }
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

    @Override
    public void startSession() {

    }

    @Override
    public void savedSession() {

    }
}
