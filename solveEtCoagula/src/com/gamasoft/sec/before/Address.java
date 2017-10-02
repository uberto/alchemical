package com.gamasoft.sec.before;

public class Address {
    public Client client;
    private String street;
    private String city;
    private String areaCode;

    public Address(String street, String city, String areaCode) {

        this.street = street;
        this.city = city;
        this.areaCode = areaCode;
    }

    public String[] getLines() {
        String[] lines = new String[4];
        lines[0] = client.title + " " + client.fullName;
        lines[1] = street;
        lines[2] = city;
        lines[3] = areaCode;
        return lines;
    }

}
