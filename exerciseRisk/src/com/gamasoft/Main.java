package com.gamasoft;

import com.gamasoft.commons.ConnectionPool;
import com.gamasoft.risk.RiskResponse;
import com.gamasoft.markets.Portfolio;
import com.gamasoft.report.ClientData;
import com.gamasoft.report.Printer;
import com.gamasoft.report.Report;
import com.gamasoft.report.RiskData;
import com.gamasoft.risk.RiskCalculator;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import static com.gamasoft.risk.RiskCalculator.produceReport;

public class Main {

    public static void main(String[] args){

        ConnectionPool.getInstance().open("dbConn");
        Printer printer = new Printer("mainPrinter", System.out);

        produceReport("Bud Fox", "LDN", printer);
        produceReport("Gordon Gekko", "NY", printer);

    }


}

