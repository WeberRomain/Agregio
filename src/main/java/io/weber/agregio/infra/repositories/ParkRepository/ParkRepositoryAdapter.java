package io.weber.agregio.infra.repositories.ParkRepository;

import io.weber.agregio.domain.interfaces.repositories.ParkRepository;
import io.weber.agregio.domain.model.Park;
import io.weber.agregio.infra.entities.ParkEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ParkRepositoryAdapter implements ParkRepository {

    private final ParkRepositoryJpa parkRepositoryJpa;

    public ParkRepositoryAdapter(ParkRepositoryJpa parkRepositoryJpa) {
        this.parkRepositoryJpa = parkRepositoryJpa;
    }

    @Override
    public Optional<Park> findById(Long id) {
        return parkRepositoryJpa.findById(id).map(ParkEntity::toModel);
    }

    @Override
    public Park save(Park park) {
        return parkRepositoryJpa.save(new ParkEntity(park)).toModel();
    }

    @Override
    public List<Park> findAll() {
        return parkRepositoryJpa.findAll()
                .stream().map(ParkEntity::toModel).collect(Collectors.toList());
    }

    @Override
    public List<Park> findByMarketId(Long id) {
        return parkRepositoryJpa.findByMarketId(id)
                .stream().map(ParkEntity::toModel).collect(Collectors.toList());
    }
}
