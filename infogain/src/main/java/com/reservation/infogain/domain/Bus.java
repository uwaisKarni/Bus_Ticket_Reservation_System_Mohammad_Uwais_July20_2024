package com.reservation.infogain.domain;

import java.util.List;

public class Bus {
    
    private Long id;
    private String busNumber;
    private String departureLocation;
    private String arrivalLocation;
    private String departureTime;
    private String arrivalTime;
    private List<Seat> seats;

    public Bus(Long id, String busNumber, String departureLocation, String arrivalLocation, String departureTime,
            String arrivalTime, List<Seat> seats) {
        this.id = id;
        this.busNumber = busNumber;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seats = seats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Bus [id=" + id + ", busNumber=" + busNumber + ", departureLocation=" + departureLocation
                + ", arrivalLocation=" + arrivalLocation + ", departureTime=" + departureTime + ", arrivalTime="
                + arrivalTime + ", seats=" + seats + "]";
    }
    
    
    
    

}
