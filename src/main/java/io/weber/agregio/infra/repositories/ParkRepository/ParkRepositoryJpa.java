package io.weber.agregio.infra.repositories.ParkRepository;

import io.weber.agregio.infra.entities.ParkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkRepositoryJpa extends JpaRepository<ParkEntity, Long> {
    @Query("SELECT p FROM ParkEntity p " +
            "JOIN BlockEntity b ON p.id = b.park.id " +
            "JOIN OfferEntity o ON b MEMBER OF o.blocks " +
            "WHERE o.market.id = :marketId")
    List<ParkEntity> findByMarketId(Long marketId);
}
