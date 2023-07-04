package com.mbs.system.domain.repository;

import java.util.Optional;

public interface MovieRepostiory {
    Optional<Movie> findById(Long id);

    void save(Movie order);
}
