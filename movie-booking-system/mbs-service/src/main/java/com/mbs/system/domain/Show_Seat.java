package com.mbs.system.domain;

import com.mbs.system.domain.enums.ShowSeatStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Show_Seat {
    private Integer showSeatId;
    private ShowSeatStatus status;
    private BigDecimal price;
    private Screen screen;
    private Show show;
    private Booking booking;
    private ScreenSeat screenSeat;
}
