package org.emma.apiservlet.webapp.session.services;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

public class LoginServiceCookieImpl implements LoginService {
    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        //Creamos un array de cookies, si no hay cookies, creamos un array vacio
        Cookie[] cookies = req.getCookies() != null ? req.getCookies() : new Cookie[0];
        //Buscamos la cookie con el nombre de usuario
        //Si la cookie no existe, el metodo findAny() retorna un Optional vacio
        return Arrays.stream(cookies)
                .filter(cookie -> "username".equals(cookie.getName()))
                .map(Cookie::getValue)
                .findAny();
    }
}
