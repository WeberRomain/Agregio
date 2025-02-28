package io.weber.agregio.infra.repositories.MarketRepository;

import io.weber.agregio.domain.interfaces.repositories.MarketRepository;
import io.weber.agregio.domain.model.Market;
import io.weber.agregio.infra.entities.MarketEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MarketRepositoryAdapter implements MarketRepository {

    private final MarketRepositoryJpa marketRepositoryJpa;

    public MarketRepositoryAdapter(MarketRepositoryJpa marketRepositoryJpa){
        this.marketRepositoryJpa = marketRepositoryJpa;
    }
    @Override
    public Market save(String name) {
        return marketRepositoryJpa.save(new MarketEntity(name)).toModel();
    }

    @Override
    public List<Market> findAll() {
        return marketRepositoryJpa.findAll()
                .stream().map(MarketEntity::toModel).collect(Collectors.toList());
    }
}
