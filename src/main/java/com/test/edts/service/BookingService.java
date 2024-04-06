package com.test.edts.service;

import com.test.edts.dto.RequestDTO;
import com.test.edts.model.Booking;
import com.test.edts.model.Concert;
import com.test.edts.repository.BookingRepository;
import com.test.edts.repository.ConcertRepository;
import com.test.edts.util.GeneralUtil;
import com.test.edts.util.GenericResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@AllArgsConstructor
@Service
public class BookingService {


	private final BookingRepository bookingRepository;
	private final ConcertRepository concertRepository;


	@Transactional(isolation = Isolation.SERIALIZABLE)
	public GenericResponseDTO bookingConcert(RequestDTO param) {

		GenericResponseDTO responseDTO = new GenericResponseDTO();

		Optional <Concert> concert = concertRepository.findById(param.getConcertId());

		if(concert.isEmpty()){
			return responseDTO.errorResponse(400,"concert not found");
		}

		if(concert.get().getStartDateLimit()!=null && concert.get().getEndtDateLimit()!=null){

			int comparisonFromStart = concert.get().getStartDateLimit().compareTo(GeneralUtil.now());
			int comparisonFromEnd = concert.get().getEndtDateLimit().compareTo(GeneralUtil.now());

			if (comparisonFromStart<0  && comparisonFromEnd>0) {

				// mengecek pemesanan sesuai dari limit pemesanan yang ditentukan di jam tertentu
				long totalTicketsBookedDuringSlot = bookingRepository.countByBookingTimeBetween(concert.get().getStartDateLimit(), concert.get().getEndtDateLimit());
				long availableTicketsDuringSlot = concert.get().getTicketLimitPurchase() - totalTicketsBookedDuringSlot;
				if( availableTicketsDuringSlot <= 0){
					return responseDTO.errorResponse(400,"Purchase at the specified time have exceeded the limit ");
				}
			}
		}


		long concertDateValidation = concert.get().getConcertDate().compareTo(GeneralUtil.now());
		if(concertDateValidation<0){
			return responseDTO.errorResponse(400,"concert date has expired");
		}


		if(concert.get().getAvailableTickets()<=0){
			return responseDTO.errorResponse(400,"limit has expired");
		}



		// Perform booking
		concert.get().setAvailableTickets(concert.get().getAvailableTickets() - 1);
		concertRepository.save(concert.get());

		Booking booking = new Booking();
		booking.setConcertId(concert.get().getConcertId());
		booking.setBookingTime(GeneralUtil.now());


		if(param.getUserId()!=null && !param.getUserId().isEmpty()){
			booking.setUserCode(param.getUserId());
		}else {
			booking.setUserCode("testUser");
		}

		bookingRepository.save(booking);

		return responseDTO.successResponse();
	}
}

