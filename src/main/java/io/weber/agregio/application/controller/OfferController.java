package io.weber.agregio.application.controller;

import io.weber.agregio.application.dto.OfferDto.OfferDto;
import io.weber.agregio.application.dto.OfferDto.OfferRequestDto;
import io.weber.agregio.domain.interfaces.services.OfferService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OfferDto createOffer(@RequestBody OfferRequestDto request) {
        var offer = offerService.save(request.toModel());
        return new OfferDto(offer);
    }

    @GetMapping("/market")
    @ResponseStatus(HttpStatus.OK)
    public List<OfferDto> findByMarket(@RequestParam Long marketId) {
        return offerService.findByMarket(marketId).stream().map(OfferDto::new).toList();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OfferDto> findAll() {
        return offerService.findAll().stream().map(OfferDto::new).toList();
    }
}
