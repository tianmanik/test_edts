package com.test.edts.controller;

import com.test.edts.dto.ConcertDTO;
import com.test.edts.dto.RequestDTO;
import com.test.edts.service.ConcertService;
import com.test.edts.util.GenericResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@AllArgsConstructor
@RequestMapping("/concert")
public class ConcertController {

	ConcertService concertService;


	@PostMapping("/")
	private GenericResponseDTO getAllReadyConcert(@RequestBody RequestDTO param) throws ParseException {
		GenericResponseDTO responseDTO = new GenericResponseDTO();

		return responseDTO.successResponse(concertService.getAll(param));
	}
}
