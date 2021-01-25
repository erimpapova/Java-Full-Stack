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
import gr.aueb.elearn.teacherapp.service.ITeacherService;
import gr.aueb.elearn.teacherapp.service.TeacherServiceImpl;
import gr.aueb.elearn.teacherapp.service.exceptions.TeacherIdAlreadyExistsException;

/**
 * Servlet implementation class TeacherInsertController
 */
public class TeacherInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherDTO teacherDTO;
		ITeacherDAO teacherDAO = new TeacherDAOImpl();
		ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);
		
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String firstName = request.getParameter("teacher_firstname");
//		System.out.println(firstName);
		String lastName = request.getParameter("teacher_lastname");
//		System.out.println(lastName);
		Integer id = Integer.parseInt(request.getParameter("teacher_id"));
		
		teacherDTO = new TeacherDTO(id, firstName, lastName);
		
		try {
			teacherServ.insertTeacher(teacherDTO);
			request.setAttribute("intro", "Νέος καθηγητής");
			request.setAttribute("insertedTeacher", teacherDTO);
			request.getRequestDispatcher("/jsp/newTeacher.jsp").forward(request, response);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (TeacherIdAlreadyExistsException e2) {
			request.setAttribute("intro", "Teacher already exist");
			request.setAttribute("insertedTeacher", teacherDTO);
			request.getRequestDispatcher("/jsp/newTeacher.jsp").forward(request, response);
		}	
	}
}
