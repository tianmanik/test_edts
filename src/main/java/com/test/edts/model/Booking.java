package com.test.edts.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID")
    @SequenceGenerator(name = "ID", sequenceName = "booking_seq", allocationSize=1)
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "concert_id")
    private Long concertId;

    @Column(name = "user_code")
    private String userCode;

    @Column(name = "booking_time")
    private java.sql.Timestamp bookingTime;

}
