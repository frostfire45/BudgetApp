package com.frostfire.budgetapp.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "web_config")
public class WebConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "CONFIG_CD")
    private String config_cd;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "VALUE")
    private String value;
    @Column(name = "ACTIVE_FLAG")
    private char activeFlag;

    public WebConfig() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConfig_cd() {
        return config_cd;
    }

    public void setConfig_cd(String bankName) {
        this.config_cd = bankName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String accountNumber) {
        this.category = accountNumber;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public char getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(char activeFlag) {
        this.activeFlag = activeFlag;
    }

    @Override
    public String toString() {
        return "WebConfigService{" +
                "id=" + id +
                ", bankName='" + config_cd + '\'' +
                ", accountNumber='" + category + '\'' +
                ", value='" + value + '\'' +
                ", activeFlag=" + activeFlag +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebConfig webConfig = (WebConfig) o;
        return getId() == webConfig.getId() && getActiveFlag() == webConfig.getActiveFlag() && Objects.equals(getConfig_cd(), webConfig.getConfig_cd()) && Objects.equals(getCategory(), webConfig.getCategory()) && Objects.equals(getValue(), webConfig.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getConfig_cd(), getCategory(), getValue(), getActiveFlag());
    }
}
