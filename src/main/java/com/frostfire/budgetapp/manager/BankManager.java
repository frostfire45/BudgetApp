package com.frostfire.budgetapp.manager;

import com.frostfire.budgetapp.dao.BankDao;
import com.frostfire.budgetapp.dao.BankTransactionDao;
import com.frostfire.budgetapp.model.Bank;
import com.frostfire.budgetapp.model.BankTransaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

// This is a component ** Look up the definiton and use cases **
// Create server for each database table
@Service
public class BankManager {
    private final BankTransactionDao bankTransdao;
    private final BankDao bankDao;

    public BankManager(final BankTransactionDao bankTranDao, final BankDao bankDao){
        this.bankTransdao = bankTranDao;
        this.bankDao = bankDao;
    }
    @Service
    public class BankTransactionManager {
        @Transactional
        public List<BankTransaction> getBankTransByRange(LocalDate startDate, LocalDate endDate) throws ParseException {
            List<BankTransaction> bankTransList = bankTransdao.getAllTransaction(startDate,endDate);
            return bankTransList;
        }
        @Transactional
        public void deleteTransaction(Long id){
            bankTransdao.deleteTransaction(id);
        }

        @Transactional
        public void addTransaction(BankTransaction bankTransaction){
            bankTransdao.insertSingleTransaction(bankTransaction);
        }
        @Transactional
        public void addMultipleTransaction(List<BankTransaction> bankTransactions){
            bankTransdao.insertMulpleTransaction(bankTransactions);
        }
        @Transactional
        public  BankTransaction getSingleTransaction(Long id){
            return bankTransdao.findTransactionById(id);
        }
    }
    @Service
    public class BankingManager {
        @Transactional
        public List<Bank> getAllBanks(){
            return bankDao.getAll();
        }
    }
}
