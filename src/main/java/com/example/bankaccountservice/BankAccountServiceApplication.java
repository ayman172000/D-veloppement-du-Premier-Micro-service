package com.example.bankaccountservice;

import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.enums.AccountType;
import com.example.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository){
        return args -> {
            for (int i=1;i<=10;i++)
            {
                BankAccount bankAccount=BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .accountType(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                        .dateDeCreation(new Date())
                        .solde(1000+Math.random()*90000)
                        .devise("MAD")
                        .build();
                bankAccountRepository.save(bankAccount);
            }
        };
    }
}
