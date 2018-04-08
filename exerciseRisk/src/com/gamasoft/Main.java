package com.gamasoft;

import com.gamasoft.commons.ConnectionPool;
import com.gamasoft.commons.Response;
import com.gamasoft.risk.RiskCalculator;

public class Main {

    public static void main(String[] args){

        ConnectionPool.getInstance().open("dbConn");

        RiskCalculator app = new RiskCalculator();

        Response r = app.calculateValueAtRisk("joe", "London");

        System.out.println(r.result);

        double pv = app.calculatePresentValue("joe", "London");

        System.out.println("PV: " + pv);

    }
}

