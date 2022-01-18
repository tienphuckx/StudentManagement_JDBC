package main;

import java.util.Scanner;

import controller.StudentController;

public class StudentManagerMain {

	public static void showMenu() {
		System.out.println("|-------------------------------------------------------------");
		System.out.println("|	STUDENT MANAGER");
		System.out.println("|");
		System.out.println("|	1. Get list All Student.");
		System.out.println("|	2. Add a new Student.");
		System.out.println("|	3. Update Student by MSSV.");
		System.out.println("|	4. Delete Student By MSSV.");
		System.out.println("|	5. Get list Student By Score.");
		System.out.println("|	6. Get list Student By Ranges Scores.");
		System.out.println("|	7. Exit program.");
		System.out.println("|");
	
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentController studentController = new StudentController();
		
		boolean status = true;
		while(status) {
			showMenu();
			System.out.print("|YOUR OPTION: ");
			int option = scanner.nextInt();
			scanner.nextLine();
			switch (option) {
			case 1:
				studentController.showAllStudent();
				break;
			case 2:
				studentController.addNewStudent();
				break;
			case 3:
				studentController.updateStudent();
				break;
			case 4:
				studentController.deleteStudentByMSSV();
				break;
			case 5:
				studentController.getListStudentByScore();
				break;
			case 6:
				studentController.getListStudentByRangesScores();
				break;
			case 7:
				System.out.println(">>>>> GOODBYE!");
				status = false;
			}
		}
	}

}
