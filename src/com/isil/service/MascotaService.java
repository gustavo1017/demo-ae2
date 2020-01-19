package com.isil.service;

import java.sql.SQLException;
import java.util.List;

import com.isil.dao.MascotaDao;
import com.isil.modelo.Mascota;


public class MascotaService {

	 MascotaDao dao= new MascotaDao();

		public void insertMascota(Mascota mascota) throws SQLException {
			dao.insertMascota(mascota);
			} 

		public Mascota selectMascota(int id) {
			return dao.selectMascota(id);
		}

		public List<Mascota> selectAllUsers() {
			return dao.selectAllMascotas();
		}

		public boolean deleteMascota(int id) throws SQLException {
			return dao.deleteMascota(id);
		}

		public boolean updateMascota(Mascota mascota) throws SQLException {
			return dao.updateMascotas(mascota);
		}
}
