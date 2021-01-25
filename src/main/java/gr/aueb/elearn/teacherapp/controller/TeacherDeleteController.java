package gr.aueb.elearn.teacherapp.controller;

import java.io.IOException;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.elearn.teacherapp.dao.ITeacherDAO;
import gr.aueb.elearn.teacherapp.dao.TeacherDAOImpl;
import gr.aueb.elearn.teacherapp.dto.TeacherDTO;
import gr.aueb.elearn.teacherapp.model.Teacher;
//import gr.aueb.elearn.teacherapp.model.Teacher;
import gr.aueb.elearn.teacherapp.service.ITeacherService;
import gr.aueb.elearn.teacherapp.service.TeacherServiceImpl;
import gr.aueb.elearn.teacherapp.service.exceptions.TeacherNotFoundException;

/**
 * Servlet implementation class TeacherDeleteController
 */
public class TeacherDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		TeacherDTO teacherDTO = new TeacherDTO();
		ITeacherDAO teacherDAO = new TeacherDAOImpl();
		ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		teacherDTO.setId(id);
		try {
			Teacher toDelete = teacherServ.getTeacherById(id);
			
			teacherServ.deleteTeacher(teacherDTO);
			request.setAttribute("intro", "Επιτυχής διαγραφή!");
			request.setAttribute("deletedTeacher", toDelete);
			request.getRequestDispatcher("/jsp/deleteTeacher.jsp").forward(request, response);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (TeacherNotFoundException e2) {
			request.setAttribute("intro", "Ο καθηγητής δεν βρέθηκε");
			request.getRequestDispatcher("/jsp/deleteTeacher.jsp").forward(request, response);
		}	
	}

}
