package com.tsswebapps.order;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/orders")
public class OrderResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelOrder> list() {
        return TravelOrder.listAll();
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
    public TravelOrder newOrder(TravelOrder order) {
        order.id = null;
        order.persist();
        return order;
    }
}
