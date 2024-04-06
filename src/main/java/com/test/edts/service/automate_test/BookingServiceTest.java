package com.test.edts.service.automate_test;

import com.test.edts.dto.RequestDTO;
import com.test.edts.model.Concert;
import com.test.edts.repository.BookingRepository;
import com.test.edts.repository.ConcertRepository;
import com.test.edts.service.BookingService;
import com.test.edts.util.GenericResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BookingServiceTest {

	@Mock
	private BookingRepository bookingRepository;

	@Mock
	private ConcertRepository concertRepository;

	private BookingService bookingService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		bookingService = new BookingService(bookingRepository, concertRepository);
	}

	@Test
	public void testBookingConcert() {
		RequestDTO requestDTO = new RequestDTO();
		requestDTO.setConcertId(1L);

		Concert concert = new Concert();
		concert.setConcertId(1L);
		concert.setAvailableTickets(100L);
		concert.setTicketLimitPurchase(10L);
		concert.setStartDateLimit(new Timestamp(System.currentTimeMillis() - 3600 * 1000)); // 1 hour ago
		concert.setEndtDateLimit(new Timestamp(System.currentTimeMillis() + 3600 * 1000)); // 1 hour later

		when(concertRepository.findById(1L)).thenReturn(Optional.of(concert));
		when(bookingRepository.countByBookingTimeBetween(concert.getStartDateLimit(), concert.getEndtDateLimit())).thenReturn(2L);

		GenericResponseDTO responseDTO = bookingService.bookingConcert(requestDTO);

		if (responseDTO.getCode() != 400) {
			verify(concertRepository, times(1)).save(any());
			verify(bookingRepository, times(1)).save(any());
		}

		assertEquals(201, responseDTO.getCode());
	}
}

