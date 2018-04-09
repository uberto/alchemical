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
        Printer printer = new Printer("mainPrinter");

        produceReport("Bud Fox", "LDN", printer);
        produceReport("Gordon Gekko", "NY", printer);

    }

    private static void produceReport(String client, String market, Printer printer) {
        RiskCalculator calc = new RiskCalculator();
        Portfolio pf = calc.getPortfolio(client);
        RiskResponse r = calc.calculateValueAtRisk(client, market, pf);
        double pv = calc.calculatePresentValue(client, market);


        ClientData cl = new ClientData(client, pf);
        RiskData riskData = new RiskData(cl, r, pv);
        Report rep = new Report(printer, riskData);

        printer.printReport(rep);
    }
}

