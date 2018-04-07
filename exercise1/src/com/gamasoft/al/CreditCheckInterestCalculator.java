package com.gamasoft.al;

import java.util.ArrayList;
import java.util.List;

public class CreditCheckInterestCalculator {

    public double calculateInterestForUser(String userId, double rate){

        User u = loadUserFromId(userId);
        List<Loan> loans =  loadUserLoans(u);
        CreditCheck cc = loadUserCreditCheck(u);

        double sum = 0;
        for (Loan l: loans){
            if (cc.isAtRisk())
                sum += l.remainingAmount * rate * 2;
            else
                sum += l.remainingAmount * rate;
        }
        return sum;
    }

    private CreditCheck loadUserCreditCheck(User u) {
        return null;
    }

    private User loadUserFromId(String userId) {
        return null;
    }

    private List<Loan> loadUserLoans(User user) {
        return new ArrayList<>();
    }
}
