package io.weber.agregio.domain.interfaces.repositories;

import io.weber.agregio.domain.model.Market;

import java.util.List;

public interface MarketRepository {
    Market save(String name);
    List<Market> findAll();
}
