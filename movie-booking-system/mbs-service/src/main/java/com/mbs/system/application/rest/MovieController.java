package com.mbs.system.application.rest;

import com.mbs.system.application.request.MovieRequest;
import com.mbs.system.domain.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("isAuthenticated()")
    void addMovie(@RequestBody final MovieRequest movieRequest) {
        movieService.add(movieRequest.toMovie(),movieRequest.getCity());
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    void deleteMovie(@RequestBody final MovieRequest movieRequest) {
        movieService.remove(movieRequest.toMovie());
    }

}
