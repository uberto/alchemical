package com.gamasoft.al.after;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class InterestCalculator {
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

    private User loadUserFromId(String userId) {
        return null;
    }

    private List<Loan> loadUserLoans(User user) {
        return new ArrayList<>();
    }

}
