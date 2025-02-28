package io.weber.agregio.infra.repositories.MarketRepository;

import io.weber.agregio.infra.entities.MarketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepositoryJpa extends JpaRepository<MarketEntity, Long> {
}
