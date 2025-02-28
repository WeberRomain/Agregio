package io.weber.agregio.application.dto.MarketDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record MarketRequestDto(@NotBlank @NotEmpty String name) {
}
