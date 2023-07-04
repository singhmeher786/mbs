package com.mbs.system.domain;

import com.mbs.system.domain.enums.BookingStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Booking {

    private Long bookingId;
    private Integer numberOfSeats;
    private LocalDateTime dateTime;
    private BookingStatus bookingStatus;
    private User user;

    private Show show;
    private List<Show_Seat> bookedSeats = new ArrayList<>();
    private Payment payment;

}
