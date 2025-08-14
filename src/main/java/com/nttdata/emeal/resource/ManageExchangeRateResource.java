package com.nttdata.emeal.resource;

import com.nttdata.emeal.model.ExchangeRateCountResponse;
import com.nttdata.emeal.model.ManageExchangeRateRequest;
import com.nttdata.emeal.model.ManageExchangeRateResponse;
import com.nttdata.emeal.service.ManageExchangeRateService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <br/> ManageExchangeRate <br/>
 * <b>Class</b>: ManageExchangeRate<br/>
 * Copyright: &copy; 2025 JMR Code.<br/>
 *
 * @author JMR Code <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 *     <li>Sergi Jhilmar Alvarez Toledo (SJAT)</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 *     <li>Ago. 10, 2025 Creaci&oacute;n de Clase.</li>
 * </ul>
 * @version 1.0
 */
@Slf4j
@Path("manage-exchange-rate")
@Consumes("application/json")
@Produces("application/json")
@AllArgsConstructor
public class ManageExchangeRateResource {

  private final ManageExchangeRateService manageExchangeRateService;

  @GET
  @Path("/fetch-current/{dni}")
  public Response fetchCurrentExchangeRate(@PathParam("dni") String dni) {
    log.info("Fetching current exchange rate");
    ManageExchangeRateRequest request = manageExchangeRateService.fetchCurrentExchangeRate(dni);
    return Response.ok(request).build();
  }

  @POST
  @Path("/save-request")
  public Response saveRequestExchangeRate(@Valid ManageExchangeRateRequest request) {
    log.info("Fetching exchange rate via POST request");
    ManageExchangeRateResponse response =
        manageExchangeRateService.saveRequestExchangeRate(request);
    return Response.status(Response.Status.CREATED)
        .entity(response)
        .build();
  }

  @GET
  @Path("/request-count/{dni}")
  public Response getFetchCount(@PathParam("dni") String dni) {
    log.info("Fetching count of exchange rate fetches");
    ExchangeRateCountResponse response = manageExchangeRateService.getRequestCountByDni(dni);
    return Response.ok(response).build();
  }

}
