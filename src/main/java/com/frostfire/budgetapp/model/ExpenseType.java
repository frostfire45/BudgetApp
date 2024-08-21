package com.frostfire.budgetapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "expense_type")
public class ExpenseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "accnt_type_name")
    private String name;
    @Column(name = "accnt_type_description")
    private String Description;

    @OneToOne(mappedBy = "exType")
    private AccountPayable accountPayable;

    public ExpenseType() {
    }

    public ExpenseType(Long id, String name, String description, ExpenseType expenseType) {
        this.id = id;
        this.name = name;
        Description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
