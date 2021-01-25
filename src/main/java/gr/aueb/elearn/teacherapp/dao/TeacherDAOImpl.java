package gr.aueb.elearn.teacherapp.dao;

import static gr.aueb.elearn.teacherapp.dao.dbutil.DBUtil.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import gr.aueb.elearn.teacherapp.model.Teacher;

public class TeacherDAOImpl implements ITeacherDAO {

	@Override
	public void insert(Teacher teacher) throws SQLException {
		String sql = "INSERT INTO TEACHERS VALUES ('" + teacher.getId() 
		+ "', '" + teacher.getSname() + "', '" + teacher.getFname() + "')";
		
		PreparedStatement pst = openConnection().prepareStatement(sql);
		int n = pst.executeUpdate(sql);
				
		closeStmt(pst);
		closeConnection();
	}

	@Override
	public void delete(Teacher teacher) throws SQLException {
		String sql = "DELETE FROM TEACHERS WHERE TEACHER_ID = " + teacher.getId();
		
		PreparedStatement pst = openConnection().prepareStatement(sql);

//      	int numberOfRowsAffected = 
      			pst.executeUpdate();
        closeStmt(pst);
      	closeConnection();
	}

	@Override
	public void update(Teacher oldTeacher, Teacher newTeacher) throws SQLException {
		String sql = "UPDATE TEACHERS SET S_NAME = '" + newTeacher.getSname() + "', " + "F_NAME = '" 
				+ newTeacher.getFname() + "' WHERE TEACHER_ID = " + oldTeacher.getId();
		System.out.println(sql);
		
		PreparedStatement pst = openConnection().prepareStatement(sql);
		pst.executeUpdate();
	      
	    closeStmt(pst);
		closeConnection();
	}

	@Override
	public List<Teacher> getTeachersBySurname(String surname) throws SQLException {
		String sql = "SELECT TEACHER_ID, S_NAME, F_Name FROM TEACHERS WHERE S_NAME LIKE '" 
				+ surname + "%'";
		
	    PreparedStatement pst =  openConnection().prepareStatement(sql);
	    ResultSet rs = pst.executeQuery(sql);
	    
	    List<Teacher> teachers = new ArrayList<>();
	    
	    while (rs.next()) {
	    	Teacher teacher = new Teacher();
		    	
	    	teacher.setId(rs.getInt("TEACHER_ID"));
	    	teacher.setSname(rs.getString("S_NAME"));
	    	teacher.setFname(rs.getString("F_NAME"));
	    	teachers.add(teacher); 	
	    }
	    
	    closeRS(rs);
	    closeStmt(pst);
	    closeConnection();
	    return (teachers.size()!=0) ? teachers : null;
	}

	@Override
	public Teacher getTeacherById(int id) throws SQLException {
		boolean teacherFound = false;
		String sql = "SELECT * FROM TEACHERS WHERE TEACHER_ID = " 
				+ id;
	    PreparedStatement pst =  openConnection().prepareStatement(sql);
	    ResultSet rs = pst.executeQuery(sql);
	    Teacher teacher = new Teacher();
	    if (rs.next()) {
	    	teacher.setId(rs.getInt("TEACHER_ID"));
	    	teacher.setSname(rs.getString("S_NAME"));
	    	teacher.setFname(rs.getString("F_NAME"));
	    	teacherFound = true;
	    }
	    
	    closeRS(rs);
	    closeStmt(pst);
	    closeConnection();
	    return (teacherFound) ? teacher : null;
	}	
}


