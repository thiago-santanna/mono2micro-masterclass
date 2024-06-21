package com.tsswebapps.order;

import com.tsswebapps.fligth.Fligth;
import com.tsswebapps.hotel.Hotel;

public class TravelOrderDto {
    private String fligthFrom;
    private String fligthTo;
    private Integer nights;

    public TravelOrderDto() {
    }

    public TravelOrderDto(String fligthFrom, String fligthTo, Integer nights) {
        this.fligthFrom = fligthFrom;
        this.fligthTo = fligthTo;
        this.nights = nights;
    }

    public static TravelOrderDto of(TravelOrder order, Fligth fligth, Hotel hotel) {
        return new TravelOrderDto(fligth.fligthFrom, fligth.fligthTo, hotel.nights);
    }

    public static TravelOrderDto of(String fligthFrom, String fligthTo, Integer nights) {
        return new TravelOrderDto(fligthFrom, fligthTo, nights);
    }

    public String getFligthFrom() {
        return fligthFrom;
    }

    public void setFligthFrom(String fligthFrom) {
        this.fligthFrom = fligthFrom;
    }

    public String getFligthTo() {
        return fligthTo;
    }

    public void setFligthTo(String fligthTo) {
        this.fligthTo = fligthTo;
    }

    public Integer getNights() {
        return nights;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }
}
