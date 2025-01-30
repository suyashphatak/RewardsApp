package com.assignment.rewards.controller;

import com.assignment.rewards.dto.CustomerTransactionDTO;
import com.assignment.rewards.entity.CustomerTransaction;
import com.assignment.rewards.service.CustomerTransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class CustomerTransactionController {

    @Autowired
    private CustomerTransactionService customerTransactionService;

    @Autowired
    private ModelMapper mapper;

    //Get all transactions
    @GetMapping("/getTransactionDetails")
    public ResponseEntity<List<CustomerTransactionDTO>> getAllTransactions(){
        List<CustomerTransactionDTO> transactionDTOListList = customerTransactionService.getAllTransactions();
        return new ResponseEntity<>(transactionDTOListList, HttpStatus.OK);
    }

    //Add Transactions
    @PostMapping("/saveTransaction")
    public ResponseEntity<CustomerTransactionDTO> saveTransaction(@RequestBody CustomerTransactionDTO customerTransactionDTO){
        // Convert DTO to entity
        CustomerTransaction customerTransaction = mapper.map(customerTransactionDTO, CustomerTransaction.class);
        CustomerTransactionDTO saved = customerTransactionService.saveTransaction(customerTransaction);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }


    //Edit/update transactions

    //Delete Transactions

}
