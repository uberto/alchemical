package com.gamasoft;

import com.gamasoft.commons.ConnectionPool;
import com.gamasoft.risk.RiskResponse;
import com.gamasoft.markets.Portfolio;
import com.gamasoft.report.ClientData;
import com.gamasoft.report.Printer;
import com.gamasoft.report.Report;
import com.gamasoft.report.RiskData;
import com.gamasoft.risk.RiskCalculator;

public class Main {

    public static void main(String[] args){

        ConnectionPool.getInstance().open("dbConn");

        RiskCalculator calc = new RiskCalculator();

        String client = "joe";
        Portfolio pf = calc.getPortfolio(client);

        RiskResponse r = calc.calculateValueAtRisk(client, "London", pf);

        System.out.println(r.result);

        double pv = calc.calculatePresentValue(client, "London");

        System.out.println("PV: " + pv);

        ClientData cl = new ClientData(client, pf);
        RiskData riskData = new RiskData(cl, r, pv);
        Printer printer = new Printer("mainPrinter");
        Report rep = new Report(printer, riskData);

        printer.printReport(rep);

    }
}

