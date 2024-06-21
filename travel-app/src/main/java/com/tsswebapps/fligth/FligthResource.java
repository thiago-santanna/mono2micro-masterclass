package com.tsswebapps.fligth;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/fligths")
public class FligthResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fligth> list() {
        return Fligth.listAll();
    }

    @GET
    @Path("/findId")
    @Produces(MediaType.APPLICATION_JSON)
    public Fligth findById(@QueryParam("id") Long id) {
        return Fligth.findById(id);
    }

    @GET
    @Path("/findTravelOrderId")
    @Produces(MediaType.APPLICATION_JSON)
    public Fligth findByTravelOrderId(@QueryParam("travelOrderId") Long travelOrderId) {
        return Fligth.findByOrderId(travelOrderId);
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Fligth newFligth(Fligth fligth) {
        fligth.id = null;
        fligth.persist();
        return fligth;
    }
}
