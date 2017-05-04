package br.com.aldar.web.model;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Kaio on 02/05/17.
 * Token model
 */
public class Token {

    private String token;

    private Token(String token) {
        this.token = token;
    }

    public static Token build(HttpServletRequest request) {
        return new Token(request.getHeader("Authorization"));
    }

    public String getToken() {
        return token;
    }
}