package com.example.bankaccountservice.services;

import com.example.bankaccountservice.dto.BankAccountRequestDTO;
import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.enums.AccountType;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO requestDTO);
}
