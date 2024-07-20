package com.reservation.infogain.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.reservation.infogain.domain.Bus;
import com.reservation.infogain.domain.Seat;

@Service
public class BusService {

 static Map<Long,Bus> buses = new HashMap<>();

 static{
   Bus b1 = new Bus(1L, "bus01", "GGN", "Noida","10","12",null);
   b1.setSeats(createSeats(b1));  
   buses.put(b1.getId(), b1);
   Bus b2 = new Bus(2L, "bus02", "Delhi", "Jaipur","1","8",null);
   b2.setSeats(createSeats(b2));
   buses.put(b2.getId(), b2);

 }
 //Long id, String seatNumber, boolean isReserved, Bus bus
  private static List<Seat> createSeats(Bus bus) {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            seats.add(new Seat(Long.valueOf(i), String.valueOf((char) (i + 64)) + i, false, bus)); // Efficient seat numbering
        }
        return seats;
    }
   
    public List<Bus> searchBuses(String departureLocation, String arrivalLocation) {
        return buses.values().stream()
                .filter(bus -> bus.getDepartureLocation().equals(departureLocation) && bus.getArrivalLocation().equals(arrivalLocation))
                .collect(Collectors.toList());
                
    }

    public List<String> getBusRoutes() {
        return buses.values().stream()
        .map(bus -> "Bus ID: " + bus.getId() + ", Route: " + bus.getDepartureLocation() + " - " + bus.getArrivalLocation())
        .collect(Collectors.toList());
    }

    public List<Long> getAvailableSeatIds(Long busId) {
        Bus bus = buses.get(busId);
        if (bus != null) {
            return bus.getSeats().stream()
                    .filter(seat -> !seat.isReserved())
                    .map(Seat::getId)  
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }
    
    public  Seat getSeat(Long busId, Long seatId) {
        Bus bus = buses.get(busId);
        if (bus != null) {
            for (Seat seat : bus.getSeats()) {
                if (seat.getId().equals(seatId)) {
                    return seat;
                }
            }
        }
        return null; // Seat not found
    }
    
}
