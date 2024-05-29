package org.emma.apiservlet.webapp.session.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

    //Para iniciar la conexion hacia la base de datos
    //Se debe tener en cuenta el nombre de la base de datos, el usuario y la contraseña
    //En este caso se esta utilizando una base de datos llamada java_curso
    //El usuario es root y la contraseña es sasa
    private static final String URL = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Santiago";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "sasa";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}
