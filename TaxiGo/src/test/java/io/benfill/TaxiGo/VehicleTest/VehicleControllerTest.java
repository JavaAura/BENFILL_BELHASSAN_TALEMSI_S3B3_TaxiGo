package io.benfill.TaxiGo.VehicleTest;

import io.benfill.TaxiGo.controller.VehicleController;
import io.benfill.TaxiGo.dao.VehicleAnalyticsDto;
import io.benfill.TaxiGo.dto.request.VehicleRequestDto;
import io.benfill.TaxiGo.dto.response.VehicleResponseDto;
import io.benfill.TaxiGo.service.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class VehicleControllerTest {


    @Mock
    private VehicleService vehicleService;

    @InjectMocks
    private VehicleController vehicleController;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddVehicle() {
        VehicleRequestDto requestDto = new VehicleRequestDto();
        VehicleResponseDto responseDto = new VehicleResponseDto();

        when(vehicleService.saveVehicle(any(VehicleRequestDto.class))).thenReturn(responseDto);

        VehicleResponseDto result = vehicleController.addVehicle(requestDto);

        assertNotNull(result);
        verify(vehicleService, times(1)).saveVehicle(requestDto);

    }

    @Test
    void testUpdateVehicle() {
        VehicleRequestDto requestDto = new VehicleRequestDto();
        VehicleResponseDto responseDto = new VehicleResponseDto();

        when(vehicleService.updateVehicle(anyLong(), any(VehicleRequestDto.class))).thenReturn(responseDto);

        VehicleResponseDto result = vehicleController.updateVehicle(1L, requestDto);

        assertNotNull(result);
        verify(vehicleService, times(1)).updateVehicle(1L, requestDto);
    }

    @Test
    void testDeleteVehicle() {
        when(vehicleService.deleteVehicle(anyLong())).thenReturn("Vehicle deleted");

        vehicleController.deleteVehicle(1L);

        verify(vehicleService, times(1)).deleteVehicle(1L);
    }

    @Test
    void testGetVehicleAnalytics() {
        VehicleAnalyticsDto analyticsDto = new VehicleAnalyticsDto();

        when(vehicleService.getAnalytics()).thenReturn(analyticsDto);

        VehicleAnalyticsDto result = vehicleController.getVehicleAnalytics();

        assertNotNull(result);
        verify(vehicleService, times(1)).getAnalytics();
    }

    @Test
    void testGetAllVehicles() {
        List<VehicleResponseDto> vehicles = Collections.emptyList();

        when(vehicleService.getAllVehicles()).thenReturn(vehicles);

        List<VehicleResponseDto> result = vehicleController.getAllVehicles();

        assertNotNull(result);
        assertEquals(0, result.size());
        verify(vehicleService, times(1)).getAllVehicles();
    }

    @Test
    void testGetVehicleById() {
        VehicleResponseDto responseDto = new VehicleResponseDto();

        when(vehicleService.getVehicleById(anyLong())).thenReturn(responseDto);

        VehicleResponseDto result = vehicleController.getVehicleById(1L);

        assertNotNull(result);
        verify(vehicleService, times(1)).getVehicleById(1L);
    }

    @Test
    void testGetVehicleById_NotFound() {
        when(vehicleService.getVehicleById(anyLong())).thenThrow(new NoSuchElementException("Vehicle not found"));

        assertThrows(NoSuchElementException.class, () -> vehicleController.getVehicleById(1L));
        verify(vehicleService, times(1)).getVehicleById(1L);
    }

}