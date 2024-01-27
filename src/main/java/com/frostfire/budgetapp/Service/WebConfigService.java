package com.frostfire.budgetapp.Service;

import com.frostfire.budgetapp.dao.WebConfigDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WebConfigService implements WebConfigDao{
    SessionFactory sessionFactory;

    public WebConfigService(final SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public String getValueByCategoryAndConfigCD(String category, String config_cd){
        Session session = this.sessionFactory.getCurrentSession();
        Query<com.frostfire.budgetapp.model.WebConfig> que = session.createQuery("FROM WebConfig T " +
                "WHERE T.config_cd = :configCD AND T.category = :category");
        que.setParameter("category",category);
        que.setParameter("configCD",config_cd);
        return que.getSingleResult().getValue();
    }
}
