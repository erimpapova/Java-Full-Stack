package gr.aueb.elearn.teacherapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.elearn.teacherapp.dao.ITeacherDAO;
import gr.aueb.elearn.teacherapp.dao.TeacherDAOImpl;
import gr.aueb.elearn.teacherapp.dto.TeacherDTO;
import gr.aueb.elearn.teacherapp.model.Teacher;
import gr.aueb.elearn.teacherapp.service.ITeacherService;
import gr.aueb.elearn.teacherapp.service.TeacherServiceImpl;

/**
 * Servlet implementation class TeacherUpdateController
 */
public class PrepareTeacherUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		TeacherDTO teacherDTO = new TeacherDTO();
		ITeacherDAO teacherDAO = new TeacherDAOImpl();
		ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);
		

		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		try {
			Teacher oldTeacher = teacherServ.getTeacherById(id);
			teacherDTO.setId(oldTeacher.getId());
			teacherDTO.setFname(oldTeacher.getFname());
			teacherDTO.setSname(oldTeacher.getSname());
		} catch (SQLException e) {
			teacherDTO = null;
			e.printStackTrace();
		}
		
		if (teacherDTO != null) {
			request.setAttribute("intro", "Ενημέρωση καθηγητή:<br>");
			request.setAttribute("teacher2Update", teacherDTO);
			request.getRequestDispatcher("/jsp/updateTeacher.jsp").forward(request, response);
		} else {
			request.setAttribute("intro", "Δεν βρέθηκε καθηγητής<br>");
			request.getRequestDispatcher("/jsp/teachers.jsp").forward(request, response);
		}
	}


}
