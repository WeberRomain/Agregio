package io.weber.agregio.application.dto.ParkDto;

import io.weber.agregio.domain.model.Park;

public record ParkDto(Long id, String name, String type, Double capacityInMW, Double floorPrice, Integer duration) {
    public ParkDto(Park park){
        this(park.getId(), park.getName(), park.getType().name(), park.getCapacityInMW(), park.getFloorPrice(), park.getDuration());
    }
}
