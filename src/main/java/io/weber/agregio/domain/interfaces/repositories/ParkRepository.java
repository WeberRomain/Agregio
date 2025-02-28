package io.weber.agregio.domain.interfaces.repositories;

import io.weber.agregio.domain.model.Park;

import java.util.List;
import java.util.Optional;

public interface ParkRepository {
    Optional<Park> findById(Long id);
    Park save(Park park);
    List<Park> findAll();
    List<Park> findByMarketId(Long id);
}
