package validate;

public class Validate {
	private Error error;
	public Validate() {
		error = new Error();
	}
	public boolean checkMSSV(String mssv) {
		if(mssv != null) {
			if(mssv.length() < 30) {
				return true;
			}else {
				System.out.println("|ERROR: MSSV CAN NOT OVER 30 LENGTH.");
				System.out.println("|");
				return false;
			}
		}else {
			System.out.println("|ERROR: MSSV CAN NOT BE NULL.");
			System.out.println("|");
			return false;
		}
	}
}
