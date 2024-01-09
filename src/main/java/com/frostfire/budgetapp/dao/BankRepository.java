package com.frostfire.budgetapp.dao;

import com.frostfire.budgetapp.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BankRepository extends JpaRepository<Bank,Integer> {
    //List<Bank> getAllByIdExists();
    //Bank findBankByAccountNumber(String accountNumber);
}
