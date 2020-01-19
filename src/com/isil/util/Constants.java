package com.isil.util;

public class Constants {
	//Constantes
   public static final String JDBC_CLASS="com.mysql.jdbc.Driver";
   public static final String JDBC_URL="jdbc:mysql://localhost:3306/veterinaria?useSSL=false&&serverTimezone=UTC";
   public static final String JDBC_USERNAME="root";
   public static final String JDBC_PASSWORD="abcdeFG12345_";
   
   
    public static final String INSERT_MASCOTA_SQL = "INSERT INTO mascota" + "  (nombre, edad) VALUES "
			+ " (?, ?);";
	public static final String SELECT_MASCOTA_BY_ID = "select id,nombre,edad from mascota where id =?";
	public static final String SELECT_ALL_MASCOTAS = "select * from mascota";
	public static final String DELETE_MASCOTA_SQL = "delete from mascota where id = ?;";
	public static final String UPDATE_MASCOTA_SQL = "update mascota set nombre = ?,edad= ? where id = ?;";
   
}
