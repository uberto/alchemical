package com.gamasoft.al.after;

import java.util.List;

public class LiborInterestCalculator {

    private final InterestCalculator ic;

    public LiborInterestCalculator(InterestCalculator ic) {
        this.ic = ic;
    }


    public double calculateInterestForUser(String userId, double rate){

        return ic.calculateInterestForUser(userId,
                u -> loadCurrentLiborRate(),
                (libor, loan) -> loan.remainingAmount * (libor + rate));
    }



    private double loadCurrentLiborRate() {
        return 0.4;
    }


}
