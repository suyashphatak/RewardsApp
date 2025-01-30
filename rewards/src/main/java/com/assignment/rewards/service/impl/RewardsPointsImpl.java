package com.assignment.rewards.service.impl;

import com.assignment.rewards.dto.RewardsMessageDTO;
import com.assignment.rewards.entity.CustomerTransaction;
import com.assignment.rewards.util.CalculateRewardPoints;
import com.assignment.rewards.repository.CustomerTransactionRepository;
import com.assignment.rewards.service.RewardPointsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RewardsPointsImpl implements RewardPointsService {

    @Autowired
    private CustomerTransactionRepository customerTransactionRepository;

    @Override
    public List<RewardsMessageDTO>  getSingleRewardPoint(int id) {

        log.info("Fetching reward points for customerId: {}", id);
        // Get all transactions of customer using customerId
        List<CustomerTransaction> byCustomerId = customerTransactionRepository.findByCustomerId(id);

        if(byCustomerId.isEmpty()){
            log.warn("No transactions found for customerId: {}", id);
            throw new NoSuchElementException("Customer not found: " + id);
        }
        // byCustomerId.forEach((customerTransaction -> System.out.println(customerTransaction.toString())));
        // Group by with CustomerId and transactions
        Map<Integer, List<CustomerTransaction>> customerTransactionmap = groupByWithCustomerId(byCustomerId);

        // Calculate each month and total rewards points and return to the user
        List<RewardsMessageDTO>  rewardsMessageDTO =  CalculateRewardPoints.calculateMonthWiseRewardPoints(customerTransactionmap);

        return rewardsMessageDTO;

    }

    @Override
    public List<RewardsMessageDTO> getAllRewardDetails() {
        log.info("Fetching reward points for all customers.");

        // Get all transactions of customer using customerId
        List<CustomerTransaction> transactions = customerTransactionRepository.findAll();

        if (transactions.isEmpty()) {
            log.warn("No transactions found in the system.");
            throw new NoSuchElementException("No customer transactions found.");
        }
        // Group by with CustomerId and transactions
        Map<Integer, List<CustomerTransaction>> customerTransactionmap = groupByWithCustomerId(transactions);

        // Calculate each month and total rewards points and return to the user
        List<RewardsMessageDTO>  rewardsMessageDTO =  CalculateRewardPoints.calculateMonthWiseRewardPoints(customerTransactionmap);

        return rewardsMessageDTO;
    }


    private Map<Integer, List<CustomerTransaction>> groupByWithCustomerId(List<CustomerTransaction> byCustomerId) {
        return byCustomerId
                .stream()
                .collect(Collectors.groupingBy(CustomerTransaction::getCustomerId));
    }

}
