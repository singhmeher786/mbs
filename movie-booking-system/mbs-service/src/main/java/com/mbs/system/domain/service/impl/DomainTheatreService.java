package com.mbs.system.domain.service.impl;

import com.mbs.system.domain.*;
import com.mbs.system.domain.service.TheatreService;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DomainTheatreService implements TheatreService {
    private Map<City, List<Theatre>> cityVsTheatre;
    private List<Theatre> allTheatre;

    public DomainTheatreService() {
        cityVsTheatre = new HashMap<>();
        allTheatre = new ArrayList<>();
    }


    public Map<Theatre, List<Show>> getAllShow(Movie movie, City city) {

        //get all the theater of this city

        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();

        List<Theatre> theatres = cityVsTheatre.get(city);

        //filter the theatres which run this movie

        for(Theatre theatre : theatres) {

            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getScreen().stream().map(Screen::getShow).collect(Collectors.toList());
            shows.stream().filter(show -> show.getMovie().getMovieId() == movie.getMovieId()).forEach(givenMovieShows::add);
            if(!givenMovieShows.isEmpty()) {
                theatreVsShows.put(theatre, givenMovieShows);
            }
        }

        return theatreVsShows;
    }

    @Override
    public void add(Theatre theatre, City city) {
        allTheatre.add(theatre);

        List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city, theatres);

    }

    @Override
    public void remove(Theatre theatre, City city) {

    }
}
