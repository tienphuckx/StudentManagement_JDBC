package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
	private String mssv;
	private String fullname;
	private int age;
	private String phone;
	private String address;
	private double score;
	
	public Student(ResultSet resultSet) {
		try {
			this.mssv = resultSet.getString("mssv");
			this.fullname = resultSet.getString("fullname");
			this.age = resultSet.getInt("age");
			this.phone = resultSet.getString("phone");
			this.address = resultSet.getString("address");
			this.score = resultSet.getDouble("scode");
		} catch (SQLException e) {
			System.out.println("ERROR: Student - ResultSet Error: " + e.getMessage());
		}
	}
	
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "[mssv=" + mssv + ", fullname=" + fullname + ", age=" + age + ", phone=" + phone + ", address="
				+ address + ", score=" + score + "]";
	}
	public Student(String mssv, String fullname, int age, String phone, String address, double score) {
		super();
		this.mssv = mssv;
		this.fullname = fullname;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.score = score;
	}
	public Student() {
		super();
	}
	
	
	
}
