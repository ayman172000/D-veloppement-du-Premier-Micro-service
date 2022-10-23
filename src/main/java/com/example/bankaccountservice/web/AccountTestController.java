package com.example.bankaccountservice.web;

import com.example.bankaccountservice.dto.BankAccountRequestDTO;
import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.mappers.IAccountMapper;
import com.example.bankaccountservice.repositories.BankAccountRepository;
import com.example.bankaccountservice.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AccountTestController {
    private AccountService accountService;
    IAccountMapper mapper;
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccount)
    {
        return accountService.addAccount(bankAccount);
    }


}
