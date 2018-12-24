package QuanLyKhachSan;

import java.util.Date;

public class Receptionist extends Employee{
	private String blood;
	private String email;
	private String userName;
	private String password;
	public Receptionist(int count, Date date, String iD, String name, int age,
			String gender, String address, String phone, String status,
			String blood, String email, String userName, String password) {
		super(count, date, iD, name, age, gender, address, phone, status);
		this.blood = blood;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
