package com.gamasoft.report;

import com.gamasoft.risk.CalcResult;
import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//label
public class Report {
    private RiskData riskData;
    private Printer printer;

    public Report(Printer printer, RiskData riskData) {
        this.printer = printer;
        this.riskData = riskData;
    }

    void sendToPrinter() {
        ClientData clientData = riskData.clientData;
        int mx = 0;

        List<String> lines = clientData.getLines();
        CalcResult result = riskData.riskResponse.result;
        if (result.isSuccess) {
            lines.add("Risk: " + String.format("%4.3f", result.risk));
        } else {
            lines.add("Failure! " +  result.errors);
        }
        lines.add("Pv: " + String.format("%4.3f", riskData.pv));


        for (String line : lines) {
            mx = mx > line.length() ? mx: line.length();
        }
        String side = "+" + createString(mx - 2, "-") + "+";
        printer.printLine(side);
        for (String line : lines) {
            String spaces = createString(mx - line.length() - 4, " ");
            printer.printLine("| " + line + spaces + " |");
        }


        printer.printLine(side);
    }

    private String createString(int length, String ofChar) {
        return new String(new char[length + 4]).replace("\0", ofChar);
    }
}
