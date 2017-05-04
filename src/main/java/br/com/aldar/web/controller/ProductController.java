package br.com.aldar.web.controller;

import br.com.aldar.web.annotation.RoleValidator;
import br.com.aldar.web.model.Product;
import br.com.aldar.web.model.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kaio on 25/04/17.
 * Controller example
 */
public class ProductController {

    // just an example to simulate a database
    private static List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("jaxrs-project"),
            new Product("spring-project")));

    @RoleValidator(allow = "USER")
    public List<Product> getAll() {
        return products;
    }

    @RoleValidator(deny = "ADMIN")
    public void addProduto(Token authType, Product product) {
        products.add(product);
    }
}
