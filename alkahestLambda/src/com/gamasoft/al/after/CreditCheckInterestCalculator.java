package com.gamasoft.al.after;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class CreditCheckInterestCalculator {

    private final InterestCalculator ic;

    public CreditCheckInterestCalculator(InterestCalculator ic) {
        this.ic = ic;
    }

    public double calculateInterestForUser(String userId, double rate) {

        BiFunction<CreditCheck, Loan, Double> calculateInterest = (cc, loan) -> {
            if (cc.isAtRisk())
                return loan.remainingAmount * rate * 2;
            else
                return loan.remainingAmount * rate;
        };

        return ic.calculateInterestForUser(userId,
                this::loadUserCreditCheck, calculateInterest);
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
