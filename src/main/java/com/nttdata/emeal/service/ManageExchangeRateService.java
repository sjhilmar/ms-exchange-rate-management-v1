package com.nttdata.emeal.service;

import com.nttdata.emeal.model.ExchangeRateCountResponse;
import com.nttdata.emeal.model.ManageExchangeRateRequest;
import com.nttdata.emeal.model.ManageExchangeRateResponse;

/**
 * <br/> ManageExchangeRateService <br/>
 * <b>Class</b>: ManageExchangeRateService<br/>
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
public interface ManageExchangeRateService {

    /**
     * Save a request to fetch the exchange rate.
     *
     * @param request the manage exchange rate request
     * @return the manage exchange rate response
     */
    ManageExchangeRateResponse saveRequestExchangeRate(ManageExchangeRateRequest request);

    /**
     * Get detailed fetch count information by consultant's DNI.
     *
     * @param dni the consultant user's DNI
     * @return detailed fetch count response
     */
    ExchangeRateCountResponse getRequestCountByDni(String dni);

    /**
     * Fetch the current exchange rate from an external service.
     *
     * @return the current exchange rate response
     */
    ManageExchangeRateRequest fetchCurrentExchangeRate(String dni);

}
