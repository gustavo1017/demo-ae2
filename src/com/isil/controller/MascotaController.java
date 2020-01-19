package com.isil.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isil.dao.MascotaDao;
import com.isil.modelo.Mascota;
import com.isil.service.MascotaService;

/**
 * Servlet implementation class MascotaController
 */
@WebServlet("/")
public class MascotaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MascotaService mascotaService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MascotaController() {
        super();
        mascotaService = new MascotaService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertMascota(request, response);
				break;
			case "/delete":
				deleteMascota(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateMascota(request, response);
				break;
			default:
				listMascota(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void listMascota(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Mascota> listMascota = mascotaService.selectAllUsers();
		request.setAttribute("listMascota", listMascota);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("mascota-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Mascota existingMascota = mascotaService.selectMascota(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mascota-form.jsp");
		request.setAttribute("mascota", existingMascota);
		dispatcher.forward(request, response);
	}
	
	private void insertMascota(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nombre = request.getParameter("nombre");
		String edad = request.getParameter("edad");
		Mascota newMascota = new Mascota(nombre, edad);
		mascotaService.insertMascota(newMascota);
		response.sendRedirect("list");
	}
	
	private void updateMascota(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String edad = request.getParameter("edad");

		Mascota mascota = new Mascota(id, nombre, edad);
		mascotaService.updateMascota(mascota);
		response.sendRedirect("list");
	}
	
	private void deleteMascota(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		mascotaService.deleteMascota(id);
		response.sendRedirect("list");
	}

}
