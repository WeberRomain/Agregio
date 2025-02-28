package io.weber.agregio.domain.services;

import io.weber.agregio.domain.interfaces.repositories.ParkRepository;
import io.weber.agregio.domain.model.Park;
import io.weber.agregio.domain.model.ParkType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class ParkServiceImplTest {

    @Mock
    private ParkRepository parkRepository;

    @InjectMocks
    private ParkServiceImpl parkService;

    @Test
    void testSave() {
        Park park = new Park("Park1", ParkType.SOLAR, 50.0, 0.2,3);
        when(parkRepository.save(any(Park.class))).thenReturn(park);

        Park savedPark = parkService.save(park);

        assertNotNull(savedPark);
        verify(parkRepository, times(1)).save(park);
    }

    @Test
    void testGet() {
        Park park = new Park("Park1", ParkType.SOLAR, 50.0, 0.2,3);
        when(parkRepository.findById(anyLong())).thenReturn(Optional.of(park));

        Park foundPark = parkService.findById(1L);

        assertNotNull(foundPark);
        verify(parkRepository, times(1)).findById(1L);
    }

    @Test
    void testGetByMarket() {
        List<Park> parks = List.of(new Park("Park1", ParkType.SOLAR, 50.0, 0.2,3));
        when(parkRepository.findByMarketId(anyLong())).thenReturn(parks);

        List<Park> foundParks = parkService.findByMarket(1L);

        assertNotNull(foundParks);
        assertFalse(foundParks.isEmpty());
        verify(parkRepository, times(1)).findByMarketId(1L);
    }

    @Test
    void testGetParks() {
        List<Park> parks = List.of(new Park("Park1", ParkType.SOLAR, 50.0, 0.2,3));
        when(parkRepository.findAll()).thenReturn(parks);

        List<Park> foundParks = parkService.findAll();

        assertNotNull(foundParks);
        assertFalse(foundParks.isEmpty());
        verify(parkRepository, times(1)).findAll();
    }
}
