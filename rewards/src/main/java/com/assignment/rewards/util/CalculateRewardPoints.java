package com.assignment.rewards.util;

import com.assignment.rewards.dto.RewardsMessageDTO;
import com.assignment.rewards.entity.CustomerTransaction;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateRewardPoints {

    private static final DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MM");
    private static final DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy");

    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
    private static final BigDecimal FIFTY = BigDecimal.valueOf(50);
    private static final BigDecimal TWO = BigDecimal.valueOf(2);

    /**
     * Calculates reward points based on transaction amount.
     */
    public static long calculateRewardsPoint(BigDecimal amount){

        if(amount == null || amount.compareTo(FIFTY) <= 0) return 0;

        BigDecimal points = BigDecimal.ZERO;

        if(amount.compareTo(HUNDRED) > 0){
            points = amount.subtract(HUNDRED).multiply(TWO);
            amount = HUNDRED;
        }

        if( (amount.compareTo(FIFTY) > 0)) {
            points = points.add(amount.subtract(FIFTY));
        }
        return points.longValue();
    }
    /**
     * Groups transactions by customer and calculates reward points for each month.
     */
    public static List<RewardsMessageDTO> calculateMonthWiseRewardPoints(Map<Integer, List<CustomerTransaction>> customerTransactionmap) {

        List<RewardsMessageDTO> rewardsMessageDTOList = new ArrayList<>();

        for(Map.Entry<Integer, List<CustomerTransaction>> mapItr: customerTransactionmap.entrySet()) {

            Map<String, Long> dateMap = new HashMap<>();
            RewardsMessageDTO rewardsMessage = new RewardsMessageDTO();

            for (CustomerTransaction listItr : mapItr.getValue()) {

                String month = monthFormatter.format(listItr.getDate());
                String year = yearFormatter.format(listItr.getDate());
                String monthAndYear = month +"-"+ year;

                if (dateMap.containsKey(monthAndYear)) {
                    Long points = dateMap.get(monthAndYear);
                    points = points + CalculateRewardPoints.calculateRewardsPoint(listItr.getAmount());
                    dateMap.put(monthAndYear, points);
                } else {
                    dateMap.put(monthAndYear, CalculateRewardPoints.calculateRewardsPoint(listItr.getAmount()));
                }
            }
            rewardsMessage = setupRewardsMessageDTO(mapItr.getKey(), dateMap, rewardsMessage);
            rewardsMessageDTOList.add(rewardsMessage);
        }

        return rewardsMessageDTOList;
    }

    private static RewardsMessageDTO setupRewardsMessageDTO(Integer customerId, Map<String, Long> dateMap, RewardsMessageDTO rewardsMessageDTO) {

        long totalSum = dateMap.values().stream().mapToLong(Long::longValue).sum();

        rewardsMessageDTO.setCustomerId(customerId);
        rewardsMessageDTO.setPerMonth(dateMap);
        rewardsMessageDTO.setTotal(totalSum);

        return rewardsMessageDTO;
    }


// ----------------------------------------------------------------------------------------------
//    public static long calculateRewardsPoint(BigDecimal amount){
//        long result = 0;
//
//        If amount is greater than > 100
//        if( amount.compareTo(HUNDRED) > 0){
//
//            BigDecimal subtract = amount.subtract(HUNDRED);
//            BigDecimal multiply = subtract.multiply(TWO).add(FIFTY);
//            result = multiply.longValue();
//
//        }else if( (amount.compareTo(FIFTY) > 0)) { //If amount is greater than > 50
//
//            BigDecimal subtract = amount.subtract(FIFTY);
//            result = subtract.longValue();
//
//        }
//        return  result;
//    }
// ----------------------------------------------------------------------------------------------
//
//      Group Customer with their transaction by customerID

//        for(CustomerTransaction transaction: byCustomerId){
//
//            if(customerTransactionmap.containsKey(transaction.getCustomerId())){
//
//                List<CustomerTransaction> customerTransactions = customerTransactionmap.get(transaction.getCustomerId());
//                customerTransactions.add(transaction);
//                customerTransactionmap.put(transaction.getCustomerId(),customerTransactions);
//
//            }else{
//                List<CustomerTransaction> list = new ArrayList<>();
//                list.add(transaction);
//                customerTransactionmap.put(transaction.getCustomerId(), list);
//            }
//        }

}
