package io.weber.agregio.application.dto.ParkDto;

import io.weber.agregio.domain.model.Park;
import io.weber.agregio.domain.model.ParkType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ParkRequestDto(@NotBlank @NotEmpty String name, @NotNull ParkType type, @NotNull Double capacityInMW, @NotNull Double floorPrice, @NotNull Integer duration) {
    public Park toModel(){
        return new Park(name, type, capacityInMW, floorPrice, duration);
    }
}
