package com.assignment.rewards.service;

import com.assignment.rewards.dto.RewardsMessageDTO;
import com.assignment.rewards.repository.RewardPointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RewardPointsService {

    List<RewardsMessageDTO> getSingleRewardPoint(int id);

    List<RewardsMessageDTO> getAllRewardDetails();
}
