package io.weber.agregio.infra.entities;

import io.weber.agregio.domain.model.Offer;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "offers")
public class OfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "market_id")
    private MarketEntity market;

    @ManyToMany
    private List<BlockEntity> blocks;

    public OfferEntity() {
    }

    public OfferEntity(Long id, MarketEntity market, List<BlockEntity> blocks) {
        this.id = id;
        this.market = market;
        this.blocks = blocks;
    }
    public OfferEntity(Offer offer) {
        this(offer.getId(), new MarketEntity(offer.getMarket()), offer.getBlocks().stream().map(BlockEntity::new).toList());
    }

    public Long getId() {
        return id;
    }

    public MarketEntity getMarket() {
        return market;
    }

    public List<BlockEntity> getBlocks() {
        return blocks;
    }

    public Offer toModel(){
        return new Offer(market.toModel(), blocks.stream().map(BlockEntity::toModel).toList());
    }
}
