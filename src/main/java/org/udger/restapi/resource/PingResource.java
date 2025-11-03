package org.udger.restapi.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.udger.restapi.service.ParserStatistics;

@Path("ping")
public class PingResource {

    @Inject
    private ParserStatistics parserStatistics;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getStatistic() {
        parserStatistics.updateStatisticUA(0);
        return Response.ok().entity("OK").build();
    }
}