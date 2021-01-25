package gr.aueb.elearn.teacherapp.service;
import java.sql.SQLException;
import java.util.List;

import gr.aueb.elearn.teacherapp.dto.TeacherDTO;
import gr.aueb.elearn.teacherapp.model.Teacher;
import gr.aueb.elearn.teacherapp.service.exceptions.TeacherIdAlreadyExistsException;
import gr.aueb.elearn.teacherapp.service.exceptions.TeacherNotFoundException;

public interface ITeacherService {	
	
	/**
	 * Inserts a {@link Teacher} based on the data carried by the
	 * {@link TeacherDTO}.
	 * 
	 * @param teacherDTO 
	 * 			DTO object that contains the data.
	 * @throws TeacherIdAlreadyExistsException
	 * 			if any Teacher identified by their id 
	 * 			needed to be inserted has been already
	 * 			inserted. 
	 * @throws SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 */
	void insertTeacher(TeacherDTO teacherDTO) 
			throws TeacherIdAlreadyExistsException, SQLException;
	
	/**
	 * Deletes a {@link Teacher} based on the data carried by the
	 * {@link TeacherDTO}.
	 * 
	 * @param teacherDTO 
	 * 			DTO object that contains the data.
	 * @throws TeacherIdAlreadyExistsException
	 * 			if any Teacher identified by their id 
	 * 			needed to be inserted has been already
	 * 			inserted. 
	 * @throws SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 */
	
	void deleteTeacher(TeacherDTO teacherDTO)
			throws TeacherNotFoundException, SQLException;
	
	
	/**
	 * Updates a {@link Teacher} based on the data carried by the
	 * {@link TeacherDTO}.
	 * 
	 * @param oldTeacherDTO
	 * 			DTO object that contains the data -mainly the id-
	 * 			of the {@link Teacher} that will be updated.  
	 * @param newTeacherDTO
	 * 			DTO object that contains the data of the 
	 * 			new {@link Teacher}.
	 * @throws TeacherNotFoundException
	 * 			if any Teacher identified by their id 
	 * 			was not found. 
	 * @throws SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 */
	void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO) 
			throws TeacherNotFoundException, SQLException;
	
	
	
	/**
	 * Searches and gets back to the caller a list
	 * of the {@link Teacher} objects identified by
	 * by their surname or surname's initial letters.
	 * 
	 * @param surname
	 * 			a String object that contains the
	 * 			surname or the letters that the 
	 * 			surname starts with, of the {@link Teacher}
	 * 			objects we are looking for. 
	 * @return
	 * 			a List that contains the results of
	 * 			the search, that is a List of {@link Teacher}
	 * 			objects. 
	 * @throws SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 */
	List<Teacher> getTeachersBySurname(String surname) 
			throws SQLException;
	
	/**
	 * Searches and gets back to the caller a {@link Teacher} objects identified by
	 * by Id.
	 * 
	 * @param id
	 * 			an Integer that contains the
	 * 			id which identifies the {@link Teacher}
	 * 			we are looking for. 
	 * @return
	 * 			a {@link Teacher} which is the result of
	 * 			the search.
	 * @throws SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 */
	Teacher getTeacherById(Integer id) 
			throws SQLException;
}
