package com.practica.model;

public class Cliente {
	
	//Declaracion de atributos
	private int id;
	private String nombre;
	private String apellidos;
	private String correo;
	private String telefono;
	
	//Declaracion del constructor
	public Cliente(int id,String nombre, String apellidos, String correo, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.telefono = telefono;
	}

	// Getters y Setters	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
