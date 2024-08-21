package com.frostfire.budgetapp.Service;

import com.frostfire.budgetapp.dao.AccountPayableDao;
import com.frostfire.budgetapp.model.AccountPayable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccountPayableService implements AccountPayableDao {
    final private SessionFactory sessionFactory;

    public AccountPayableService(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveAll(List<AccountPayable> objs) {

    }

    @Override
    public void delete(Long num) {

    }

    @Override
    public void add(AccountPayable obj) {
        this.sessionFactory.getCurrentSession().persist(obj);
    }
    public void addMultiple(List<AccountPayable> accountPayableList){
        Session session = sessionFactory.getCurrentSession();
        for(AccountPayable ap : accountPayableList){
            session.persist(ap);
        }
    }
    @Override
    public List<AccountPayable> getAll(LocalDate startDate, LocalDate endDate) {
        Session session = this.sessionFactory.getCurrentSession();
        Query<AccountPayable> que = session.createQuery("from AccountPayable T " +
                "where T.posted_date between :edDate AND :stDate",AccountPayable.class);

        que.setParameter("stDate",endDate);
        que.setParameter("edDate",startDate);
        return que.list();
    }

    @Override
    public boolean enityExist(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query que = session.createQuery("from AccountPayable T " +
                "where T.id = :fid");
        que.setParameter("fid",id);
        if(que.getSingleResult() != null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void updateEnity(AccountPayable obj) {
        Session session = this.sessionFactory.getCurrentSession();
        /*
        Query que = session.createQuery("UPDATE AccountPayable T " +
                "SET " +
                "T.posted_date = :postDate, " +
                "T.amount = :amount, " +
                "T.check_num = :checkNum, " +
                "T.payee = :payee, " +
                "T.memo = :memo " +
                "WHERE id = :id"
        );
        que.setParameter("id",obj.getId());
        que.setParameter("postDate",obj.getPosted_date());
        que.setParameter("amount",obj.getAmount());
        que.setParameter("checkNum",obj.getCheck_num());
        que.setParameter("payee",obj.getPayee());
        que.setParameter("memo",obj.getMemo());
        que.executeUpdate();
        */
        session.merge(obj);
    }
}
