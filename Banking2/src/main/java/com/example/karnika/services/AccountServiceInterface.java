package com.example.karnika.services;

import java.util.Optional;

import com.example.karnika.dto.CodeGenerator;
import com.example.karnika.models.Account;
import com.example.karnika.repositories.AccountRepository;
import com.example.karnika.repositories.TransactionRepository;

public interface AccountServiceInterface {

    public Account getAccount(String sortCode, String accountNumber);

    public Account getAccount(String accountNumber);

    public Account createAccount(String bankName, String ownerName);
}
