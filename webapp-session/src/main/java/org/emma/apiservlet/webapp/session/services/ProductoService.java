package org.emma.apiservlet.webapp.session.services;

import org.emma.apiservlet.webapp.session.models.Categoria;
import org.emma.apiservlet.webapp.session.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> porId(Long id);

    void guardar(Producto producto);
    void eliminar(Long id);

    List<Categoria> listarCategorias();
    Optional<Categoria> porIdCategoria(Long id);
}
