package com.frostfire.budgetapp;

import com.frostfire.budgetapp.dao.BankRepository;
import com.frostfire.budgetapp.model.Bank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.frostfire.budgetapp.dao")
public class BudgetAppApplication {
    private static final Logger log = LoggerFactory.getLogger(BudgetAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BudgetAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(BankRepository repository){
        return (args) -> {
            repository.save(new Bank(2,"Chase","3322ii33-3221", Bank.AccountType.Checking,3422.21));

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
