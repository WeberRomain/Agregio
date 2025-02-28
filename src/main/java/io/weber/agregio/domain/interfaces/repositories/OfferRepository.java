package io.weber.agregio.domain.interfaces.repositories;

import io.weber.agregio.domain.model.Offer;

import java.util.List;

public interface OfferRepository {
    Offer save(Offer offer);
    List<Offer> findByMarket(Long marketId);
    List<Offer> findAll();
}
