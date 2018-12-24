package QuanLyKhachSan;

import java.util.Date;

public class Patient extends Employee {
	private String disease;
	private int room;
	public Patient(int count, Date date, String iD, String name, int age,
			String gender, String address, String phone, String status,
			 String disease, int room) {
		super(count, date, iD, name, age, gender, address, phone, status);
		this.disease = disease;
		this.room = room;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	
	

}
