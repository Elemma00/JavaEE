package org.emma.apiservlet.webapp.session.services;

import org.emma.apiservlet.webapp.session.models.Categoria;
import org.emma.apiservlet.webapp.session.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * Implementación de la interfaz ProductoService
 * @see ProductoService
 * @version 1.0 28/06/2020
 * @since 1.0
 * @autor Emmanuel Faúndez
 * */
public class ProductoServiceImpl implements ProductoService{
@Override


    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "Producto 1", "computación", 100),
                new Producto(2L, "Producto 2", "oficina", 200),
                new Producto(3L, "Producto 3", "cocina", 300),
                new Producto(4L, "Producto 4", "computación", 400),
                new Producto(5L, "Producto 5", "oficina", 500));
    }

    @Override
    public Optional<Producto> porId(Long id) {
        return listar().stream().filter(producto -> producto.getId().equals(id)).findAny();
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<Categoria> listarCategorias() {
        return List.of();
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.empty();
    }
}
