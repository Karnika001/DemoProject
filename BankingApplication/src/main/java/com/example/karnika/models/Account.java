package com.example.karnika.models;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

// TODO Add support for multiple account types (business, savings, etc.)
// TODO Add support for foreign currency accounts
@Entity
@Table(name = "account", schema = "online_bank")
public class Account {

    @Id @GeneratedValue
    private long id;

    private String passCode;

    private String accountNumber;

    private double currentBalance;

    private String bankName;

    private String userName;

    private transient List<Transaction> transactions;

    protected Account() {}
    public Account(String bankName, String userName, String generateSortCode, String generateAccountNumber, double currentBalance) {
        this.passCode = generateSortCode;
        this.accountNumber = generateAccountNumber;
        this.currentBalance = currentBalance;
        this.bankName = bankName;
        this.userName = userName;
    }
    public Account(long id, String sortCode, String accountNumber, double currentBalance, String bankName, String userName) {
        this.id = id;
        this.passCode = sortCode;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.bankName = bankName;
        this.userName = userName;
    }

    public Account(long id, String sortCode, String accountNumber, double currentBalance, String bankName, String userName, List<Transaction> transactions) {
        this.id = id;
        this.passCode = sortCode;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.bankName = bankName;
        this.userName = userName;
        this.transactions = transactions;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPassCode() {
        return passCode;
    }
    public void setPassCode(String sortCode) {
        this.passCode = sortCode;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
    public String getuserName() {
        return userName;
    }
    public void setuserName(String userName) {
        this.userName = userName;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", passCode='" + passCode + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", currentBalance=" + currentBalance +
                ", bankName='" + bankName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
