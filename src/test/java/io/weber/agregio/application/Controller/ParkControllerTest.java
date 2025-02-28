package io.weber.agregio.application.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.weber.agregio.application.controller.ParkController;
import io.weber.agregio.application.dto.ParkDto.ParkDto;
import io.weber.agregio.domain.interfaces.services.ParkService;
import io.weber.agregio.domain.model.Park;
import io.weber.agregio.domain.model.ParkType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ParkController.class)
@DisplayName("Park REST Controller")
class ParkControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;
    @MockitoBean
    private ParkService parkService;

    @Test
    void shouldCreatePark() throws Exception {
        var park = new Park(1L,"Park1", ParkType.SOLAR, 50.0, 0.2,3);
        var parkDto = new ParkDto(park);
        when(parkService.save(any(Park.class))).thenReturn(park);

        mockMvc.perform(post("/parks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(park)))
                .andExpect(status().isCreated())
                .andExpect(content().json(mapper.writeValueAsString(parkDto)));

        verify(parkService, times(1)).save(any(Park.class));
    }

    @Test
    void shouldGetAllParks() throws Exception {
        var park = new Park(1L,"Park1", ParkType.SOLAR, 50.0, 0.2,3);
        var parkDto = new ParkDto(park);
        List<ParkDto> response = List.of(parkDto);

        when(parkService.findAll()).thenReturn(List.of(park));

        mockMvc.perform(get("/parks"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(response)));

        verify(parkService, times(1)).findAll();
    }

    @Test
    void shouldGetByMarket() throws Exception {
        var park = new Park(1L,"Park1", ParkType.SOLAR, 50.0, 0.2,3);
        var parkDto = new ParkDto(park);
        List<ParkDto> response = List.of(parkDto);

        when(parkService.findByMarket(anyLong())).thenReturn(List.of(park));

        mockMvc.perform(get("/parks/market?marketId=1"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(response)));

        verify(parkService, times(1)).findByMarket(1L);
    }
}
