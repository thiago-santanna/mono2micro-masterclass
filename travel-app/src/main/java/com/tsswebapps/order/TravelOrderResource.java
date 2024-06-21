package com.tsswebapps.order;

import com.tsswebapps.fligth.Fligth;
import com.tsswebapps.fligth.FligthResource;
import com.tsswebapps.hotel.Hotel;
import com.tsswebapps.hotel.HotelResource;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/orders")
public class TravelOrderResource {

    @Inject
    FligthResource fligthResource;

    @Inject
    HotelResource hotelResource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelOrderDto> list() {
        return TravelOrder.<TravelOrder>listAll()
                .stream()
                .map(order -> TravelOrderDto
                        .of(
                            order,
                            fligthResource.findByTravelOrderId(order.id),
                            hotelResource.findByTravelOrderId(order.id)))
                .toList();
    }

    @GET
    @Path("/findById")
    public TravelOrder findById(@QueryParam("id") Long id) {
        return TravelOrder.findById(id);
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TravelOrder newOrder(TravelOrderDto orderDto) {
        TravelOrder order = new TravelOrder();
        order.id = null;
        order.persist();

        Fligth fligth = new Fligth();
        fligth.fligthFrom = orderDto.getFligthFrom();
        fligth.fligthTo = orderDto.getFligthTo();
        fligth.orderId = order.id;
        fligthResource.newFligth(fligth);

        Hotel hotel = new Hotel();
        hotel.nights = orderDto.getNights();
        hotel.travelOrderId = order.id;
        hotelResource.newHotel(hotel);

        return order;
    }
}
