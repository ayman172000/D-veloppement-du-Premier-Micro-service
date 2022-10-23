package com.example.bankaccountservice.entities;

import com.example.bankaccountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String id;
    private Date dateDeCreation;
    private double solde;
    private String devise;
    //@Enumerated(EnumType.STRING)
    private AccountType accountType;
}
