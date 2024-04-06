package com.test.edts.dto;


import com.test.edts.model.Concert;
import com.test.edts.util.GeneralUtil;
import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;

@Getter
@Setter
public class ConcertDTO {
    private Long concertId;
    private String concertName;
    private String concertDate;
    private Long availableTickets;
    private Long ticketLimitPurchase;
    private String startDateLimit;
    private String endtDateLimit;

    public Concert toBean () throws ParseException {
        Concert x = new Concert();
        x.setConcertDate(GeneralUtil.stringToTimestamp(this.concertDate));
        x.setConcertName(this.concertName);
        x.setAvailableTickets(this.availableTickets);

        if(this.ticketLimitPurchase!=null ){
            x.setTicketLimitPurchase(this.ticketLimitPurchase);
        }

        if(this.startDateLimit!=null && !this.startDateLimit.isEmpty()  ){
            x.setStartDateLimit(GeneralUtil.stringToTimestamp(this.startDateLimit));
        }

        if(this.endtDateLimit!=null && !this.endtDateLimit.isEmpty()){
            x.setEndtDateLimit(GeneralUtil.stringToTimestamp(this.endtDateLimit));

        }
        return x;
    }
}
