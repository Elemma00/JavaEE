package org.emma.apiservlet.webapp.headers.services;

import org.emma.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImpl implements ProductoService{
@Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "Producto 1", "computación", 100),
                new Producto(2L, "Producto 2", "oficina", 200),
                new Producto(3L, "Producto 3", "cocina", 300),
                new Producto(4L, "Producto 4", "computación", 400),
                new Producto(5L, "Producto 5", "oficina", 500));
    }
}
