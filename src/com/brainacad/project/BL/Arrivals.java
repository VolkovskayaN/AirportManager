package com.brainacad.project.BL;

public class Arrivals {
    private String flightNumber;
    private String date;
    private String time;
    private String cityOfArrival;
    private String terminal;
    private String flightStatus;
    private int id;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCityOfArrival() {
        return cityOfArrival;
    }

    public void setCityOfArrival(String cityOfArrival) {
        this.cityOfArrival = cityOfArrival;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
