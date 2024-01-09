package com.frostfire.budgetapp;

import com.frostfire.budgetapp.config.HibernateConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class BudgetServerletContainerInitialization
        extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { HibernateConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {  };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}

