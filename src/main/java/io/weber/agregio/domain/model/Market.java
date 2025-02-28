package io.weber.agregio.domain.model;

public class Market {
    private Long id;
    private String name;

    public Market(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }
}
