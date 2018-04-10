package com.gamasoft;

import com.gamasoft.commons.ConnectionPool;
import com.gamasoft.report.Printer;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static com.gamasoft.risk.RiskCalculator.produceReport;
import static org.junit.Assert.*;

public class MainTest {

    private ByteArrayOutputStream byteArrayOutputStream;
    private Printer printer;

    @Before
    public void setup(){
        ConnectionPool.getInstance().open("dbConn");
        byteArrayOutputStream = new ByteArrayOutputStream();
        printer = new Printer("mainPrinter", byteArrayOutputStream);

    }

    @Test
    public void produceReportGekko(){

        produceReport("Gordon Gekko", "NY", printer);

        assertEquals("+--------------+\n" +
                "| Gordon Gekko |\n" +
                "| NY           |\n" +
                "| GBP          |\n" +
                "| trades: 4    |\n" +
                "| Risk: 0.444  |\n" +
                "| Pv: 226.294  |\n" +
                "+--------------+", byteArrayOutputStream.toString());
    }

    @Test
    public void produceReportFox(){

        produceReport("Bud Fox", "LDN", printer);

        assertEquals("+-------------+\n" +
                "| Bud Fox     |\n" +
                "| LDN         |\n" +
                "| GBP         |\n" +
                "| trades: 5   |\n" +
                "| Risk: 0.556 |\n" +
                "| Pv: 275.653 |\n" +
                "+-------------+", byteArrayOutputStream.toString());
    }

}