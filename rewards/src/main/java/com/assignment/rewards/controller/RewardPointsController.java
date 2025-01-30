package com.assignment.rewards.controller;


import com.assignment.rewards.dto.RewardsMessageDTO;
import com.assignment.rewards.service.RewardPointsService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/rewards")
public class RewardPointsController {

    @Autowired
    private RewardPointsService rewardService;

    @Autowired
    private ModelMapper mapper;

    //Get all customer rewards point details
    @GetMapping("/getAllRewardsDetails")
    public ResponseEntity<List<RewardsMessageDTO>> getAllRewards(){
        try {
            return ResponseEntity.ok(rewardService.getAllRewardDetails());
        }catch (NoSuchElementException e) {
            log.error("Error fetching all rewards: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //Get reward point details for single customer
    @GetMapping("/getRewards/{id}")
    public ResponseEntity<?> getSingleCustomerRewardDetails(@PathVariable int id){
        try {
            return new ResponseEntity<>( rewardService.getSingleRewardPoint(id), HttpStatus.OK);
        }catch (NoSuchElementException e) {
            log.error("Error fetching rewards for customerId {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found: " + id);
        } catch (Exception e) {
            log.error("Unexpected error for customerId {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!");
        }

    }




}
