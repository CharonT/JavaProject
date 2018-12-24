package QuanLyKhachSan;
import java.sql.*;
import java.util.Scanner;
public class Conection {
	static Connection conn;
	static PreparedStatement ptmt;
	static ResultSet rs;

	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// kết nối

			conn = null;
			String url = "jdbc:mysql://localhost:3306/mhospital?useUnicode=true&amp;characterEncoding=UTF-8";
			String userName = "root";
			String passWord = "1234";
			conn = DriverManager.getConnection(url, userName, passWord);

			// insertAdmin

//			insertAdmin();
			
			//Show
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Lỗi : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
//	 Conection() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//
//			// kết nối
//
//			conn = null;
//			String url = "jdbc:mysql://localhost:3306/mhospital";
//			String userName = "root";
//			String passWord = "1234";
//			conn = DriverManager.getConnection(url, userName, passWord);
//
//			// insertAdmin
//
////			insertAdmin();
//			
//			//Show
//			
//			displayAdmin();
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Lỗi : " + e.getMessage());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
	public void insertAdmin() {
		Scanner sc = new Scanner(System.in);
		String sql = "insert into admin(username,password) values(?,?)";
		String userName;
		String passWord;
		String choose;
		while (true) {
			System.out.println("Nhập username : ");
			userName = sc.nextLine();
			System.out.println("Nhập password : ");
			passWord = sc.nextLine();
			try {
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, userName);
				ptmt.setString(2, passWord);
				int check = ptmt.executeUpdate();
				if (check != 0)
					System.out.println("Succes");
				ptmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Choose");
			choose = sc.nextLine();

			if (choose.equalsIgnoreCase("n"))
				break;

		}
		
	}
	public void displayAdmin() {
		String sql="select * from admin";
		try {
			ptmt=conn.prepareStatement(sql);
			rs=ptmt.executeQuery();
			
			System.out.println("\tUserName " + "\tPassWord");
			
			boolean check=rs.absolute(1);
			if(check==true)
			{
				System.out.println("\t"+rs.getString("username")+"\t"+rs.getString("password"));
			}
			
			rs.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	

}
