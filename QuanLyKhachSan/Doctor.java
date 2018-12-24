package QuanLyKhachSan;

import java.util.Date;

public class Doctor extends Employee{
	private String blood;
	private String dept;
	private String email;
	private String room;
	private String userName;
	private String password;
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Doctor(int count, Date date, String iD, String name, int age,
			String gender, String address, String phone, String status,
			String blood, String dept, String email, String room,
			String userName, String password) {
		super(count, date, iD, name, age, gender, address, phone, status);
		this.blood = blood;
		this.dept = dept;
		this.email = email;
		this.room = room;
		this.userName = userName;
		this.password = password;
	}

	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
