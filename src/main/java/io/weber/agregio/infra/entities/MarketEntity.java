package io.weber.agregio.infra.entities;

import io.weber.agregio.domain.model.Market;
import jakarta.persistence.*;

@Entity
@Table(name = "markets")
public class MarketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public MarketEntity() {
    }

    public MarketEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public MarketEntity(String name) {
        this(null,name);
    }
    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }

    public Market toModel(){
        return new Market(id, name);
    }
}
