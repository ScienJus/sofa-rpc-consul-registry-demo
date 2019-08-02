package com.scienjus.sofa.rpc.consul;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/api")
public interface HelloService {

    @POST
    @Path("/say")
    @Consumes("text/plain")
    String say(String string);
}
