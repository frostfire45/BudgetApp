package com.frostfire.budgetapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class BankTransaction {
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
    private Integer check_num;
    @Column(name = "payee")
    private String payee;
    @Column(name = "memo")
    private String memo;

    public BankTransaction(LocalDate posted_date, Double amount, Integer check_num, String payee, String memo) {
        this.posted_date = posted_date;
        this.amount = amount;
        this.check_num = check_num;
        this.payee = payee;
        this.memo = memo;
    }

    public BankTransaction() {

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getPosted_date() { return posted_date; }
    public void setPosted_date(LocalDate posted_date) { this.posted_date = posted_date; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public Integer getCheck_num() { return check_num; }
    public void setCheck_num(Integer check_num) { this.check_num = check_num; }
    public String getPayee() { return payee; }
    public void setPayee(String payee) { this.payee = payee; }
    public String getMemo() { return memo; }
    public void setMemo(String memo) { this.memo = memo; }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "id=" + id +
                ", posted_date='" + posted_date + '\'' +
                ", amount=" + amount +
                ", check_num=" + check_num +
                ", payee='" + payee + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
