package com.test.edts.service;


import com.test.edts.dto.ConcertDTO;
import com.test.edts.dto.RequestDTO;
import com.test.edts.model.Concert;
import com.test.edts.repository.ConcertRepository;
import com.test.edts.util.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

@Service
public class ConcertService {

	@Autowired
	ConcertRepository concertRepository;

	public List<Concert> getAll (RequestDTO param) throws ParseException {
		if(param.getConcertDate()!=null && !param.getConcertDate().isEmpty()){
			return concertRepository.findByConcertDateAfterAndAvailableTicketsGreaterThanEqual(GeneralUtil.stringToTimestamp( param.getConcertDate()),1L);
		}else {
			return concertRepository.findByConcertDateAfterAndAvailableTicketsGreaterThanEqual(GeneralUtil.now(),1L);

		}
	}

	public Concert save (ConcertDTO param ) throws ParseException {

		return concertRepository.save(param.toBean());
	}


}
