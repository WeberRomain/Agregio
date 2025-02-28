package io.weber.agregio.infra.repositories.OfferRepository;

import io.weber.agregio.domain.interfaces.repositories.OfferRepository;
import io.weber.agregio.domain.model.Offer;
import io.weber.agregio.infra.entities.OfferEntity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OfferRepositoryAdapter implements OfferRepository {

    private final OfferRepositoryJpa offerRepositoryJpa;

    public OfferRepositoryAdapter(OfferRepositoryJpa offerRepositoryJpa) {
        this.offerRepositoryJpa = offerRepositoryJpa;
    }

    @Override
    public Offer save(Offer offer) {
        return offerRepositoryJpa.save(new OfferEntity(offer)).toModel();
    }

    @Override
    public List<Offer> findByMarket(Long marketId) {
        return offerRepositoryJpa.findByMarketId(marketId)
                .stream().map(OfferEntity::toModel).toList();
    }

    @Override
    public List<Offer> findAll() {
        return offerRepositoryJpa.findAll()
                .stream().map(OfferEntity::toModel).toList();
    }
}
