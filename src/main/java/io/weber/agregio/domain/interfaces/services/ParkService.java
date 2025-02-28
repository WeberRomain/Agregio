package io.weber.agregio.domain.interfaces.services;

import io.weber.agregio.domain.model.Park;

import java.util.List;

public interface ParkService {
    Park findById(Long id);
    Park save(Park park);
    List<Park> findByMarket(Long marketId);
    List<Park> findAll();
}
