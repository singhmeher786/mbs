package com.mbs.system.domain.service;

import com.mbs.system.domain.*;

import java.util.List;
import java.util.Map;

public interface TheatreService {

    public Map<Theatre, List<Show>> getAllShow(Movie movie, City city);

    public void add(Theatre theatre, City city);

    public void remove(Theatre theatre, City city);

    public List<Show_Seat> getAvailableSeats(Show show);
}
