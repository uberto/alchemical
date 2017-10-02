package com.gamasoft.sec.step1;

public class Client {
    public final Address address;
    public final String title;
    public final String fullName;

    public Client(String title, String fullname, Address address) {

        this.title = title;
        this.fullName = fullname;
        this.address = address;
    }
}
