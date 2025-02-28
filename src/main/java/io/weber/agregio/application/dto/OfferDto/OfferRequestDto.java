package io.weber.agregio.application.dto.OfferDto;

import io.weber.agregio.domain.model.Market;
import io.weber.agregio.domain.model.OfferRequest;

import java.util.List;

public record OfferRequestDto(Long marketId, List<Long> parksIds) {
    public OfferRequest toModel(){
        return new OfferRequest(new Market(marketId, null),parksIds);
    }
}
