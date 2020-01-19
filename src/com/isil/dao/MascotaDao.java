package com.isil.dao;

import com.isil.modelo.Mascota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.isil.dao.Conexion;
import com.isil.util.Constants;


public class MascotaDao {
	public MascotaDao() {
		
	}
	
	public void insertMascota(Mascota mascota) throws SQLException {
		System.out.println(Constants.INSERT_MASCOTA_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = Conexion.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Constants.INSERT_MASCOTA_SQL)) {
			preparedStatement.setString(1, mascota.getNombre());
			preparedStatement.setString(2, mascota.getEdad());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public Mascota selectMascota(int id) {
		Mascota mascota = null;
		// Step 1: Establishing a Connection
		try (Connection connection = Conexion.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(Constants.SELECT_MASCOTA_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String edad = rs.getString("edad");
				mascota = new Mascota(id, nombre, edad);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return mascota;
	}
	
	public List<Mascota> selectAllMascotas() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Mascota> mascotas = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = Conexion.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(Constants.SELECT_ALL_MASCOTAS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String edad = rs.getString("edad");
				mascotas.add(new Mascota(id, nombre, edad));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return mascotas;
	}
	
	public boolean deleteMascota(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = Conexion.getConnection();
				PreparedStatement statement = connection.prepareStatement(Constants.DELETE_MASCOTA_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public boolean updateMascotas(Mascota mascota) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = Conexion.getConnection();
				PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_MASCOTA_SQL);) {
			statement.setString(1, mascota.getNombre());
			statement.setString(2, mascota.getEdad());
			statement.setInt(3, mascota.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}


}
