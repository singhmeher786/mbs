package com.mbs.system.domain.service;

import com.mbs.system.domain.Show_Seat;
import com.mbs.system.domain.exception.SeatCouldNotBookedException;

public interface BookingService {
    public void reserveSeats(Long transactionId, Long movie_id, Long show_id, Show_Seat seats_to_reserve[]) throws SeatCouldNotBookedException;

}
