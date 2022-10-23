package com.example.bankaccountservice.mappers;

import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper implements IAccountMapper{
    @Override
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount)
    {
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return  bankAccountResponseDTO;
    }

    @Override
    public BankAccount fromBankAccountResponseDTO(BankAccountResponseDTO bankAccountResponseDTO)
    {
        BankAccount bankAccount=new BankAccount();
        BeanUtils.copyProperties(bankAccountResponseDTO,bankAccount);
        return  bankAccount;
    }
}
