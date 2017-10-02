package com.gamasoft.sec.after;

public class Client {
    public final Address address;
    public final String title;
    public final String fullName;

    public Client(String title, String fullname, Address address) {

        this.title = title;
        this.fullName = fullname;
        this.address = address;
    }

    public String[] getLines() {
        String[] lines = new String[4];
        lines[0] = this.title + " " + this.fullName;
        lines[1] = this.address.street;
        lines[2] = this.address.city;
        lines[3] = this.address.areaCode;
        return lines;
    }
}
