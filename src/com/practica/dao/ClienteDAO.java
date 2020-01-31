package com.practica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.practica.model.Cliente;
import com.practica.model.Conexion;

/*
 * Clase para el acceso a la Base de Datos y realizar las operaciones de:
 * Agregar,Leer,Actualizar,Eliminar 
 */
public class ClienteDAO {
	
	//Declaracion de variables
	private Conexion conn;
	private Connection connection;
	
	//Constructor
	public ClienteDAO(String url,String user,String password){
		conn = new Conexion(url,user,password);
	}
	
	/*
	 * Metodos para interactuar con la Base de Datos
	 */
	
	// Agregar un nuevo cliente
	public boolean addClient(Cliente cliente) throws SQLException {
		
		String sql = "INSERT INTO cliente (idcliente, nombre, apellidos, correo, telefono) VALUES (?, ?, ?, ?, ?)";
		
		conn.conectar();
		connection = conn.getJdbcConnection();
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setString(2, cliente.getNombre());
		statement.setString(3, cliente.getApellidos());
		statement.setString(4, cliente.getCorreo());
		statement.setString(5, cliente.getTelefono());
 
		boolean rowInserted = statement.executeUpdate() > 0;
		
		statement.close();
		conn.desconectar();
		
		return rowInserted;
	}
	
	// Obtener el listado de clientes
	public List<Cliente> getListClients() throws SQLException{
		
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		String sql = "SELECT * FROM cliente";
		conn.conectar();
		connection = conn.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			int id = resulSet.getInt("idcliente");
			String nombre = resulSet.getString("nombre");
			String apellidos = resulSet.getString("apellidos");
			String correo = resulSet.getString("correo");
			String telefono = resulSet.getString("telefono");
			
			Cliente cliente = new Cliente(id,nombre,apellidos, correo, telefono);
			listaClientes.add(cliente);
		}
		conn.desconectar();
		return listaClientes;
	}
	
	// Obtener la informacion del cliente por id
	public Cliente infoClientById(int id) throws SQLException {
		Cliente cliente = null;
		 
		String sql = "SELECT * FROM cliente WHERE idcliente= ? ";
		conn.conectar();
		connection = conn.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
 
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			cliente = new Cliente(res.getInt("idcliente"), res.getString("nombre"), res.getString("apellidos"),
					res.getString("correo"), res.getString("telefono"));
		}
		res.close();
		conn.desconectar();
 
		return cliente;	
	}
	
	public boolean updateClient(Cliente cliente) throws SQLException {
		
		boolean rowActualizar = false;
		
		String sql = "UPDATE cliente SET nombre=?,apellidos=?,correo=?, telefono=? WHERE idcliente=?";
		
		conn.conectar();
		connection = conn.getJdbcConnection();
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getNombre());
		statement.setString(2, cliente.getApellidos());
		statement.setString(3, cliente.getCorreo());
		statement.setString(4, cliente.getTelefono());
		statement.setInt(5, cliente.getId());
 
		rowActualizar = statement.executeUpdate() > 0;
		
		statement.close();
		conn.desconectar();
		
		return rowActualizar;
	}
	
	public boolean deleteClient(Cliente cliente) throws SQLException {
		
		boolean rowEliminar = false;
		
		String sql = "DELETE FROM cliente WHERE idcliente=?";
		
		conn.conectar();
		connection = conn.getJdbcConnection();
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1,cliente.getId());
 
		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		conn.desconectar();
 
		return rowEliminar;	
	}
}
