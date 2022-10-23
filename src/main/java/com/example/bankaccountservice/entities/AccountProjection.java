package com.example.bankaccountservice.entities;

import com.example.bankaccountservice.enums.AccountType;

//@Projection(type= BankAccount.class name="p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
}
