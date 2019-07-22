package com.fragmental7.busappadmin;

public class User {

    // this is public to be accessible to firebase:
    public String destination;
    public String name;
    public String lastname;
    public int phone;
    public double latitude;
    public double longitude;

    public User(String destination, String name, String lastname, int phone) {
        this.destination = destination;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.latitude = 0;
        this.longitude = 0;
    }
}
