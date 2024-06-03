package org.emma.apiservlet.webapp.session.services;

import org.emma.apiservlet.webapp.session.models.Categoria;
import org.emma.apiservlet.webapp.session.models.Producto;
import org.emma.apiservlet.webapp.session.repositories.CategoriaRepositorioImpl;
import org.emma.apiservlet.webapp.session.repositories.ProductoRepositoryJdbcImpl;
import org.emma.apiservlet.webapp.session.repositories.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductoServiceJdbcImpl implements ProductoService{
    private Repository<Producto> repositoryProducto;
    private Repository<Categoria> repositoryCategoria;

    public ProductoServiceJdbcImpl(Connection connection) {
        this.repositoryProducto = new ProductoRepositoryJdbcImpl(connection);
        this.repositoryCategoria = new CategoriaRepositorioImpl(connection);
    }

    @Override
    public List<Producto> listar() {
        try {
            return repositoryProducto.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try{
            return Optional.ofNullable(repositoryProducto.porId(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Producto producto) {
        try {
            repositoryProducto.guardar(producto);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            repositoryProducto.eliminar(id);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Categoria> listarCategorias() {
        try {
            return repositoryCategoria.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        try {
            return Optional.ofNullable(repositoryCategoria.porId(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
