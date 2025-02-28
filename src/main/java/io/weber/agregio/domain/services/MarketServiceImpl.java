package io.weber.agregio.domain.services;

import io.weber.agregio.domain.interfaces.repositories.MarketRepository;
import io.weber.agregio.domain.interfaces.services.MarketService;
import io.weber.agregio.domain.model.Market;

import java.util.List;

public class MarketServiceImpl implements MarketService {

    private final MarketRepository marketRepository;

    public MarketServiceImpl(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @Override
    public Market save(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Market name cannot be empty");
        }
        return marketRepository.save(name);
    }

    @Override
    public List<Market> findAll() {
        return marketRepository.findAll();
    }
}
