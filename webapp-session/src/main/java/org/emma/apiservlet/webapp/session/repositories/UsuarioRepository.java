package org.emma.apiservlet.webapp.session.repositories;

import org.emma.apiservlet.webapp.session.models.Usuario;

import java.sql.SQLException;

public interface UsuarioRepository extends Repository<Usuario>{
    Usuario porUsername (String username) throws SQLException;
}
