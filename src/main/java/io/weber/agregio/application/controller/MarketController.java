package io.weber.agregio.application.controller;

import io.weber.agregio.application.dto.MarketDto.MarketDto;
import io.weber.agregio.application.dto.MarketDto.MarketRequestDto;
import io.weber.agregio.domain.interfaces.services.MarketService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/markets")
public class MarketController {

    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MarketDto createMarket(@RequestBody MarketRequestDto request) {
        var market = marketService.save(request.name());
        return new MarketDto(market);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MarketDto> getMarkets() {
        return marketService.findAll().stream().map(MarketDto::new).toList();
    }
}
