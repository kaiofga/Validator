package br.com.aldar.web.exception.mapper;

import br.com.aldar.web.model.ResponseBody;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Kaio on 01/05/17.
**/
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {

    public Response toResponse(Exception ex) {
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(ResponseBody.build(ex.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
