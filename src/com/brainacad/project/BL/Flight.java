package com.brainacad.project.BL;

public class Flight {
    private int id;
private String flightNumber;
    private String departurePort;
    private String arrivalPort;
    private String classOfSalon;
    private String price;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public void setDeparturePort(String departurePort) {
        this.departurePort = departurePort;
    }

    public String getArrivalPort() {
        return arrivalPort;
    }

    public void setArrivalPort(String arrivalPort) {
        this.arrivalPort = arrivalPort;
    }

    public String getClassOfSalon() {
        return classOfSalon;
    }

    public void setClassOfSalon(String classOfSalon) {
        this.classOfSalon = classOfSalon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
