package com.example.karnika.dto;

import javax.validation.constraints.Positive;
import java.util.Objects;

public class WithdrawInput extends AccountInput{
    String passCode;
    String accountNumber;

    // Prevent fraudulent transfers attempting to abuse currency conversion errors
    @Positive(message = "Transfer amount must be positive")
    private double amount;

    public WithdrawInput() {
        this.passCode = super.getpassCode();
        this.accountNumber = super.getAccountNumber();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AccountInput{" +
                "passCode='" + passCode + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WithdrawInput that = (WithdrawInput) o;
        return Objects.equals(passCode, that.passCode) &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passCode, accountNumber, amount);
    }
}
