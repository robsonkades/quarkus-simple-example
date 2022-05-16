package com.robsonkades;

import javax.enterprise.inject.Instance;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Objects;

@Path("/users")
public class Example2Resource {

    private final Instance<CreateUserService> createUserServiceInstance;

    public Example2Resource(final Instance<CreateUserService> createUserServiceInstance) {
        this.createUserServiceInstance = createUserServiceInstance;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{type}")
    public Response hello(@PathParam("type") String type) {
        if (Objects.equals(type, "dev")) {
            CreateDevServiceImpl instanceType  = createUserServiceInstance.select(CreateDevServiceImpl.class).get();
            return Response.status(Response.Status.OK).entity(new ResponseDto(instanceType.execute())).build();
        } else {
            CreateManagerServiceImpl instanceType = createUserServiceInstance.select(CreateManagerServiceImpl.class).get();
            return Response.status(Response.Status.OK).entity(new ResponseDto(instanceType.execute())).build();
        }
    }
}