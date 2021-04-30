package de.papenhagen;

import de.papenhagen.service.HolidayService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/holiday")
@ApplicationScoped
public class ExampleResource {


    @Inject
    HolidayService holidayService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return holidayService.isFeiertag() ? "jo": "nö";
    }
}