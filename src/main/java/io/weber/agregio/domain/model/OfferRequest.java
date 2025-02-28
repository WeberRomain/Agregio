package io.weber.agregio.domain.model;

import java.util.List;

public class OfferRequest {
    private Market market;
    private List<Long> parksIds;

    public OfferRequest(Market market, List<Long> parksIds) {
        this.market = market;
        this.parksIds = parksIds;
    }

    public List<Long> getParksIds() {
        return parksIds;
    }

    public Market getMarket() {
        return market;
    }
}
