package com.frostfire.budgetapp;

import com.frostfire.budgetapp.Service.Utility;
import com.frostfire.budgetapp.Service.WebConfigService;
import com.frostfire.budgetapp.manager.AccountPayableManager;
import com.frostfire.budgetapp.manager.BankManager;
import com.frostfire.budgetapp.model.AccountPayable;
import com.frostfire.budgetapp.model.BankTransaction;
import com.frostfire.budgetapp.model.PayAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class MochDataLoad implements CommandLineRunner {

    private final BankManager.BankTransactionManager bankTransactionManager;
    private final WebConfigService webConfigService;
    private final AccountPayableManager accountPayableManager;
    private final static Logger LOG = LoggerFactory
            .getLogger(BudgetAppApplication.class);

    public MochDataLoad(final BankManager.BankTransactionManager bankTransactionManager,
                        final WebConfigService webConfigService,
                        final AccountPayableManager accountPayableManager){
        this.webConfigService = webConfigService;
        this.bankTransactionManager = bankTransactionManager;
        this.accountPayableManager = accountPayableManager;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBankTrancations();
    }

    private void loadWeb_config(){

    }

    private void loadBankTrancations() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream ("DatabaseData/BankTransaction/myspending_2.csv");

        assert inputStream != null;
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        List<BankTransaction> transList = new ArrayList<>();
        reader.readLine();
        String line;
        while((line = reader.readLine()) != null) {
            String[] coliumSplit = line.split(",");
            BankTransaction trans = new BankTransaction();
            trans.setPosted_date(Utility.convertStringToDate(coliumSplit[0].replace('\"',' ').trim()));
            trans.setAmount(Double.parseDouble(coliumSplit[1].replace('\"',' ').trim()));

            if( coliumSplit[2].replace('\"', ' ').trim().isEmpty() ){
                trans.setCheck_num(null);
            }
            else {
                trans.setCheck_num(Integer.parseInt(coliumSplit[2].replace('\"', '\0').trim()));
            }
            trans.setPayee(coliumSplit[3].replace('\"',' ').trim());
            trans.setMemo(coliumSplit[4].replace('\"',' ').trim());
            transList.add(trans);
        }
        bankTransactionManager.addMultipleTransaction(transList);
        //bankTransactionDao.insertMulpleTransaction(transList);
        LOG.info("BankTransaction Loaded");

        reader.close();
        streamReader.close();
        inputStream.close();

        ClassLoader classLoader2 = Thread.currentThread().getContextClassLoader();
        InputStream inputStream2 = classLoader2.getResourceAsStream("DatabaseData/AccountPayable/march2024.csv");
        assert inputStream2 != null;
        InputStreamReader streamReader2 = new InputStreamReader(inputStream2,StandardCharsets.UTF_8);
        BufferedReader reader2 = new BufferedReader(streamReader2);
        List<AccountPayable> accountPayableList = new ArrayList<>();
        reader2.readLine();
        while((line = reader2.readLine()) != null){
            String[] coliumSplit = line.split(",");
            AccountPayable accountPayable = new AccountPayable();
            accountPayable.setPosted_date(Utility.convertStringToDate(coliumSplit[0].replace('\"',' ').trim()));
            accountPayable.setAmount(Double.parseDouble(coliumSplit[1].replace('\"',' ').trim()));;
            if( coliumSplit[2].replace('\"', ' ').trim().isEmpty() ){
                accountPayable.setCheck_num(null);
            }
            else {
                accountPayable.setCheck_num(Integer.parseInt(coliumSplit[2].replace('\"', '\0').trim()));
            }
            accountPayable.setPayee(coliumSplit[3].replace('\"',' ').trim());
            accountPayable.setMemo(coliumSplit[4].replace('\"',' ').trim());
            accountPayableList.add(accountPayable);
        }
        accountPayableManager.addMutlipleAccountPayable(accountPayableList);
        LOG.info("AccountPayable Loaded");
        reader2.close();
        streamReader2.close();
        inputStream2.close();
    }
    private void loadPayAccount() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("DatabaseData/PayAccount/payaccount2024.csv");
        assert  inputStream != null;
        InputStreamReader streamReader3 = new InputStreamReader(inputStream,StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader3);
        List<PayAccount> payAccountList = new ArrayList<>();
        reader.readLine();
    }
}
