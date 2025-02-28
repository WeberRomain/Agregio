package io.weber.agregio.infra.repositories.ParkRepository;

import io.weber.agregio.infra.entities.ParkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkRepositoryJpa extends JpaRepository<ParkEntity, Long> {
    List<ParkEntity> findByMarketId(Long marketId);
}
