package com.assignment.rewards.service;

import com.assignment.rewards.dto.CustomerTransactionDTO;
import com.assignment.rewards.entity.CustomerTransaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerTransactionService {

    CustomerTransactionDTO saveTransaction(CustomerTransaction customerTransaction);

    List<CustomerTransactionDTO> getAllTransactions();
}
