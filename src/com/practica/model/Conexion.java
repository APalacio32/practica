package com.practica.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
	
	//Declaracion de variables
	private Connection connectionDB;
	private String url;
	private String user;
	private String password;
	
	// Declaracion del constructor
	public Conexion(String url, String user, String password) {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
	}

	
	// Metodo para conectar a la Base de Datos
	public void conectar() throws SQLException {
        if (connectionDB == null || connectionDB.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connectionDB = DriverManager.getConnection(url, user, password);
        }
    }

	// Metodo para desconectarse de la Base de Datos
    public void desconectar() throws SQLException {
        if (connectionDB != null && !connectionDB.isClosed()) {
        	connectionDB.close();
        }
    }
 
    
   	public Connection getJdbcConnection() {
   		return connectionDB;
   	}  
}
