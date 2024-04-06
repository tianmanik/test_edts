package com.test.edts.controller;

import com.test.edts.dto.ConcertDTO;
import com.test.edts.dto.RequestDTO;
import com.test.edts.service.ConcertService;
import com.test.edts.util.GenericResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@AllArgsConstructor
@RequestMapping("/concert")
public class ConcertController {

	ConcertService concertService;


	@GetMapping("/")
	private GenericResponseDTO getAllReadyConcert(@RequestBody RequestDTO param) throws ParseException {
		GenericResponseDTO responseDTO = new GenericResponseDTO();

		return responseDTO.successResponse(concertService.getAll(param));
	}
}
