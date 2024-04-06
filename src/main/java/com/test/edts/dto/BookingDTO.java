package com.test.edts.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDTO {
    private Long bookingId;
    private Long concertId;
    private String userCode;
    private java.sql.Date bookingTime;
}
