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
import gr.aueb.elearn.teacherapp.service.exceptions.TeacherNotFoundException;

/**
 * Servlet implementation class TeacherUpdateController
 */
public class TeacherUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		int error = 0;
		
		TeacherDTO oldTeacherDTO = new TeacherDTO();
		ITeacherDAO teacherDAO = new TeacherDAOImpl();
		ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String updatedFname = request.getParameter("fnameUpdate");
		String updatedSname = request.getParameter("snameUpdate");
		
		TeacherDTO updatedTeacherDTO = new TeacherDTO();
		updatedTeacherDTO.setId(id);
		updatedTeacherDTO.setFname(updatedFname);
		updatedTeacherDTO.setSname(updatedSname);
		
		try {
			Teacher oldTeacher = teacherServ.getTeacherById(id);
			oldTeacherDTO.setId(oldTeacher.getId());
			oldTeacherDTO.setFname(oldTeacher.getFname());
			oldTeacherDTO.setSname(oldTeacher.getSname());		
			
			teacherServ.updateTeacher(oldTeacherDTO, updatedTeacherDTO);
			
		} catch (SQLException e) {
			error = 1;
			e.printStackTrace();
		} catch (TeacherNotFoundException e) {
			error = 1;
			e.printStackTrace();
		}
		
		
		if (error == 0) {
			request.setAttribute("intro", "Επιτυχής ενημέρωση!<br>");
			request.setAttribute("insertedTeacher", updatedTeacherDTO);
			request.getRequestDispatcher("/jsp/newTeacher.jsp").forward(request, response);
		} else {
			request.setAttribute("intro", "Παρουσιάστηκε σφάλμα στην ενημέρωση!<br>");
			request.getRequestDispatcher("/jsp/teachers.jsp").forward(request, response);
		}
	}

}
