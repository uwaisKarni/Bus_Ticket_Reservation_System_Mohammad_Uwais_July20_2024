package com.reservation.infogain.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.reservation.infogain.domain.Reservation;
import com.reservation.infogain.domain.Seat;
import com.reservation.infogain.repository.UserRepository;

import lombok.Synchronized;

@Component
public class ReservationService {
    
   @Autowired 
   private  BusService busService;

   @Autowired 
   private UserRepository userRepository; 


    List<Reservation> reservations = new ArrayList<>();
   


    @Synchronized
    public Reservation reserveSeat(Long userId,Long busId, Long seatId) {
        
        Seat seat = busService.getSeat(busId,seatId);
        if(seat.isReserved()==false){
        seat.setReserved(true);
       
        Reservation reservation = new Reservation();
        reservation.setUserId(userId);
        reservation.setSeat(seat);
        reservations.add(reservation);
        reservation.setId(Long.valueOf(reservations.size()+1));
        return reservation;
        }
        throw new RuntimeException("Given Seat is Already Booked");
    }
}
 
