package com.test.edts.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "concert")
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID")
    @SequenceGenerator(name = "ID", sequenceName = "concert_seq", allocationSize=1)
    @Column(name = "concert_id")
    private Long concertId;

    @Column(name = "concert_name")
    private String concertName;

    @Column(name = "concert_date")
    private java.sql.Timestamp concertDate;

    @Column(name = "available_tickets")
    private Long availableTickets;

    @Column (name="ticket_limit_purchase")
    private Long ticketLimitPurchase;

    @Column(name = "start_date_limit")
    private java.sql.Timestamp startDateLimit;

    @Column(name = "end_date_limit")
    private java.sql.Timestamp endtDateLimit;


}
