package com.mbs.system.domain;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
public class Movie {

    private Integer movieId;
    private String title;
    private Integer movieDurationInMinutes;
    private String language;
    private Date releaseDate;
    private String country;
    private String genre;
    private List<Show> showList;
}
