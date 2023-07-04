package com.mbs.system.domain.service;

import com.mbs.system.domain.Movie;
import com.mbs.system.domain.Theatre;

import java.time.LocalDateTime;
import java.util.List;


public interface SearchService {

    public List<Movie> browseMovies(String keyword, String city, double[] lat_long, double radius, LocalDateTime start_datetime,
                                    LocalDateTime end_datetime, String postal_code);


    public List<Theatre> browseTheatre(String keyword, String city, double[] lat_long, double radius, LocalDateTime start_datetime,
                                       LocalDateTime end_datetime, String postal_code);
}
