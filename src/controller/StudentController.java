package controller;

import java.util.ArrayList;

import dao.StudentDao;
import error.Error;
import model.RangesScores;
import model.Student;
import success.Success;
import view.StudentView;

public class StudentController {
	private StudentDao studentDao;
	private StudentView studentView;
	private Error error;
	private Success success;
	
	public StudentController() {
		studentDao = new StudentDao();
		studentView = new StudentView();
		error = new Error();
		success = new Success();
	}
	
	public void showAllStudent() {
		ArrayList<Student> listStudents = new ArrayList<Student>();
		listStudents = studentDao.getAllStudent();
		if(listStudents != null && !listStudents.isEmpty()) {
			studentView.showAllStudent(listStudents);
		}else {
			error.arrayListStudentIsNull();
		}
		
	}
	
	public void addNewStudent() {
		Student student = studentView.addNewStudent();
		if(student != null) {
			studentDao.addNewStudent(student);
			success.addNewStudentSuccess();
		}else {
			error.studentIsNull();
		}
	}

	public void updateStudent() {
		Student student = studentView.updateStudent();
		if(student != null) {
			studentDao.updateStudent(student);
			success.updateStudentSuccess();
		}else {
			error.studentIsNull();
		}
	}
	
	public void deleteStudentByMSSV() {
		String mssv = studentView.deleteStudentByMssv();
		if(mssv != null) {
			studentDao.deleteStudentByMSSV(mssv);
			success.deleteStudentSuccess();
		}else {
			error.mssvIsNull();
		}
	}
	
	public void getListStudentByScore() {
		double score = studentView.getListStudentByScore();
		if(score > 0) {
			ArrayList<Student> listStudents = studentDao.getListStudentByScore(score);
			if(listStudents != null && !listStudents.isEmpty()) {
				studentView.showAllStudentByScore(listStudents);
			}else {
				error.arrayListStudentIsNull();
			}
		}
	}
	
	public void getListStudentByRangesScores() {
		RangesScores rangesScores = studentView.getListStudentByRangesScores();
		if(rangesScores != null) {
			ArrayList<Student> listStudents = studentDao.getListStudentByRangesScore(rangesScores);
			if(listStudents != null && !listStudents.isEmpty()) {
				studentView.showAllStudentByScore(listStudents);
			}else {
				error.arrayListStudentIsNull();
			}
		}
	}
	
}
