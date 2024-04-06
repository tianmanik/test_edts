package com.test.edts.repository;

import com.test.edts.model.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ConcertRepository extends JpaRepository<Concert,Long> {

	List<Concert> findByConcertDateAfterAndAvailableTicketsGreaterThanEqual(java.sql.Timestamp concertDate, Long availableTickets);

}
