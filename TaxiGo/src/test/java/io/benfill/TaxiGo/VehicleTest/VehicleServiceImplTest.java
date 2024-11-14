package io.benfill.TaxiGo.VehicleTest;

import io.benfill.TaxiGo.dto.request.VehicleRequestDto;
import io.benfill.TaxiGo.dto.response.VehicleResponseDto;
import io.benfill.TaxiGo.mapper.VehicleMapper;
import io.benfill.TaxiGo.model.Vehicle;
import io.benfill.TaxiGo.repository.VehicleRepository;
import io.benfill.TaxiGo.service.impl.VehicleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


public class VehicleServiceImplTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private VehicleMapper vehicleMapper;

    @InjectMocks
    private VehicleServiceImpl vehicleServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveVehicle() {
        Vehicle vehicle = new Vehicle();
        VehicleRequestDto requestDto = new VehicleRequestDto();
        VehicleResponseDto responseDto = new VehicleResponseDto();

        when(vehicleMapper.toEntity(any(VehicleRequestDto.class))).thenReturn(vehicle);
        when(vehicleRepository.save(any(Vehicle.class))).thenReturn(vehicle);
        when(vehicleMapper.toDTO(any(Vehicle.class))).thenReturn(responseDto);

        VehicleResponseDto result = vehicleServiceImpl.saveVehicle(requestDto);

        assertNotNull(result);
        verify(vehicleRepository, times(1)).save(vehicle);
    }

    @Test
    void testUpdateVehicle() {
        Vehicle vehicle = new Vehicle();
        VehicleRequestDto requestDto = new VehicleRequestDto();
        VehicleResponseDto responseDto = new VehicleResponseDto();

        when(vehicleRepository.findById(anyLong())).thenReturn(Optional.of(vehicle));
        when(vehicleRepository.save(any(Vehicle.class))).thenReturn(vehicle);
        when(vehicleMapper.toDTO(any(Vehicle.class))).thenReturn(responseDto);

        VehicleResponseDto result = vehicleServiceImpl.updateVehicle(1L, requestDto);

        assertNotNull(result);
        verify(vehicleRepository, times(1)).save(vehicle);
    }

    @Test
    void testDeleteVehicle() {
        Vehicle vehicle = new Vehicle();

        when(vehicleRepository.findById(anyLong())).thenReturn(Optional.of(vehicle));
        doNothing().when(vehicleRepository).delete(vehicle);

        String result = vehicleServiceImpl.deleteVehicle(1L);

        assertEquals("Vehicle deleted", result);
        verify(vehicleRepository, times(1)).delete(vehicle);
    }

    @Test
    void testGetVehicleById_NotFound() {
        when(vehicleRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> vehicleServiceImpl.getVehicleById(1L));
        verify(vehicleRepository, times(1)).findById(1L);
    }
}
