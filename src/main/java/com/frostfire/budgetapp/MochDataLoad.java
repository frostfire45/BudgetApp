package com.frostfire.budgetapp;

import com.frostfire.budgetapp.Service.Utility;
import com.frostfire.budgetapp.dao.TransactionDao;
import com.frostfire.budgetapp.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class MochDataLoad implements CommandLineRunner {

    private final TransactionDao transactionDao;

    public MochDataLoad(final TransactionDao transactionDao){
        this.transactionDao = transactionDao;
    }
    private final static Logger LOG = LoggerFactory
            .getLogger(BudgetAppApplication.class);

    @Override
    public void run(String... args) throws Exception {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream ("BankTransaction/myspending.csv");

        assert inputStream != null;
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        List<Transaction> transList = new ArrayList<>();
        reader.readLine();
        String line;
        while((line = reader.readLine()) != null) {
           String[] coliumSplit = line.split(",");
           Transaction trans = new Transaction();
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
        transactionDao.insertMulpleTransaction(transList);
        LOG.info("Here");
    }
}
