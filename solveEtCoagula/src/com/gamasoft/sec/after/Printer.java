package com.gamasoft.sec.after;

public class Printer {

    public final String printerLocation;

    public Printer(String printerLocation) {
        this.printerLocation = printerLocation;
        System.out.println("opening " + printerLocation);
    }


    public void printLine(String line){
        System.out.println(line); //simulate sending to printer
    }
}
