package io.weber.agregio.application.dto.OfferDto;

import io.weber.agregio.domain.model.Market;
import io.weber.agregio.domain.model.OfferRequest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OfferRequestDto(@NotNull Long marketId, @NotNull @NotEmpty List<Long> parksIds) {
    public OfferRequest toModel(){
        return new OfferRequest(new Market(marketId, null),parksIds);
    }
}
