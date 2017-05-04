package br.com.aldar.web.resources;

import br.com.aldar.web.controller.ProductController;
import br.com.aldar.web.model.Product;
import br.com.aldar.web.model.Token;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;


@Path("products")
@RequestScoped
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    private ProductController productController;

    @PostConstruct
    public void init() {
    }

    @GET
    public List<Product> getAllProductss() {
        return productController.getAll();
    }

    @POST
    public Response createProduct(@Context HttpServletRequest request, Product product) throws URISyntaxException {
        productController.addProduto(Token.build(request), product);
        return Response
                .created(URI.create(String.valueOf(new Random().nextInt())))
                .entity(product)
                .build();
    }
}