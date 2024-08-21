package com.frostfire.budgetapp.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pay_accounts" )
public class PayAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name= "company")
    private String company;
    @Column(name = "bank_equiv")
    private String bankEquiv;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email_addr")
    private String emailAddr;
    @Column(name = "payoff_balance")
    private Double payoffBalance;
    @Column(name = "min_due")
    private Double minDue;
    @Column(name = "intrestRate")
    private Double intrestRate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "payAccount")
    private List<AccountPayable> accountPayableList = new ArrayList<>();

    public PayAccount() {
        this.accountPayableList = new ArrayList<>();
    }

    public PayAccount(Long id, String company, String bankEquiv, String phoneNumber, String emailAddr, List<AccountPayable> accountPayableList) {
        this.id = id;
        this.company = company;
        this.bankEquiv = bankEquiv;
        this.phoneNumber = phoneNumber;
        this.emailAddr = emailAddr;
        this.accountPayableList = accountPayableList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBankEquiv() {
        return bankEquiv;
    }

    public void setBankEquiv(String bankEquiv) {
        this.bankEquiv = bankEquiv;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public List<AccountPayable> getAccountPayableList() {
        return accountPayableList;
    }

    public void setAccountPayableList(List<AccountPayable> accountPayableList) {
        this.accountPayableList = accountPayableList;
    }
}
