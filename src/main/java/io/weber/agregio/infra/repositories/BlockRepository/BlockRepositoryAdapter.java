package io.weber.agregio.infra.repositories.BlockRepository;

import io.weber.agregio.domain.interfaces.repositories.BlockRepository;
import io.weber.agregio.domain.model.Block;
import io.weber.agregio.infra.entities.BlockEntity;
import org.springframework.stereotype.Component;

@Component
public class BlockRepositoryAdapter implements BlockRepository {
    private final BlockRepositoryJpa blockRepositoryJpa;

    public BlockRepositoryAdapter(BlockRepositoryJpa blockRepositoryJpa) {
        this.blockRepositoryJpa = blockRepositoryJpa;
    }

    @Override
    public Block save(Block block) {
        return blockRepositoryJpa.save(new BlockEntity(block)).toModel();
    }
}
