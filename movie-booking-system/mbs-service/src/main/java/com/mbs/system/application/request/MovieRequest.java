package com.mbs.system.application.request;

import com.mbs.system.domain.City;
import com.mbs.system.domain.Movie;
import lombok.Data;

import java.util.Date;


@Data
public class MovieRequest {
    private String title;
    private Integer movieDurationInMinutes;
    private String language;
    private Date releaseDate;
    private String country;
    private String genre;
    private String city;

    public Movie toMovie(){
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setMovieDurationInMinutes(movieDurationInMinutes);
        return movie;
    }

    public City getCity(){
        return new City();
    }
}
