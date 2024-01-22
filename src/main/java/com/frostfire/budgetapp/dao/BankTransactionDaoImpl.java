package com.frostfire.budgetapp.dao;

import com.frostfire.budgetapp.model.BankTransaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
@Repository
public class BankTransactionDaoImpl implements BankTransactionDao {

    private final SessionFactory sessionFactory;

    public BankTransactionDaoImpl(final SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<BankTransaction> getAllTransaction(LocalDate startDate, LocalDate endDate) throws ParseException {
        Session session = this.sessionFactory.getCurrentSession();
        Query que = session.createQuery("from BankTransaction T " +
                "where T.posted_date between :edDate AND  :stDate");
        que.setParameter("stDate",endDate);
        que.setParameter("edDate",startDate);
        return que.list();

    }
    @Override
    public void deleteTransaction(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query que = session.createQuery("DELETE FROM BankTransaction  T " +
                "WHERE T.id = :id");
        que.setParameter("id",id);
        que.executeUpdate();
    }
    //controller -> Manager -> service -> dao
    // This is wrong because if I commit and have something else pending I could create bad data.
    @Override
    public void insertSingleTransaction(BankTransaction bankTransaction) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(bankTransaction);
    }

    @Override
    public void insertMulpleTransaction(List<BankTransaction> transList) {
        Session session = sessionFactory.getCurrentSession();
        for( BankTransaction trans : transList){
            session.persist(trans);
        }
    }

    @Override
    public List<BankTransaction> findTransactionByName(String transactionName) {
        return null;
    }

    @Override
    public List<BankTransaction> findTransactionByAmount(String transactionAmount) {
        return null;
    }

    @Override
    public BankTransaction findTransactionById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<BankTransaction> que = session.createQuery("FROM BankTransaction T WHERE T.id = :id");
        que.setParameter("id",id);
        return que.getSingleResult();
    }
}
