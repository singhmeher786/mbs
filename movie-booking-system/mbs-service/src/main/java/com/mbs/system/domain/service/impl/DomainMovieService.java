package com.mbs.system.domain.service.impl;

import com.mbs.system.domain.City;
import com.mbs.system.domain.Movie;
import com.mbs.system.domain.service.MovieService;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainMovieService implements MovieService {

    private Map<City, List<Movie>> cityVsMovies;
    private List<Movie> allMovies;

    public DomainMovieService(){
        cityVsMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public Movie getMovieByName(String movieName) {
        return allMovies.stream()
                .filter(movie -> movie.getTitle().equals(movieName))
                .findFirst()
                .orElse(null);
    }


    public List<Movie> getMoviesByCity(City city) {
        return cityVsMovies.get(city);
    }

    @Override
    public void add(Movie movie,City city) {
        allMovies.add(movie);

        List<Movie> movies = cityVsMovies.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityVsMovies.put(city, movies);

    }

    @Override
    public void remove(Movie movie) {
        allMovies.remove(movie);
    }
}
