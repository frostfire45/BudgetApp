package com.frostfire.budgetapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Bank")
public class Bank {

    public enum AccountType { Checking, Savings }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "account_type")
    private AccountType type;
    @Column(name = "account_balance")
    private double balance;

    // Constructors
    public Bank(){}
    public Bank( int id, String bankName, String accountNumber, AccountType type, double balance ){
        this.id = id;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.type = type;
        this.balance = balance;
    }

    // Setters
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public void setBalance(double balance) { this.balance = balance; }
    public void setBankName(String bankName) { this.bankName = bankName; }
    public void setId(int id) { this.id = id;}
    public void setType(AccountType type) { this.type = type;}
    // Getters
    public String getAccountNumber() { return accountNumber;}
    public double getBalance() { return balance; }
    public String getBankName() { return bankName;}
    public int getId() { return id;}
    public AccountType getType() { return type;}

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
