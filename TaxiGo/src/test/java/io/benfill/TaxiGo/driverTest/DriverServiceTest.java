package io.benfill.TaxiGo.driverTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import io.benfill.TaxiGo.dao.IDriverDao;
import io.benfill.TaxiGo.dto.driver.DriverDtoAvailability;
import io.benfill.TaxiGo.dto.driver.DriverDtoGet;
import io.benfill.TaxiGo.dto.driver.DriverDtoPost;
import io.benfill.TaxiGo.exception.ModelNotFoundException;
import io.benfill.TaxiGo.mapper.DriverMappper;
import io.benfill.TaxiGo.model.Driver;
import io.benfill.TaxiGo.model.Reservation;
import io.benfill.TaxiGo.model.enums.ReservationStatus;
import io.benfill.TaxiGo.model.enums.Status;
import io.benfill.TaxiGo.repository.DriverRepository;
import io.benfill.TaxiGo.repository.ReservationRepository;
import io.benfill.TaxiGo.service.impl.DriverServiceImpl;

class DriverServiceTest {

	@InjectMocks
	private DriverServiceImpl driverService;

	@Mock
	private DriverRepository driverRepository;

	@Mock
	private IDriverDao driverDao;

	@Mock
	private ReservationRepository reservationRepository;

	@Mock
	private DriverMappper driverMapper;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetDriverById_Success() {
		Long driverId = 1L;
		Driver driver = new Driver();
		driver.setId(driverId);

		when(driverRepository.findById(driverId)).thenReturn(Optional.of(driver));

		Optional<Driver> result = driverService.getDriverById(driverId);

		assertTrue(result.isPresent());
		assertEquals(driverId, result.get().getId());
		verify(driverRepository, times(1)).findById(driverId);
	}

	@Test
	void testGetDriverDetails_Success() {
		Long driverId = 1L;
		Driver driver = new Driver();
		driver.setId(driverId);
		DriverDtoGet driverDto = new DriverDtoGet();

		when(driverRepository.findById(driverId)).thenReturn(Optional.of(driver));
		when(driverMapper.convertEntityToDto(driver)).thenReturn(driverDto);

		DriverDtoGet result = driverService.getDriverDetails(driverId);

		assertNotNull(result);
		verify(driverRepository, times(1)).findById(driverId);
		verify(driverMapper, times(1)).convertEntityToDto(driver);
	}

	@Test
	void testGetDriverDetails_NotFound() {
		Long driverId = 1L;

		when(driverRepository.findById(driverId)).thenReturn(Optional.empty());

		assertThrows(ModelNotFoundException.class, () -> driverService.getDriverDetails(driverId));
		verify(driverRepository, times(1)).findById(driverId);
	}

	@Test
	void testGetAllDrivers() {
		int page = 0;
		int size = 3;
		PageRequest pageable = PageRequest.of(page, size);
		Driver driver = new Driver();
		DriverDtoGet driverDto = new DriverDtoGet();
		List<Driver> drivers = Arrays.asList(driver);
		Page<Driver> driverPage = new PageImpl<>(drivers);

		when(driverRepository.findAll(pageable)).thenReturn(driverPage);
		when(driverMapper.convertEntityToDto(driver)).thenReturn(driverDto);

		List<DriverDtoGet> result = driverService.getAllDrivers(page);

		assertNotNull(result);
		assertEquals(1, result.size());
		verify(driverRepository, times(1)).findAll(pageable);
		verify(driverMapper, times(1)).convertEntityToDto(driver);
	}

	@Test
	void testCreateDriver() {
		DriverDtoPost driverDtoPost = new DriverDtoPost();
		Driver driver = new Driver();
		DriverDtoGet driverDtoGet = new DriverDtoGet();

		when(driverMapper.convertDtoToEntity(driverDtoPost)).thenReturn(driver);
		when(driverRepository.save(driver)).thenReturn(driver);
		when(driverMapper.convertEntityToDto(driver)).thenReturn(driverDtoGet);

		DriverDtoGet result = driverService.createDriver(driverDtoPost);

		assertNotNull(result);
		verify(driverRepository, times(1)).save(driver);
		verify(driverMapper, times(1)).convertEntityToDto(driver);
	}

	@Test
	void testUpdateDriver_Success() {
		long driverId = 1L;
		DriverDtoPost driverDto = new DriverDtoPost();
		driverDto.setStatus(Status.AVAILABLE);
		Driver driver = new Driver();

		when(driverRepository.findById(driverId)).thenReturn(Optional.of(driver));
		when(driverMapper.convertDtoToEntity(driverDto)).thenReturn(driver);
		when(driverRepository.save(driver)).thenReturn(driver);
		when(driverMapper.convertEntityToDto(driver)).thenReturn(new DriverDtoGet());

		DriverDtoGet result = driverService.updateDriver(driverDto, driverId);

		assertNotNull(result);
		verify(driverRepository, times(1)).findById(driverId);
		verify(driverRepository, times(1)).save(driver);
	}

	@Test
	void testDeleteDriver_Success() {
		Long driverId = 1L;
		Driver driver = new Driver();
		Reservation reservation = new Reservation();
		reservation.setStatus(ReservationStatus.COMPLETED);
		List<Reservation> reservations = Arrays.asList(reservation);

		when(driverRepository.findById(driverId)).thenReturn(Optional.of(driver));
		when(reservationRepository.findReservationsByDriverId(driverId)).thenReturn(reservations);

		driverService.deleteDriver(driverId);

		verify(driverRepository, times(1)).delete(driver);
		verify(reservationRepository, times(1)).deleteAll(reservations);
	}

	@Test
	void testCheckDriverAvailability() {
		Long driverId = 1L;
		Driver driver = new Driver();
		driver.setAvailabilityEnd(LocalDateTime.now().minusDays(1));

		when(driverRepository.findById(driverId)).thenReturn(Optional.of(driver));

		DriverDtoAvailability result = driverService.CheckDriverAvailability(driverId);

		assertTrue(result.getIsAvailable());
		assertEquals("Driver is Available", result.getMessage());
		verify(driverRepository, times(1)).findById(driverId);
	}
}
