package com.mbs.system.domain.service;

import com.mbs.system.domain.City;
import com.mbs.system.domain.Movie;

import java.util.List;

public interface MovieService {

    public Movie getMovieByName(String movieName);

    public List<Movie> getMoviesByCity(City city);

    public void add(Movie movie,City city);

    public void remove(Movie movie);

}
