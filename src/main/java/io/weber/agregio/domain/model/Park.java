package io.weber.agregio.domain.model;

public class Park {
    private Long id;
    private String name;
    private ParkType type;
    private Double capacityInMW;
    private Double floorPrice;
    private Integer duration;

    public Park(Long id, String name, ParkType type, Double capacityInMW, Double floorPrice, Integer duration) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.capacityInMW = capacityInMW;
        this.floorPrice = floorPrice;
        this.duration = duration;
    }

    public Park(String name, ParkType type, Double capacityInMW, Double floorPrice, Integer duration){
        this(null,name,type,capacityInMW,floorPrice,duration);
    }

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }

    public ParkType getType() {
        return type;
    }

    public Double getCapacityInMW() {
        return capacityInMW;
    }

    public Double getFloorPrice() {
        return floorPrice;
    }

    public Integer getDuration() {
        return duration;
    }
    public Block createBlock() {
        return new Block(null, capacityInMW, floorPrice, this);
    }
}
