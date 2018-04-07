package com.gamasoft;

public class Main {



    public static void main(String[] args){

        Application app = new Application();

        Response r = app.calculateTodayRisk("joe", "ftse");

        System.out.println(r.result);
    }
}

