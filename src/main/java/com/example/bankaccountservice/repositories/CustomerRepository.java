package com.example.bankaccountservice.repositories;

import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.entities.Customer;
import com.example.bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@RepositoryRestRessource
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
