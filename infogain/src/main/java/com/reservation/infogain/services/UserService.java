package com.reservation.infogain.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reservation.infogain.domain.User;


@Service
public class UserService {
     
    Map<String,User> users = new HashMap<>();
       Long id = 1L; 
       

       public String add(String username,String password){   
          if(users.containsKey(username)){
             throw new RuntimeException("User Already Exist with Given UserName");
          }
          User user = new User(username, password);
          user.setId(id++);
          users.put(username,user);
         return "User Added Successfully";

       }
     
    public Collection<User> getAllUsers() {
        return users.values(); 
    }

    public Optional<User> getUserByUsername(String username) {
        return Optional.ofNullable(users.get(username)); 
    }

    public Map<String, User> getUsers() {
        return users;
    }

}

/* 
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    public List<Bus> searchBuses(String departureLocation, String arrivalLocation) {
        return busRepository.findByDepartureLocationAndArrivalLocation(departureLocation, arrivalLocation);
    }
}

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> viewAvailableSeats(Long busId) {
        return seatRepository.findByBusIdAndIsReservedFalse(busId);
    }
}

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private SeatRepository seatRepository;

    @Transactional
    public Reservation reserveSeat(Long userId, Long seatId) {
        Seat seat = seatRepository.findById(seatId).orElseThrow();
        seat.setReserved(true);
        seatRepository.save(seat);

        Reservation reservation = new Reservation();
        reservation.setUser(new User(userId));
        reservation.setSeat(seat);
        return reservationRepository.save(reservation);
    }
}
*/