package io.weber.agregio.domain.model;

public class Block {
    private Long id;
    private Double floorPrice;
    private Double energyInMW;
    private Park park;

    public Block(Long id, Double energyInMW, Double floorPrice, Park park) {
        this.id = id;
        this.energyInMW = energyInMW;
        this.floorPrice = floorPrice;
        this.park = park;
    }
    public Block(Double energyInMW, Double floorPrice, Park park) {
        this(null,energyInMW,floorPrice,park);
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

    public Park getPark() {
        return park;
    }
}
