package com.frostfire.budgetapp.dao;

import com.frostfire.budgetapp.model.Bank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankDaoImp implements BankDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Bank> getAllBanks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Bank> bankList = session.createQuery("from Bank").list();
        return bankList;
    }

    @Override
    public void addNewBank(Bank bank) {

    }

    @Override
    public void deleteBank(int id) {

    }

    @Override
    public void updateBank(Bank bank) {

    }
}
