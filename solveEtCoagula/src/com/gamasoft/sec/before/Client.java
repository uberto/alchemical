package com.gamasoft.sec.before;

public class Client {
    public Address address;
    public String title;
    public String fullName;

    public Client(String title, String fullname, Address address) {

        this.title = title;
        this.fullName = fullname;
        this.address = address;
        this.address.client = this;
    }
}
