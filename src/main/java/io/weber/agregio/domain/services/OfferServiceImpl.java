package io.weber.agregio.domain.services;

import io.weber.agregio.domain.interfaces.repositories.OfferRepository;
import io.weber.agregio.domain.interfaces.services.OfferService;
import io.weber.agregio.domain.interfaces.services.ParkService;
import io.weber.agregio.domain.model.Offer;
import io.weber.agregio.domain.model.OfferRequest;
import io.weber.agregio.domain.model.Park;

import java.util.List;

public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ParkService parkService;


    public OfferServiceImpl(OfferRepository offerRepository, ParkService parkService) {
        this.offerRepository = offerRepository;
        this.parkService = parkService;
    }

    @Override
    public Offer save(OfferRequest request) {
        var blocks = request.getParksIds().stream().map(parkService::findById).map(Park::createBlock).toList();
        var offer = new Offer(null,request.getMarket(), blocks);
        validateOffer(offer);
        var blocksSaved = request.getParksIds().stream().map(parkService::createBlock).toList();
        offer.setBlocks(blocksSaved);
        return offerRepository.save(offer);
    }

    @Override
    public List<Offer> findByMarket(Long marketId) {
        return offerRepository.findByMarket(marketId);
    }

    @Override
    public List<Offer> findAll() {
        return offerRepository.findAll();
    }

    private void validateOffer(Offer offer) {
        if (offer.getMarket() == null) {
            throw new IllegalArgumentException("Market must not be null");
        }

        if (offer.getBlocks() == null || offer.getBlocks().isEmpty()) {
            throw new IllegalArgumentException("Offer must contain at least one block");
        }
        var nbHours = offer.getBlocks().stream()
                .map(block -> block.getPark().getDuration()).reduce(0,Integer::sum);
        if(nbHours != 24){
            throw new IllegalArgumentException("The total duration of all blocks must be 24 hours");
        }
    }
}
