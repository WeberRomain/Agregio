package io.weber.agregio.domain.interfaces.services;

import io.weber.agregio.domain.model.Market;

import java.util.List;

public interface MarketService {
    Market save(String name);
    List<Market> findAll();
}
