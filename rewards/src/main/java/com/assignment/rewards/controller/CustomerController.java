package com.assignment.rewards.controller;

import com.assignment.rewards.dto.CustomerDTO;
import com.assignment.rewards.entity.Customer;
import com.assignment.rewards.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ModelMapper mapper;

    //Get All Customers
    @GetMapping("/getCustomersDetails")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    // Register/Add Customer
    @PostMapping("/saveCustomer")
    public ResponseEntity<CustomerDTO> saveCustomerDetails(@RequestBody CustomerDTO customerDTO){
        Customer customer = mapper.map(customerDTO, Customer.class);
        System.out.println("=>"+ customer.toString());
        CustomerDTO savedCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    // Delete Customer
    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id){
        String msg = customerService.deleteCustomer(id);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

}
