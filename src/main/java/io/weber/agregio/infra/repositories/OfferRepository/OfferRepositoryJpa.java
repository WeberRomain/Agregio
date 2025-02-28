package io.weber.agregio.infra.repositories.OfferRepository;

import io.weber.agregio.infra.entities.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepositoryJpa extends JpaRepository<OfferEntity, Long> {
    List<OfferEntity> findByMarketId(Long marketId);
}
