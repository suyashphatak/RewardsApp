package com.assignment.rewards.repository;


import com.assignment.rewards.entity.CustomerTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerTransactionRepository extends JpaRepository<CustomerTransaction, Integer> {

    List<CustomerTransaction> findByCustomerId(int id);
}
