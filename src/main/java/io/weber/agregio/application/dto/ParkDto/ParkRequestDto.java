package io.weber.agregio.application.dto.ParkDto;

import io.weber.agregio.domain.model.Park;
import io.weber.agregio.domain.model.ParkType;

public record ParkRequestDto(String name, ParkType type, Double capacityInMW, Double floorPrice, Integer duration) {
    public Park toModel(){
        return new Park(name, type, capacityInMW, floorPrice, duration);
    }
}
