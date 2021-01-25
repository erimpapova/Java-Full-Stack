package gr.aueb.elearn.teacherapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.elearn.teacherapp.dao.ITeacherDAO;
import gr.aueb.elearn.teacherapp.dao.TeacherDAOImpl;
//import gr.aueb.elearn.teacherapp.dto.TeacherDTO;
import gr.aueb.elearn.teacherapp.model.Teacher;
import gr.aueb.elearn.teacherapp.service.ITeacherService;
import gr.aueb.elearn.teacherapp.service.TeacherServiceImpl;

/**
 * Servlet implementation class TeacherSearchController
 */
//@WebServlet("/TeacherSearchController")
public class TeacherSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		ITeacherDAO teacherDAO = new TeacherDAOImpl();
		ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);
		List<Teacher> teachers = new ArrayList<>();
		
		String lastName = request.getParameter("teacher_surname");
		
		
		try {
			teachers = teacherServ.getTeachersBySurname(lastName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (teachers != null) {
			request.setAttribute("intro", "Αποτελέσματα αναζήτησης:<br>");
			request.setAttribute("teachers", teachers);
			request.getRequestDispatcher("/jsp/teachers.jsp").forward(request, response);
		} else {
			request.setAttribute("intro", "Δεν βρέθηκαν αποτελέσματα<br>");
//			response.getWriter().write("<h1 style=\"color:red\">Teacher does not exist</h1>");
			request.getRequestDispatcher("/jsp/teachers.jsp").forward(request, response);
		}
	}
}
