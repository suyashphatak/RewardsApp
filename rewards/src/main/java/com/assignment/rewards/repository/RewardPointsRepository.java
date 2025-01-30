package com.assignment.rewards.repository;

import com.assignment.rewards.entity.RewardPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardPointsRepository extends JpaRepository<RewardPoints, Integer> {

}
