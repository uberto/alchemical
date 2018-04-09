package com.gamasoft.report;

import com.gamasoft.commons.Utils;

public class Printer {

    public final String printerLocation;

    public Printer(String printerLocation) {
        Utils.notBlank(printerLocation, "printerLocation");
        this.printerLocation = printerLocation;

        System.out.println("opening " + printerLocation);
    }

    public void printReport(Report l){
        l.sendToPrinter();
    }

    public void printLine(String line){
        System.out.println(line); //simulate sending to printer
    }

}
