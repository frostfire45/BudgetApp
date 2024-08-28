package com.frostfire.budgetapp.Views.AccountPayable;

import com.frostfire.budgetapp.BudgetAppApplication;
import com.frostfire.budgetapp.manager.AccountPayableManager;
import com.frostfire.budgetapp.model.AccountPayable;
import com.github.javaparser.utils.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Service
@PropertySource("classpath:application.properties")
public class AccountPayableViewModel {
    final private AccountPayableManager accntPayMang;

    @Autowired
    private Environment environment;
    private final static Logger LOG = LoggerFactory
            .getLogger(BudgetAppApplication.class);
    private String startDate = LocalDate.now().minusMonths(1).toString();
    private String endDate = LocalDate.now().toString();

    public AccountPayableViewModel(AccountPayableManager accountPayableManager) {
        this.accntPayMang = accountPayableManager;
    }

    public List<AccountPayable> getAllTransaction(){
        return accntPayMang.getAll(this.startDate,this.endDate);
    }
    public Locale getLocale(){
        Locale dd = new Locale(
                environment.getRequiredProperty("default.locale.language"),
                environment.getRequiredProperty("default.locale.country"));
        return dd;
    }

    public void setStartDate(LocalDate value) {
        this.startDate = value.toString();
        Log.info(value.toString());
    }

    public void setEndDate(LocalDate value) {
        this.endDate = value.toString();
        Log.info(value.toString());
    }

    public void uploadAccountCSV(InputStream ips){
        List<String> accntFields = accntPayMang.getAccountPayableService().getAccountPayableFields();
    }
}
