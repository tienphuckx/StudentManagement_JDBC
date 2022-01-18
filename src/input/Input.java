package input;

import java.util.Scanner;

public class Input {
	private Scanner scanner;
	public Input() {
		scanner = new Scanner(System.in);
	}
	public String getInputMSSV() {
		System.out.print("|>>>>> Input MSSV: ");
		String mssv = scanner.nextLine();
		return mssv;
	}
}
