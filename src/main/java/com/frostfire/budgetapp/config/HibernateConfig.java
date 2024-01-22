package com.frostfire.budgetapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement // Allow for spring annotation driven transaction.
public class HibernateConfig {
    @Autowired
    private Environment environment;

    @Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] {
                "com.frostfire.budgetapp.model"
        });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
    // Method breakdowns

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName.mysql"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
    /*
    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager hibTransactionManager
                = new HibernateTransactionManager();
        hibTransactionManager.setSessionFactory(sessionFactory().getObject());
        return hibTransactionManager;
    }
     */
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

    /*
    ===================================================================================================================
    # HibernateTransactionManager
    # binds a Hibernate Session from the specified factory to the thread, potentially
    # allowing for one thread-bound Session per factory. This transaction manager is appropriate for applications
    # that use a single Hibernate SessionFactory for transactional data access, but it also supports direct
    # DataSource access within a transaction i.e. plain JDBC
    #-----------------------------------------------------------------------------------------------------------------*/
    /*
    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

     */

}
