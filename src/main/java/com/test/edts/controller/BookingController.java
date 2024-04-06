package com.test.edts.controller;


import com.test.edts.dto.RequestDTO;
import com.test.edts.service.BookingService;
import com.test.edts.util.GenericResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookingController {

	BookingService bookingService;


	@PostMapping("/")
	private GenericResponseDTO getAllReadyConcert(@RequestBody RequestDTO param) {
		return bookingService.bookingConcert(param);
	}
}
