package io.weber.agregio.application.dto.BlockDto;

import io.weber.agregio.domain.model.Block;

public record BlockDto(Long id, Double energyInMW, Double floorPrice, Long parkId) {
    public BlockDto(Block block) {
        this(block.getId(), block.getEnergyInMW(), block.getFloorPrice(), block.getPark().getId());
    }
}
