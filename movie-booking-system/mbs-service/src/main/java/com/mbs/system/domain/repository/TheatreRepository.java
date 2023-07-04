package com.mbs.system.domain.repository;

import java.util.Optional;

public interface TheatreRepository {
    Optional<Theatre> findById(Long id);

    void save(Theatre order);
}
