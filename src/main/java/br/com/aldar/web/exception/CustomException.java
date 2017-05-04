package br.com.aldar.web.exception;

import br.com.aldar.web.model.ResponseBody;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Created by Kaio on 02/05/17.
 * Custom Exception created to throw a exception
 */
public class CustomException extends WebApplicationException {

    /**
     * * Create a HTTP 401 (Not Authorized) exception.
     * * @param message the String that is the entity of the 401 .
     */
    public CustomException(String message) {
        super(Response.status(Response.Status.UNAUTHORIZED)
                .entity(ResponseBody.build(message))
                .build());
    }
}