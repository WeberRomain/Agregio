package io.weber.agregio.domain.model;

import java.util.List;

public class Offer {
    private Long id;
    private Market market;
    private List<Block> blocks;

    public Offer(Long id, Market market, List<Block> blocks) {
        this.id = id;
        this.market = market;
        this.blocks = blocks;
    }

    public Offer(Market market, List<Block> blocks) {
        this(null, market, blocks);
    }

    public Long getId() {
        return id;
    }

    public Market getMarket() {
        return market;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}
