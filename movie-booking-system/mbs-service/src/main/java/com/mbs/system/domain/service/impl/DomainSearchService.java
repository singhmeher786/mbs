package com.mbs.system.domain.service.impl;

import com.mbs.system.domain.Movie;
import com.mbs.system.domain.Theatre;
import com.mbs.system.domain.service.SearchService;


import java.time.LocalDateTime;
import java.util.List;

public class DomainSearchService implements SearchService {
    @Override
    public java.util.List<Movie> browseMovies(String keyword, String city, double[] lat_long, double radius, LocalDateTime start_datetime, LocalDateTime end_datetime, String postal_code) {
        return null;
    }

    @Override
    public List<Theatre> browseTheatre(String keyword, String city, double[] lat_long, double radius, LocalDateTime start_datetime, LocalDateTime end_datetime, String postal_code) {
        return null;
    }
}
