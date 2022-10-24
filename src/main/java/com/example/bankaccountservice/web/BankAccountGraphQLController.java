package com.example.bankaccountservice.web;

import com.example.bankaccountservice.dto.BankAccountRequestDTO;
import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.entities.Customer;
import com.example.bankaccountservice.mappers.IAccountMapper;
import com.example.bankaccountservice.repositories.BankAccountRepository;
import com.example.bankaccountservice.repositories.CustomerRepository;
import com.example.bankaccountservice.services.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class BankAccountGraphQLController {
    private BankAccountRepository bankAccountRepository;
    private AccountService service;
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount> accountsList()
    {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id)
    {
        return bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("acoount % not found",id)));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount)
    {
        return service.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO requestDTO) {
        return service.updateAccount(id, requestDTO);
    }

    @MutationMapping
    public String deleteAccount(@Argument String id)
    {
        bankAccountRepository.deleteById(id);
        return "ok";
    }

    @QueryMapping
    public List<Customer> customers()
    {
        return customerRepository.findAll();
    }
}

/*
* au lieu de cree tous ça
@Data @NoArgsConstructor @AllArgsConstructor
class BankAccountDTO {
    private String type;
    private Double solde;
    private String devise;
}*/
/*
* on le remplace par record*/
/*record BankAccountDTO(Double solde,String accountType,String devise)
{
}*/
