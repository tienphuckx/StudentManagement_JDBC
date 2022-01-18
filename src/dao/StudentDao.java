package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connected.DBConnection;
import model.RangesScores;
import model.Student;

public class StudentDao {
	
	
	private String SQL_ADD_NEW_STUDENT 				= "INSERT INTO student (mssv,fullname,age,phone,address,scode) VALUES (?,?,?,?,?,?)";
	private String SQL_UPDATE_STUDENT 				= "UPDATE student SET fullname=?, age=?, phone=?, address=?, scode=? WHERE mssv=?";
	private String SQL_DELETE_STUDENT_BY_MSSV 		= "DELETE FROM student WHERE mssv=?";
	private String SQL_GET_STUDENT_BY_RANGES_SCORES = "SELECT * FROM student WHERE scode >=? AND scode <=?";
	private String SQL_GET_STUDENT_BY_SCORE 		= "SELECT * FROM student WHERE scode =?";
	private String SQL_GET_ALL_STUDENT 				= "SELECT * FROM STUDENT";
	private String SQL_GET_STUDENT_BY_MSSV 			= "SELECT * FROM STUDENT WHERE mssv=?";

	public ArrayList<Student> getAllStudent() {
		ArrayList<Student> rs = new ArrayList<Student>();
		try {
			if (DBConnection.open()) {
				Statement statement = DBConnection.getConnection().createStatement();
				ResultSet resultSet = statement.executeQuery(SQL_GET_ALL_STUDENT);
				while (resultSet.next()) {
					Student student = new Student(resultSet);
					rs.add(student);
				}
			}
		} catch (SQLException e) {
			System.out.println("|ERROR: GET ALL STUDENT - ERROR - SQL : " + e.getMessage());
		} finally {
			DBConnection.close();
		}
		return rs;
	}

	public Student getStudentByMSSV(String mssv) {
		Student student = null;
		try {
			if (DBConnection.open()) {
				PreparedStatement preparedStatement = DBConnection.getConnection()
						.prepareStatement(SQL_GET_STUDENT_BY_MSSV);
				preparedStatement.setString(1, mssv);
				ResultSet rs = preparedStatement.executeQuery();
				student = new Student(rs);
			}
		} catch (SQLException e) {
			System.out.println("|ERROR: GET A STUDENT BY MSSV - ERROR - SQL : " + e.getMessage());
		} finally {
			DBConnection.close();
		}
		return student;
	}

	public ArrayList<Student> getListStudentByRangesScore(RangesScores rangesScores) {
		ArrayList<Student> listStudent = new ArrayList<Student>();
		try {
			if (DBConnection.open()) {
				PreparedStatement preparedStatement = DBConnection.getConnection()
						.prepareStatement(SQL_GET_STUDENT_BY_RANGES_SCORES);
				preparedStatement.setDouble(1, rangesScores.getBegin());
				preparedStatement.setDouble(2, rangesScores.getEnd());
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Student student = new Student(resultSet);
					listStudent.add(student);
				}
			} else {
				System.out.println("|ERROR: NOT CONNECTED TO DB YET!");
			}
		} catch (SQLException e) {
			System.out.println("|ERROR: Get student by score range - SQL Error: " + e.getMessage());
		} finally {
			DBConnection.close();
		}
		return listStudent;
	}
	
	public ArrayList<Student> getListStudentByScore(Double score) {
		ArrayList<Student> listStudent = new ArrayList<Student>();
		try {
			if (DBConnection.open()) {
				PreparedStatement preparedStatement = DBConnection.getConnection()
						.prepareStatement(SQL_GET_STUDENT_BY_SCORE);
				preparedStatement.setDouble(1, score);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Student student = new Student(resultSet);
					listStudent.add(student);
				}
			} else {
				System.out.println("|ERROR: NOT CONNECTED TO DB YET!");
			}
		} catch (SQLException e) {
			System.out.println("|ERROR: Get student by score - SQL Error: " + e.getMessage());
		} finally {
			DBConnection.close();
		}
		return listStudent;
	}

	public boolean addNewStudent(Student student) {
		try {
			if (DBConnection.open()) {
				PreparedStatement preparedStatement = DBConnection.getConnection()
						.prepareStatement(SQL_ADD_NEW_STUDENT);
				preparedStatement.setString(1, student.getMssv());
				preparedStatement.setString(2, student.getFullname());
				preparedStatement.setInt(3, student.getAge());
				preparedStatement.setString(4, student.getPhone());
				preparedStatement.setString(5, student.getAddress());
				preparedStatement.setDouble(6, student.getScore());
				preparedStatement.executeUpdate();
				return true;
			} else {
				System.out.println("|ERROR: NOT CONNECTED YET!");
				return false;
			}
		} catch (SQLException e) {
			System.out.println("|ERROR:  Add a new student - " + e.getMessage());
			return false;
		} finally {
			DBConnection.close();
		}
	}

	public boolean updateStudent(Student student) {
		try {
			if(DBConnection.open()) {
				PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SQL_UPDATE_STUDENT);
				preparedStatement.setString(1, student.getFullname());
				preparedStatement.setInt(2, student.getAge());
				preparedStatement.setString(3, student.getPhone());
				preparedStatement.setString(4, student.getAddress());
				preparedStatement.setDouble(5, student.getScore());
				preparedStatement.setString(6, student.getMssv());
				preparedStatement.executeUpdate();
				return true;
			}else {
				System.out.println("|ERROR: Not connected to Database yet.");
				return false;
			}
		}catch(SQLException e) {
			System.out.println("|ERROR: Update student - SQL - ERROR: " + e.getMessage());
			return false;
		}finally {
			DBConnection.close();
		}
	}
	
	public boolean deleteStudentByMSSV(String mssv) {
		try {
			if(DBConnection.open()) {
				PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SQL_DELETE_STUDENT_BY_MSSV);
				preparedStatement.setString(1, mssv);
				preparedStatement.executeUpdate();
				return true;
			}else {
				System.out.println("|ERROR: Check the connection!");
				return false;
			}
		}catch(SQLException e) {
			System.out.println("|ERROR: Delete student by mssv - error: " + e.getMessage());
			return false;
		}finally {
			DBConnection.close();
		}
	}

	
}
