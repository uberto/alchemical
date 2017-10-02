package com.gamasoft.sec.step1;

public class Printer {

    public final String printerLocation;

    public Printer(String printerLocation) {
        this.printerLocation = printerLocation;

        System.out.println("opening " + printerLocation);
    }


}
