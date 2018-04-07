package com.gamasoft.al.before;

import java.util.List;

public class CreditCheck {

    public final double creditRisk;

    public final List<String> creditHistory;

    public CreditCheck(double creditRisk, List<String> creditHistory) {
        this.creditRisk = creditRisk;
        this.creditHistory = creditHistory;
    }

    boolean isAtRisk(){
        return creditRisk > 0.75 || creditHistory.isEmpty();
    }
}
