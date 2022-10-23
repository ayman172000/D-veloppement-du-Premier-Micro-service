package com.example.bankaccountservice.mappers;

import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;

public interface IAccountMapper {
    BankAccountResponseDTO fromBankAccount(BankAccount bankAccount);

    BankAccount fromBankAccountResponseDTO(BankAccountResponseDTO bankAccountResponseDTO);
}
