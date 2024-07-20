package com.reservation.infogain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.infogain.domain.Reservation;
import com.reservation.infogain.services.ReservationService;

@RestController
@RequestMapping("/resevre")
public class ReservationController {
     
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/seat")
    public ResponseEntity<?> reserveSeat(@RequestParam Long userId,@RequestParam Long busId, @RequestParam Long seatId) {
        Reservation reservation =reservationService.reserveSeat(userId, busId, seatId);
        if (reservation==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Such seat Availabe"); 
          }
        return ResponseEntity.ok().body("Seat is booked with Reservation id is :: "+reservation.getId());
    }
}
