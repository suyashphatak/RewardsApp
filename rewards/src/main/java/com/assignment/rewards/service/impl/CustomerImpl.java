package com.assignment.rewards.service.impl;

import com.assignment.rewards.dto.CustomerDTO;
import com.assignment.rewards.entity.Customer;
import com.assignment.rewards.repository.CustomerRepository;
import com.assignment.rewards.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public CustomerDTO saveCustomer(Customer customer) {
        Customer saved = customerRepository.save(customer);
        return mapper.map(saved, CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();

        List<CustomerDTO> dtoList = customerList.stream().map((customer) ->
             mapper.map(customer, CustomerDTO.class)
        ).collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public String deleteCustomer(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        customer.ifPresent(value -> customerRepository.delete(value));
        return "Customer deleted with ID :"+ id;

    }
}
