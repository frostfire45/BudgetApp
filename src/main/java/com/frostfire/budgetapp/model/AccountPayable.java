package com.frostfire.budgetapp.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accountPayable")
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
    @Column(name = "check_num")
    private Integer check_num;
    @Column(name = "payee")
    private String payee;
    @Column(name = "memo")
    private String memo;
    @Column(name = "amt_paid")
    private Double amtPaid;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "typeId")
    private ExpenseType exType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pay_accountId")
    private PayAccount payAccount;

    public AccountPayable() {}

    public AccountPayable(Long id, LocalDate posted_date, Double amount, Integer check_num, String payee, String memo, Double minDue, Double amtPaid, Double payoffBalance) {
        this.id = id;
        this.posted_date = posted_date;
        this.amount = amount;
        this.check_num = check_num;
        this.payee = payee;
        this.memo = memo;
        this.amtPaid = amtPaid;
    }
    public List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("Id");
        list.add("Posted Date");
        list.add("Amount");
        list.add("Check Number");
        list.add("Payee");
        list.add("Memo");
        list.add("AmtPaid");
        return list;
    }
    public Double getAmtPaid() {
        return amtPaid;
    }
    public void setAmtPaid(Double amtPaid) {
        this.amtPaid = amtPaid;
    }
    public Integer getCheck_num() {
        return check_num;
    }
    public void setCheck_num(Integer check_num) {
        this.check_num = check_num;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
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
