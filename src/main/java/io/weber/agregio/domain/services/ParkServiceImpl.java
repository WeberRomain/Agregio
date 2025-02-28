package io.weber.agregio.domain.services;

import io.weber.agregio.domain.interfaces.repositories.ParkRepository;
import io.weber.agregio.domain.interfaces.services.ParkService;
import io.weber.agregio.domain.model.Park;

import java.util.List;

public class ParkServiceImpl implements ParkService {

    private final ParkRepository parkRepository;

    public ParkServiceImpl(ParkRepository parkRepository) {
        this.parkRepository = parkRepository;
    }


    @Override
    public Park findById(Long id) {
        return parkRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Park id not exist : "  + id));
    }

    @Override
    public Park save(Park park) {
        validatePark(park);
        return parkRepository.save(park);
    }

    @Override
    public List<Park> findByMarket(Long marketId) {
        return parkRepository.findByMarketId(marketId);
    }

    @Override
    public List<Park> findAll() {
        return parkRepository.findAll();
    }

    private void validatePark(Park park) {
        if (park.getName() == null || park.getName().isEmpty()) {
            throw new IllegalArgumentException("Park name must not be null or empty");
        }

        if (park.getType() == null) {
            throw new IllegalArgumentException("Park type must not be null");
        }

        if (park.getCapacityInMW() == null || park.getCapacityInMW() <= 0) {
            throw new IllegalArgumentException("Park capacity must be greater than zero");
        }

        if (park.getFloorPrice() == null || park.getFloorPrice() < 0) {
            throw new IllegalArgumentException("Park floor price must not be negative");
        }

        if (park.getDuration() == null || park.getDuration() <= 0 || park.getDuration() > 24) {
            throw new IllegalArgumentException("Park duration must be between 0 and 24");
        }
    }
}
