package connected;

import java.sql.*;

public class DBConnection {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/phuc_student_management";
	private static Connection con = null;

	public static boolean open() {
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, "root", "Ciri@2001");
			return true;
		} catch (Exception e) {
			System.out.println(">>>>> SQL ERROR: " + e.getMessage());
			return false;
		}
	}

	public static Connection getConnection() {
		if (con == null) {
			open();
		}
		return con;
	}

	public static void close() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(">>>>> SQL Error:" + e.getMessage());
			}
		}
	}

	public static void testDB() {
		Connection con = DBConnection.getConnection();
		if (con != null) {
			System.out.println(">>>>>> Welcome to Database!");
		} else {
			System.out.println(">>>>>> Connect FAILED!");
		}
	}

	public static void main(String[] args) {
		testDB();
	}
}
