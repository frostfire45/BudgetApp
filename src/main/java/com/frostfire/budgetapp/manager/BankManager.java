package com.frostfire.budgetapp.manager;

import com.frostfire.budgetapp.Service.BankTransactionService;
import com.frostfire.budgetapp.Service.BankingService;
import com.frostfire.budgetapp.dao.BankDao;
import com.frostfire.budgetapp.dao.BankTransactionDao;
import com.frostfire.budgetapp.model.Bank;
import com.frostfire.budgetapp.model.BankTransaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

// This is a component ** Look up the definiton and use cases **
// Create server for each database table
// So ths is responsiple for Manager - As the name suggest
//  which manages things in your code like EntityManager,
//  it manages Entities, TransactionManager - It manages transaction.
//  So you can have something called as SecurityManager which manages
//  which Algo to use for encryption e.t.c

@Component
public class BankManager {

    private final BankTransactionService bankTransactionService;
    private final BankingService bankingService;

    public BankManager(final BankTransactionService bankTransactionService,
                       final BankingService bankingService){
        this.bankTransactionService = bankTransactionService;
        this.bankingService = bankingService;
    }
    @Service
    public class BankTransactionManager {
        @Transactional
        public List<BankTransaction> getBankTransByRange(LocalDate startDate, LocalDate endDate)
                throws ParseException {
            return bankTransactionService.getBankTransByRange(startDate,endDate);
        }
        @Transactional
        public void deleteTransaction(Long id){
           bankTransactionService.deleteTransaction(id);
        }
        @Transactional
        public void addTransaction(BankTransaction bankTransaction){
            bankTransactionService.addTransaction(bankTransaction);
        }
        @Transactional
        public void addMultipleTransaction(List<BankTransaction> bankTransactions){
            bankTransactionService.addMultipleTransaction(bankTransactions);
        }
        @Transactional
        public  BankTransaction getSingleTransaction(Long id){
            return bankTransactionService.getSingleTransaction(id);
        }
    }
    @Service
    public class BankingManager {
        @Transactional
        public List<Bank> getAllBanks(){
            return bankingService.getAllBanks();
        }
    }
}
