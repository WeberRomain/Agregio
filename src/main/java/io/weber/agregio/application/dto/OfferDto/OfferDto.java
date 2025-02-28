package io.weber.agregio.application.dto.OfferDto;

import io.weber.agregio.application.dto.BlockDto.BlockDto;
import io.weber.agregio.application.dto.MarketDto.MarketDto;
import io.weber.agregio.domain.model.Offer;

import java.util.List;

public record OfferDto(Long id, MarketDto market, List<BlockDto> blocks) {
    public OfferDto(Offer offer){
        this(offer.getId(), new MarketDto(offer.getMarket()),offer.getBlocks().stream().map(BlockDto::new).toList());
    }
}
