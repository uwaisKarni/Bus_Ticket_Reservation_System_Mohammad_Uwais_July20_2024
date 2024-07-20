package com.reservation.infogain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.infogain.domain.Bus;
import com.reservation.infogain.services.BusService;

@RestController
@RequestMapping("/search")
public class SearchController {
   
   @Autowired
   private BusService busService;

    @GetMapping("/basedon-arr-dep")
  //  @PreAuthorize("isAuthenticated()") // Only allow access to authenticated users
    public ResponseEntity<?> searchBuses(@RequestParam String departureLocation, @RequestParam String arrivalLocation) {
        List<Bus> buses = busService.searchBuses(departureLocation, arrivalLocation); 
        if (buses.isEmpty()) {
            return ResponseEntity.noContent().build(); 
          }
        return ResponseEntity.ok(buses);
    } 

    @GetMapping("/buses-routes")
   // @PreAuthorize("isAuthenticated()") // Only allow access to authenticated users
    public ResponseEntity<?> searchBusesRoutes() {
        List<String> routes = busService.getBusRoutes(); 
        if (routes.isEmpty()) {
            return ResponseEntity.noContent().build();
          }
        return ResponseEntity.ok(routes);
    } 

    @GetMapping("/availabeSeats")
   // @PreAuthorize("isAuthenticated()") // Only allow access to authenticated users
    public ResponseEntity<?> availabeSeats(@RequestParam Long busId) {
        List<Long> seatList = busService.getAvailableSeatIds(busId); 
        if (seatList.isEmpty()) {
            return ResponseEntity.noContent().build(); 
          }
        return ResponseEntity.ok(seatList);
    } 
    
}
