package com.frostfire.budgetapp;

import com.frostfire.budgetapp.Service.Utility;
import com.frostfire.budgetapp.dao.BankRepository;
import com.frostfire.budgetapp.dao.TransactionDao;
import com.frostfire.budgetapp.model.Bank;
import com.frostfire.budgetapp.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.Calendar;

import static com.frostfire.budgetapp.Service.Utility.convertStringToDate;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.frostfire.budgetapp.dao")
public class BudgetAppApplication {
    private static final Logger log = LoggerFactory.getLogger(BudgetAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BudgetAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(BankRepository repository, TransactionDao transaction){

        LocalDate cal = Utility.convertStringToDate("11/27/2023");

        return (args) -> {
            repository.save(new Bank(2,"Chase","3322ii33-3221", Bank.AccountType.Checking,3422.21));
            transaction.addNewTransaction(new Transaction(cal,-3.13,' ',"Circle K #2740981",""));
            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Bank bank : repository.findAll()) {
                log.info(bank.toString());
            }
            log.info("");
        };
    }

}
