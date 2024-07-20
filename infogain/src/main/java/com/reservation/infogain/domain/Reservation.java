package com.reservation.infogain.domain;


public class Reservation  {
    
    private Long id;
    private Long userId;
    public Long getUserId() {
      return userId;
    }

    public void setUserId(Long userId) {
      this.userId = userId;
    }

    private Seat seat;
    

    public Reservation() {
     
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

   
    public Seat getSeat() {
      return seat;
    }

    public void setSeat(Seat seat) {
      this.seat = seat;
    }

    
    
    
}
