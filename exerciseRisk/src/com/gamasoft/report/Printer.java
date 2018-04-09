package com.gamasoft.report;

import com.gamasoft.commons.Utils;

import java.io.PrintStream;

public class Printer {

    public final String printerLocation;
    private PrintStream outStream;

    public Printer(String printerLocation, PrintStream outStream) {
        this.outStream = outStream;
        Utils.notBlank(printerLocation, "printerLocation");
        this.printerLocation = printerLocation;
    }

    public void printReport(Report l){
        l.sendToPrinter();
    }

    public void printLine(String line){
        outStream.println(line); //simulate sending to printer
    }

}
