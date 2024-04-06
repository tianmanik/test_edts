package com.test.edts.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConcertDTO {
    private Long concertId;
    private String concertName;
    private java.sql.Timestamp concertDate;
    private Long availableTickets;
}
