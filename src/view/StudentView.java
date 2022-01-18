package view;

import java.util.ArrayList;
import java.util.Scanner;

import input.Input;
import model.RangesScores;
import model.Student;
import validate.Validate;

public class StudentView {
	private Scanner scanner;
	private Validate validate;
	private Input input;
	
	public StudentView() {
		scanner = new Scanner(System.in);
		validate = new Validate();
		input = new Input();
	}
	
	
	
	public void showAllStudent(ArrayList<Student> listStudents) {
		System.out.println("|-----------------------------LIST ALL STUDENT");
		
		for (Student student : listStudents) {
			System.out.println("|>>>>> "+student);
		}
	}
	
	public void showAllStudentByScore(ArrayList<Student> listStudents) {
		System.out.println("|-----------------------------LIST ALL STUDENT BY SCORE");
		
		for (Student student : listStudents) {
			System.out.println("|>>>>> "+student);
		}
	}

	public Student addNewStudent() {
		System.out.println("|------------------------------ADD A NEW STUDENT");
		
		System.out.print("|>>>>> Input MSSV: ");
		String mssv = scanner.nextLine();
		
		
		System.out.print("|>>>>> Input Fullname: ");
		String fullname = scanner.nextLine();
		
		System.out.print("|>>>>> Input Age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("|>>>>> Input Phone: ");
		String phone = scanner.nextLine();
		
		System.out.print("|>>>>> Input Address: ");
		String address = scanner.nextLine();
		
		System.out.print("|>>>>> Input Score: ");
		double score = scanner.nextDouble();
		scanner.nextLine();
		Student student = new Student(mssv, fullname, age, phone, address, score);
		return student;
	}

	public Student updateStudent() {
		System.out.println("|---------------------------UPDATE A NEW STUDENT");
		
		System.out.print("|>>>>> Input MSSS: ");
		String mssv = scanner.nextLine();
		
		System.out.print("|>>>>> Input Fullname: ");
		String fullname = scanner.nextLine();
		
		System.out.print("|>>>>> Input Age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("|>>>>> Input Phone: ");
		String phone = scanner.nextLine();
		
		System.out.print("|>>>>> Input Address: ");
		String address = scanner.nextLine();
		
		System.out.print("|>>>>> Input Score: ");
		double score = scanner.nextDouble();
		scanner.nextLine();
		Student student = new Student(mssv, fullname, age, phone, address, score);
		return student;
	}
	
	public double getListStudentByScore(){
		System.out.println("|-----------------------GET LIST STUDENT BY MSSV");
		
		System.out.print("|>>>>> Input Score: ");
		double score = scanner.nextDouble();
		return score;
	}
	
	public String deleteStudentByMssv() {
		System.out.println("|-----------------------DELETE A NEW STUDENT BY MSSV");
		
		System.out.print("|>>>>> Input MSSS: ");
		String mssv = scanner.nextLine();
		return mssv;
	}
	
	public RangesScores getListStudentByRangesScores() {
		System.out.println("|------------------------GET LIST STUDENT BY RANGES SCORES");
		
		System.out.print("|>>>>> Input Begin Scores: ");
		double begin = scanner.nextDouble();
		
		System.out.print("|>>>>> Input End Scores: ");
		double end = scanner.nextDouble();
		
		RangesScores rangesScores = new RangesScores(begin, end);
		return rangesScores;
	}
}
