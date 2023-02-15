package com.example.karnika.services;

import org.springframework.stereotype.Service;

import com.example.karnika.dto.CodeGenerator;
import com.example.karnika.models.Account;
import com.example.karnika.repositories.AccountRepository;
import com.example.karnika.repositories.TransactionRepository;

import java.util.Optional;

@Service
public class AccountService  implements AccountServiceInterface {
	
	private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    
	
	public  AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
		this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
		
	}

	@Override
	public Account getAccount(String passCode, String accountNumber) {
		Optional<Account> account = accountRepository
                .findBypassCodeAndAccountNumber(passCode, accountNumber);

        account.ifPresent(value ->
                value.setTransactions(transactionRepository
                        .findBySourceAccountIdOrderByInitiationDate(value.getId())));

        return account.orElse(null);
	}

	@Override
	public Account getAccount(String accountNumber) {
		Optional<Account> account = accountRepository
                .findByAccountNumber(accountNumber);

        return account.orElse(null);
	}

	@Override
	public Account createAccount(String bankName, String ownerName) {
		CodeGenerator codeGenerator = new CodeGenerator();
        Account newAccount = new Account(bankName, ownerName, codeGenerator.generatepassCode(), codeGenerator.generateAccountNumber(), 0.00);
        return accountRepository.save(newAccount);
	}

	
	
}
