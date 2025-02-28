package io.weber.agregio.domain.interfaces.services;

import io.weber.agregio.domain.model.Offer;
import io.weber.agregio.domain.model.OfferRequest;

import java.util.List;

public interface OfferService {
    Offer save(OfferRequest request);
    List<Offer> findByMarket(Long marketId);
    List<Offer> findAll();
}
