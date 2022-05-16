package com.robsonkades;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class ExampleResource {

    private final CreateUserService createUserService;

    public ExampleResource(@Named("CreateManagerServiceImpl") final CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        var name = this.createUserService.execute();
        return Response.status(Response.Status.OK).entity(new ResponseDto(name)).build();
    }
}