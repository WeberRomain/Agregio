package io.weber.agregio.application.controller;

import io.weber.agregio.application.dto.ParkDto.ParkDto;
import io.weber.agregio.application.dto.ParkDto.ParkRequestDto;
import io.weber.agregio.domain.interfaces.services.ParkService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parks")
public class ParkController {

    private final ParkService parkService;

    public ParkController(ParkService parkService) {
        this.parkService = parkService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParkDto createPark(@RequestBody @Valid ParkRequestDto parkRequest) {
        var park = parkService.save(parkRequest.toModel());
        return new ParkDto(park);
    }

    @GetMapping("/market")
    @ResponseStatus(HttpStatus.OK)
    public List<ParkDto> getParksByMarket(@RequestParam Long marketId) {
        var list = parkService.findByMarket(marketId);
        return list.stream().map(ParkDto::new).toList();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ParkDto> getParks() {
        var list = parkService.findAll();
        return list.stream().map(ParkDto::new).toList();
    }
}
