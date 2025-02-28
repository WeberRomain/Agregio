package io.weber.agregio.infra.entities;

import io.weber.agregio.domain.model.Block;
import jakarta.persistence.*;

@Entity
@Table(name = "blocks")
public class BlockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double energyInMW;
    private Double floorPrice;
    @ManyToOne
    @JoinColumn(name = "park_id")
    private ParkEntity park;

    public BlockEntity() {
    }
    public BlockEntity(Long id, Double energyInMW, Double floorPrice, ParkEntity park) {
        this.id = id;
        this.energyInMW = energyInMW;
        this.floorPrice = floorPrice;
        this.park = park;
    }

    public BlockEntity(Block block) {
        this(block.getId(), block.getEnergyInMW(), block.getFloorPrice(), new ParkEntity(block.getPark()));
    }

    public Long getId() {
        return id;
    }

    public Double getEnergyInMW() {
        return energyInMW;
    }

    public Double getFloorPrice() {
        return floorPrice;
    }

    public ParkEntity getPark() {
        return park;
    }

    public Block toModel(){
        return new Block(id, energyInMW, floorPrice, park.toModel());
    }
}
