package gr.aueb.elearn.teacherapp.dao;

import java.sql.SQLException;
import java.util.List;
import gr.aueb.elearn.teacherapp.model.Teacher;

public interface ITeacherDAO {
	void insert(Teacher teacher) throws SQLException;
	void delete(Teacher teacher) throws SQLException;
	void update(Teacher oldTeacher, Teacher newTeacher) throws SQLException;
	List<Teacher> getTeachersBySurname(String surname) throws SQLException;
	Teacher getTeacherById(int id) throws SQLException;
}
