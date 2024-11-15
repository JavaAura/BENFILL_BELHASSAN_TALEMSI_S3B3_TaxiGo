package io.benfill.TaxiGo.driverTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.benfill.TaxiGo.controller.DriverController;
import io.benfill.TaxiGo.dto.driver.DriverDtoAnalytics;
import io.benfill.TaxiGo.dto.driver.DriverDtoAvailability;
import io.benfill.TaxiGo.dto.driver.DriverDtoGet;
import io.benfill.TaxiGo.dto.driver.DriverDtoPost;
import io.benfill.TaxiGo.service.impl.DriverServiceImpl;

@WebMvcTest(DriverController.class)
class DriverControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DriverServiceImpl driverService;

	@Autowired
	private ObjectMapper objectMapper;

	private DriverDtoGet driverDtoGet;
	private DriverDtoPost driverDtoPost;
	private DriverDtoAvailability driverDtoAvailability;

	@BeforeEach
	void setUp() {
		// Initialize test data
		driverDtoGet = new DriverDtoGet();
		// Set necessary fields for driverDtoGet

		driverDtoPost = new DriverDtoPost();
		// Set necessary fields for driverDtoPost

		driverDtoAvailability = new DriverDtoAvailability();
		// Set necessary fields for driverDtoAvailability
	}

	@Test
	void index_ShouldReturnListOfDrivers() throws Exception {
		List<DriverDtoGet> drivers = Arrays.asList(driverDtoGet);
		when(driverService.getAllDrivers(anyInt())).thenReturn(drivers);

		mockMvc.perform(get("/api/drivers").param("page", "0")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.length()").value(1));
	}

	@Test
	void show_WithValidId_ShouldReturnDriver() throws Exception {
		when(driverService.getDriverDetails(anyLong())).thenReturn(driverDtoGet);

		mockMvc.perform(get("/api/drivers/1")).andExpect(status().isFound())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void show_WithInvalidId_ShouldReturnBadRequest() throws Exception {
		mockMvc.perform(get("/api/drivers/-1")).andExpect(status().isBadRequest())
				.andExpect(content().string("Invalid ID"));
	}

	@Test
	void store_WithValidData_ShouldCreateDriver() throws Exception {
		when(driverService.createDriver(any(DriverDtoPost.class))).thenReturn(driverDtoGet);

		mockMvc.perform(post("/api/drivers").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(driverDtoPost))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void update_WithValidData_ShouldUpdateDriver() throws Exception {
		when(driverService.updateDriver(any(DriverDtoPost.class), anyLong())).thenReturn(driverDtoGet);

		mockMvc.perform(put("/api/drivers/1").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(driverDtoPost))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void delete_WithValidId_ShouldDeleteDriver() throws Exception {
		doNothing().when(driverService).deleteDriver(anyLong());

		mockMvc.perform(delete("/api/drivers/1")).andExpect(status().isOk())
				.andExpect(content().string("Driver Deleted successfully"));
	}

	@Test
	void getDriverAvailability_ShouldReturnAvailability() throws Exception {
		when(driverService.CheckDriverAvailability(anyLong())).thenReturn(driverDtoAvailability);

		mockMvc.perform(get("/api/drivers/availability/1")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void getDriverAnalytics_ShouldReturnAnalytics() throws Exception {
		ResponseEntity<DriverDtoAnalytics> mockResponse = ResponseEntity.ok().build();
		when(driverService.getAnalytics()).thenReturn(mockResponse);

		mockMvc.perform(get("/api/drivers/analytics")).andExpect(status().isOk());
	}

}