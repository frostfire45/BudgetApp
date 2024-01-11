package com.frostfire.budgetapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "posted_date")
    @Temporal(TemporalType.DATE)
    private LocalDate posted_date;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "check_num")
    private int check_num;
    @Column(name = "payee")
    private String payee;
    @Column(name = "memo")
    private String memo;

    public Transaction(LocalDate posted_date, Double amount, int check_num, String payee, String memo) {
        this.posted_date = posted_date;
        this.amount = amount;
        this.check_num = check_num;
        this.payee = payee;
        this.memo = memo;
    }

    public Transaction() {

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getPosted_date() { return posted_date; }
    public void setPosted_date(LocalDate posted_date) { this.posted_date = posted_date; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public int getCheck_num() { return check_num; }
    public void setCheck_num(int check_num) { this.check_num = check_num; }
    public String getPayee() { return payee; }
    public void setPayee(String payee) { this.payee = payee; }
    public String getMemo() { return memo; }
    public void setMemo(String memo) { this.memo = memo; }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", posted_date='" + posted_date + '\'' +
                ", amount=" + amount +
                ", check_num=" + check_num +
                ", payee='" + payee + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
