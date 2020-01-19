package com.isil.modelo;

public class Mascota {
	private int id;
	private String nombre;
	private String edad;
	
	
	public Mascota() {
	
	}
	public Mascota( String nombre, String edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	
	
	public Mascota(int id, String nombre, String edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}
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
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	

}
