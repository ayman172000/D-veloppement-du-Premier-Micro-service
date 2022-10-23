package com.example.bankaccountservice.services;

import com.example.bankaccountservice.dto.BankAccountRequestDTO;
import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.mappers.IAccountMapper;
import com.example.bankaccountservice.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    BankAccountRepository bankAccountRepository;
    IAccountMapper mapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO requestDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .dateDeCreation(new Date())
                .solde(requestDTO.getSolde())
                .accountType(requestDTO.getAccountType())
                .devise(requestDTO.getDevise())
                .build();
        BankAccount save = bankAccountRepository.save(bankAccount);
        /*BankAccountResponseDTO bankAccountResponseDTO=BankAccountResponseDTO.builder()
                .id(save.getId())
                .accountType(save.getAccountType())
                .devise(save.getDevise())
                .dateDeCreation(save.getDateDeCreation())
                .solde(save.getSolde())
                .build();*/
        return mapper.fromBankAccount(save);
    }
}
