package com.mbs.system.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Show {

    private Integer showId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    Movie movie;
    Screen screen;
    List<Show_Seat> showSeatList;
    List<Booking> bookingList;
}
