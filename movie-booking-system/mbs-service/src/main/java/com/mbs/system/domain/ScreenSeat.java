package com.mbs.system.domain;
import com.mbs.system.domain.enums.SeatCategory;
import lombok.Data;

@Data
public class ScreenSeat {
    private Integer theatreSeatId;
    private Integer seatNumber;
    private SeatCategory seatType;
    private Screen screen;
    private java.util.List<Show_Seat> showSeatList;

}
