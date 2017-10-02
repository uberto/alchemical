package com.gamasoft.sec.step1;

public class Main {
    public static void main(String[] args){
        Address a = new Address("777 No Street", "London, Uk", "WWW-777");
        Client c = new Client("Mr", "James Bond", a);

        Printer p = new Printer("usb");
        Functions.printLabel(c, p);
    }
}

