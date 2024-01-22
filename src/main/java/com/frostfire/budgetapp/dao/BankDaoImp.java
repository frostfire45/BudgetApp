package com.frostfire.budgetapp.dao;

import com.frostfire.budgetapp.model.Bank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class BankDaoImp implements BankDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveAll(List<Bank> objs) {
        Session session = sessionFactory.getCurrentSession();
        for (Bank bank : objs){
            session.persist(bank);
        }
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query que = session.createQuery("DELETE FROM Bank  B " +
                "WHERE B.id = :id");
        que.setParameter("id",id);
        //que.executeUpdate();
    }

    @Override
    public void add(Bank obj) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
    }


    @Override
    public List<Bank> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query que = session.createQuery("FROM Bank");
        return que.list();
    }
}
