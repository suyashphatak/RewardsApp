package com.assignment.rewards.service.impl;

import com.assignment.rewards.dto.CustomerTransactionDTO;
import com.assignment.rewards.entity.CustomerTransaction;
import com.assignment.rewards.repository.CustomerTransactionRepository;
import com.assignment.rewards.service.CustomerTransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerTransactionImpl implements CustomerTransactionService {

    @Autowired
    private CustomerTransactionRepository customerTransactionRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CustomerTransactionDTO saveTransaction(CustomerTransaction customerTransaction) {
        CustomerTransaction saved = customerTransactionRepository.save(customerTransaction);
        return mapper.map(saved,CustomerTransactionDTO.class);
    }

    @Override
    public List<CustomerTransactionDTO> getAllTransactions() {
        List<CustomerTransaction> transactions = customerTransactionRepository.findAll();

        List<CustomerTransactionDTO> collect = transactions
                .stream()
                .map((transaction) -> mapper.map(transaction, CustomerTransactionDTO.class))
                .collect (Collectors.toList());

        return collect;
    }

}
