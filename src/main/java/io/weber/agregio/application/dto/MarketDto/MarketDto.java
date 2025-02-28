package io.weber.agregio.application.dto.MarketDto;

import io.weber.agregio.domain.model.Market;

public record MarketDto(Long id, String name) {
    public MarketDto(Market market) {
        this(market.getId(), market.getName());
    }
}
