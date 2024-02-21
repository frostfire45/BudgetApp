package com.frostfire.budgetapp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "account_payable")
public class AccountPayable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "posted_date")
    @Temporal(TemporalType.DATE)
    private LocalDate posted_date;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "payee")
    private String payee;

    public AccountPayable() {}

    public AccountPayable(LocalDate posted_date, Double amount, String payee) {
        this.posted_date = posted_date;
        this.amount = amount;
        this.payee = payee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPosted_date() {
        return posted_date;
    }

    public void setPosted_date(LocalDate posted_date) {
        this.posted_date = posted_date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }
}
