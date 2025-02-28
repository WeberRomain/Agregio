package io.weber.agregio.infra.entities;

import io.weber.agregio.domain.model.Park;
import io.weber.agregio.domain.model.ParkType;
import jakarta.persistence.*;

@Entity
@Table(name = "parks")
public class ParkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private ParkType type;
    private Double capacityInMW;
    private Double floorPrice;
    private Integer duration;

    public ParkEntity(){

    }
    public ParkEntity(Long id, String name, ParkType type, Double capacityInMW, Double floorPrice, Integer duration) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.capacityInMW = capacityInMW;
        this.floorPrice = floorPrice;
        this.duration = duration;
    }

    public ParkEntity(Park park) {
        this(null, park.getName(), park.getType(), park.getCapacityInMW(), park.getFloorPrice(), park.getDuration());
    }

    public Park toModel(){
        return new Park(id, name, type, capacityInMW, floorPrice, duration);
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
}
