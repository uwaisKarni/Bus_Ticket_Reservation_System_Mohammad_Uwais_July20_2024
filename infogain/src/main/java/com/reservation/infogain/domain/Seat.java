package com.reservation.infogain.domain;

public class Seat {
    
    private Long id;
    private String seatNumber;
    private boolean isReserved; 
    private Bus bus;

    public Seat(Long id, String seatNumber, boolean isReserved, Bus bus) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.isReserved = isReserved;
        this.bus = bus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @Override
    public String toString() {
        return "Seat [id=" + id + ", seatNumber=" + seatNumber + ", isReserved=" + isReserved + ", bus=" + bus + "]";
    }
   
    
    
     
    
}
