package com.assignment.rewards.service;

import com.assignment.rewards.dto.CustomerDTO;
import com.assignment.rewards.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    CustomerDTO saveCustomer(Customer customer);
    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int id);
}
