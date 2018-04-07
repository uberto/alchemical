package com.gamasoft.al.before;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LiborInterestCalculator {

    public double calculateInterestForUser(String userId, double rate){

        User u = loadUserFromId(userId);
        List<Loan> loans =  loadUserLoans(u);
        double libor =  loadCurrentLiborRate();
        double sum = 0;
        for (Loan l: loans){
            sum += l.remainingAmount * (libor + rate);
        }
        return sum;
    }


    public <A> double  calculateInterestForUser(String userId,
                                                Function<User, A> init,
                                                BiFunction<A, Loan, Double> calc){

        User u = loadUserFromId(userId);
        List<Loan> loans =  loadUserLoans(u);
        A context =  init.apply(u);
        double sum = 0;
        for (Loan l: loans){
            sum += calc.apply(context, l);
        }
        return sum;
    }

    private double loadCurrentLiborRate() {
        return 0.4;
    }

    private User loadUserFromId(String userId) {
        return null;
    }

    private List<Loan> loadUserLoans(User user) {
        return new ArrayList<>();
    }

}
