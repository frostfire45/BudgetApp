package com.frostfire.budgetapp.Service;

import com.frostfire.budgetapp.dao.BankTransactionDao;
import com.frostfire.budgetapp.model.BankTransaction;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@Service
public class BankTransactionService {
    private final BankTransactionDao bankTransdao;

    public BankTransactionService(final BankTransactionDao bankTransdao){
        this.bankTransdao = bankTransdao;
    }

    public List<BankTransaction> getBankTransByRange(LocalDate startDate, LocalDate endDate)
            throws ParseException {
        List<BankTransaction> bankTransList = bankTransdao.getAllTransaction(startDate, endDate);
        return bankTransList;
    }
    public void deleteTransaction(Long id){
        bankTransdao.deleteTransaction(id);
    }
    public void addTransaction(BankTransaction bankTransaction){
        bankTransdao.insertSingleTransaction(bankTransaction);
    }
    public void addMultipleTransaction(List<BankTransaction> bankTransactions){
        bankTransdao.insertMulpleTransaction(bankTransactions);
    }
    public  BankTransaction getSingleTransaction(Long id){
        return bankTransdao.findTransactionById(id);
    }

    public List<BankTransaction> getResultsFromSearch(String string) {
        return bankTransdao.findTransactionByName(string);
    }
}
