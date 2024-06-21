package com.tsswebapps.hotel;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/hotels")
public class HotelResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hotel> listAll() {
        return Hotel.listAll();
    }

    @GET
    @Path("/findById")
    public Hotel findByCode(@QueryParam("id") String id) {
        return Hotel.findById(id);
    }

    @GET
    @Path("/findByTravelOrderId")
    public Hotel findByTravelOrderId(@QueryParam("travelOrderId") Long travelOrderId) {
        return Hotel.findByTravelOrderId(travelOrderId);
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Hotel newHotel(Hotel hotel) {
        hotel.id = null;
        hotel.persist();
        return hotel;
    }
}
