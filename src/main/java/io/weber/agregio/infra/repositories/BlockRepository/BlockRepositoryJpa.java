package io.weber.agregio.infra.repositories.BlockRepository;

import io.weber.agregio.infra.entities.BlockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepositoryJpa extends JpaRepository<BlockEntity, Long> {
}
