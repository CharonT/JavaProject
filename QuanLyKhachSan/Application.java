package QuanLyKhachSan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Application {

	private int checkSql;
	private int checkPn;
	private JFrame frame;
	private JPanel pnLoginAdmin;
	private JPasswordField pfPassWord;
	private Conection con;
	private JTextField tfUserName;
	private JPanel pnAP;
	private JPanel pnPatient;
	private JPanel pnUpdatePatient;
	private JPanel pnDeletePatient;
	private JPanel pnSearchPatient;
	private JPanel pnDoctor;
	private JPanel pnAddDoc;
	private JPanel pnDeleteDoc;
	private JPanel pnSearchDoc;
	private JPanel pnRecept;
	private JPanel pnAddRecept;
	private JPanel pnViewRecept;
	private JPanel pnUpdateRecept;
	private JPanel pnSearchRecept;
	private JPanel pnDeleteRecept;
	private JPanel pnLoginDoctor;
	private JPanel pnAD;
	private JPanel pnLoginRecept;
	private JPanel pnAR;
	private JTextField tfDatePatient;
	private JTextField tfIDPatient;
	private JTextField tfNamePatient;
	private JTextField tfAgePatient;
	private JTextField tfAddressPatient;
	private JTextField tfPhoneNumberPatient;
	private JTextField tfDiseaseNamePatient;
	private JTextField tfRoomPatient;
	private JPanel pnAddPatient;
	private JPanel pnViewPatient;
	private JPanel pnViewDoc;
	private JPanel pnUpdateDoc;
	private JPanel pnPatientAP;
	private JPanel pnSetApmt;
	private JPanel pnSetApmt2;
	private JPanel pnAppointment;

	private Vector title;
	private Vector dataRow;
	private Vector data;
	private Vector<Employee> listEmp;
	private DefaultTableModel dtm;
	private JTable tbViewPatient;
	private JTable tbUpdatePatient;
	private JTable tbDeletePatient;
	private JTextField tfNameDeletePatient;
	private JTable tbSearchPatient;
	private JTextField tfNameSearchPatient;
	private JTextField tfDateDoc;
	private JTextField tfIDDoc;
	private JTextField tfNameDoc;
	private JTextField tfAgeDoc;
	private JTextField tfAddressDoc;
	private JTextField tfPhoneDoc;
	private JTextField tfRoomDoc;
	private JLabel lbAgeDoc;
	private JTextField tfBloodDoc;
	private JTextField tfUsernameDoc;
	private JTextField tfPasswordDoc;

	private JComboBox cbDeptDoc;
	private JComboBox cbGenderDoc;
	private JComboBox cbStatusDoc;
	private JComboBox cbDepartApmt;
	private JTextField tfEmailDoc;
	private JTable tbViewDoc;
	private JTable tbUpdateDoc;
	private JTextField tfNameOfDoctor;
	private JTable tbDeleteDoc;
	private JTextField tfNameSearchDoc;
	private JTable tbSearchDoc;
	private JTextField tfDateRecept;
	private JTextField tfIDRecept;
	private JTextField tfNameRecept;
	private JTextField tfAgeRecept;
	private JTextField tfAddressRecept;
	private JTextField tfPhoneRecept;
	private JTextField tfBloodRecept;
	private JTextField tfUsernameRecept;
	private JTextField tfPasswordRecept;
	private JTextField tfEmailRecept;
	private JTable tbUpdateRecept;
	private JTable tbViewRecept;
	private JTextField tfNameOfRecept;
	private JLabel lbSearchRecept;
	private JTable tbSearchRecept;
	private JTextField tfNameDeleteRecept;
	private JTable tbDeleteRecept;
	private JTextField tfUsernameLgDoc;
	private JPasswordField pfPasswordLgDoc;
	private JTextField tfUsernameLgRecept;
	private JPasswordField pfPasswordLgRecept;
	private JLabel lblWelcomeToReception;
	private JTextField tfNamePatientAP;
	private JTable tbPatientAP;
	private JTable tbDocApmt;
	private JTextField tfNamePatientApmt;
	private JTable tbPatientApmt;
	private JTable tbViewAppointment;

	// public static Employee setEmployee(Employee emp) {
	//
	// if(emp.getClass()==Patient.class) {
	//
	//
	//
	//
	// }
	//
	//
	//
	//
	//
	//
	// return null;
	// }
	private Date getDate(String date) {

		String[] cutString = date.split("-");
		int day = Integer.parseInt(cutString[0]);
		int mon = Integer.parseInt(cutString[1]);
		int year = Integer.parseInt(cutString[2]);

		return new Date(year - 1900, mon - 1, day);
	}
	private String dateToString(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(d);

	}

	// private void setTitle1() {
	// //"Serial No", "Date", "Id", "Name", "Age", "Gender", "Address", "Phone
	// Number", "Status", "Disease", "Room"
	// title=new Vector();
	// title.add("Serial No");
	// title.add("Date");
	// title.add("Id");
	// title.add("Name");
	// title.add("Age");
	// title.add("Gender");
	// title.add("Address");
	// title.add("Phone Number");
	// title.add("Status");
	// title.add("Disease");
	// title.add("Room");
	//
	//
	// }
	private JTable setDataTable() {
		JTable temp = null;
		con.connect();
		String sql;
		data = new Vector();

		try {

			if (pnViewPatient.isVisible()) {
				sql = "select * from patient";
				con.ptmt = con.conn.prepareStatement(sql);
				con.rs = con.ptmt.executeQuery();
				// int count;
				// String date;
				// String id;
				// String name;
				// int age;
				// String gender;
				// String address;
				// String phone;
				// String status;
				// String disease;
				// int room;
				// while(con.rs.next()) {
				// dataRow=new Vector();
				// count=con.rs.getInt("count");
				// date=con.rs.getString("date");
				// id=con.rs.getString("id");
				// name=con.rs.getString("name");
				// age=con.rs.getInt("age");
				// gender=con.rs.getString("gender");
				// address=con.rs.getString("address");
				// phone=con.rs.getString("phone");
				// status=con.rs.getString("status");
				// disease=con.rs.getString("disease");
				// room=con.rs.getInt("room");
				// dataRow.add(count);
				// dataRow.add(date);
				// dataRow.add(id);
				// dataRow.add(name);
				// dataRow.add(age);
				// dataRow.add(gender);
				// dataRow.add(address);
				// dataRow.add(phone);
				// dataRow.add(status);
				// dataRow.add(disease);
				// dataRow.add(room);
				// Date d=getDate(date);
				// Employee emp=new
				// Patient(count,d,id,name,age,gender,address,phone,status,disease,room);
				// data.add(dataRow);
				// listEmp.add(emp);
				//
				// }

				tbViewPatient.setModel(DbUtils.resultSetToTableModel(con.rs));
				temp = tbViewPatient;
				con.ptmt.close();
			}
			if (pnUpdatePatient.isVisible()) {
				sql = "select * from patient";
				con.ptmt = con.conn.prepareStatement(sql);
				con.rs = con.ptmt.executeQuery();
				tbUpdatePatient.setModel(DbUtils.resultSetToTableModel(con.rs));
				temp = tbUpdatePatient;
				con.ptmt.close();
			}
			if (pnDeletePatient.isVisible()) {
				sql = "select * from patient";
				con.ptmt = con.conn.prepareStatement(sql);
				con.rs = con.ptmt.executeQuery();
				tbDeletePatient.setModel(DbUtils.resultSetToTableModel(con.rs));
				temp = tbDeletePatient;
				con.ptmt.close();
			}
			if (pnViewDoc.isVisible()) {
				con.ptmt = con.conn.prepareStatement("select * from doctor");
				con.rs = con.ptmt.executeQuery();
				tbViewDoc.setModel(DbUtils.resultSetToTableModel(con.rs));
				temp = tbViewDoc;
				con.ptmt.close();

			}
			if (pnUpdateDoc.isVisible()) {
				con.ptmt = con.conn.prepareStatement("select * from doctor");
				con.rs = con.ptmt.executeQuery();
				tbUpdateDoc.setModel(DbUtils.resultSetToTableModel(con.rs));
				temp = tbUpdateDoc;
				con.ptmt.close();
			}
			if (pnDeleteDoc.isVisible()) {
				con.ptmt = con.conn.prepareStatement("select * from doctor");
				con.rs = con.ptmt.executeQuery();
				tbDeleteDoc.setModel(DbUtils.resultSetToTableModel(con.rs));
				temp = tbDeleteDoc;
				con.ptmt.close();
			}
			if (pnViewRecept.isVisible()) {
				con.ptmt = con.conn
						.prepareStatement("select * from receptionist");
				con.rs = con.ptmt.executeQuery();
				tbViewRecept.setModel(DbUtils.resultSetToTableModel(con.rs));
				temp = tbViewRecept;
				con.ptmt.close();

			}
			if (pnUpdateRecept.isVisible()) {
				con.ptmt = con.conn
						.prepareStatement("select * from receptionist");
				con.rs = con.ptmt.executeQuery();
				tbUpdateRecept.setModel(DbUtils.resultSetToTableModel(con.rs));
				temp = tbUpdateRecept;
				con.ptmt.close();

			}
			if (pnDeleteRecept.isVisible()) {
				con.ptmt = con.conn
						.prepareStatement("select * from receptionist");
				con.rs = con.ptmt.executeQuery();
				tbDeleteRecept.setModel(DbUtils.resultSetToTableModel(con.rs));
				temp = tbDeleteRecept;
				con.ptmt.close();
			}
			if (pnPatientAP.isVisible()) {
				con.ptmt = con.conn.prepareStatement("select * from patient");
				con.rs = con.ptmt.executeQuery();
				tbPatientAP.setModel(DbUtils.resultSetToTableModel(con.rs));
				temp = tbPatientAP;
				con.ptmt.close();
			}
			if (pnSetApmt.isVisible()) {
				con.ptmt = con.conn.prepareStatement("select * from doctor");
				con.rs = con.ptmt.executeQuery();
				con.rs.last();
				tbDocApmt.setModel(DbUtils.resultSetToTableModel(con.rs));
				temp = tbDocApmt;
				con.ptmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;

	}
	private boolean update(JTable table, int row, int col) {
		table.editCellAt(row, col);
		con.connect();
		int check;
		try {
			if (pnUpdatePatient.isVisible() || pnPatientAP.isVisible()) {
				String sql = "update patient set ";
				sql += table.getColumnName(table.getEditingColumn())
						+ "=? where count =?";
				con.ptmt = con.conn.prepareStatement(sql);
				con.ptmt.setObject(1, table.getValueAt(row, col));
				con.ptmt.setObject(2, table.getValueAt(row, 0));
				check = con.ptmt.executeUpdate();
				if (check == 0)
					return false;
				con.ptmt.close();
			}
			if (pnUpdateDoc.isVisible()) {
				String sql = "update doctor set ";
				sql += table.getColumnName(table.getEditingColumn())
						+ "=? where count=?";
				con.ptmt = con.conn.prepareStatement(sql);
				con.ptmt.setObject(1, table.getValueAt(row, col));
				con.ptmt.setObject(2,
						table.getValueAt(table.getEditingRow(), 0));
				check = con.ptmt.executeUpdate();
				if (check == 0)
					return false;
				con.ptmt.close();

			}
			if (pnUpdateRecept.isVisible()) {
				String sql = "update receptionist set ";
				sql += table.getColumnName(table.getEditingColumn())
						+ "=? where count=?";
				con.ptmt = con.conn.prepareStatement(sql);
				con.ptmt.setObject(1, table.getValueAt(row, col));
				con.ptmt.setObject(2,
						table.getValueAt(table.getEditingRow(), 0));
				check = con.ptmt.executeUpdate();
				if (check == 0)
					return false;
				con.ptmt.close();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;

	}
	private void delete(String name) {
		con.connect();
		try {
			if (pnDeletePatient.isVisible() || pnPatientAP.isVisible()) {
				con.ptmt = con.conn
						.prepareStatement("delete from patient where name=?");
				con.ptmt.setString(1, name);
				con.ptmt.executeUpdate();
				con.ptmt.close();

			}
			if (pnDeleteDoc.isVisible()) {
				con.ptmt = con.conn
						.prepareStatement("delete from doctor where name=?");
				con.ptmt.setString(1, name);
				con.ptmt.executeUpdate();
				con.ptmt.close();

			}
			if (pnDeleteRecept.isVisible()) {

				con.ptmt = con.conn.prepareStatement(
						"delete from receptionist where name=?");
				con.ptmt.setString(1, name);
				con.ptmt.executeUpdate();
				con.ptmt.close();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void deleteModel(JTable table, String name) {
		int check = 0;
		DefaultTableModel dtm = new DefaultTableModel();
		if (pnDeletePatient.isVisible() || pnPatientAP.isVisible()) {
			dtm = (DefaultTableModel) table.getModel();
			check = dtm.getRowCount();
			for (int i = 0; i < table.getRowCount(); i++) {
				if (table.getValueAt(i, 3).equals(name)) {
					delete(name);
					dtm.removeRow(i);
				}

			}
		}
		if (pnDeleteDoc.isVisible()) {
			dtm = (DefaultTableModel) table.getModel();
			check = dtm.getRowCount();
			for (int i = 0; i < table.getRowCount(); i++) {
				if (table.getValueAt(i, 3).equals(name)) {
					delete(name);
					dtm.removeRow(i);
				}

			}

		}
		if (pnDeleteRecept.isVisible()) {
			dtm = (DefaultTableModel) table.getModel();
			check = dtm.getRowCount();
			for (int i = 0; i < table.getRowCount(); i++) {
				if (table.getValueAt(i, 3).equals(name)) {
					delete(name);
					dtm.removeRow(i);
				}
			}

		}
		if (check != dtm.getRowCount())
			JOptionPane.showConfirmDialog(pnDeletePatient, "Delete Success", "",
					JOptionPane.DEFAULT_OPTION);
		else
			JOptionPane.showConfirmDialog(pnDeletePatient, "Delete Not Success",
					"", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE);

	}
	public void search(JTable table, JTextField tf) {
		con.connect();

		try {
			if (pnSearchPatient.isVisible()) {
				String name = tf.getText();
				con.ptmt = con.conn.prepareStatement(
						"select * from patient where name like ?");
				con.ptmt.setString(1, name);
				con.rs = con.ptmt.executeQuery();
				if (!con.rs.next())
					JOptionPane.showConfirmDialog(pnSearchPatient, "Not Found",
							"", JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE);
				con.rs.beforeFirst();
				table.setModel(DbUtils.resultSetToTableModel(con.rs));
				con.rs.close();
				con.ptmt.close();
			}
			if (pnSearchDoc.isVisible()) {
				con.ptmt = con.conn
						.prepareStatement("select * from doctor where name=?");
				con.ptmt.setString(1, tf.getText());
				con.rs = con.ptmt.executeQuery();
				if (!con.rs.next())
					JOptionPane.showConfirmDialog(pnSearchPatient, "Not Found",
							"", JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE);
				con.rs.beforeFirst();
				table.setModel(DbUtils.resultSetToTableModel(con.rs));
				con.rs.close();
				con.ptmt.close();

			}
			if (pnSearchRecept.isVisible()) {
				con.ptmt = con.conn.prepareStatement(
						"select * from receptionist where name =?");
				con.ptmt.setString(1, tf.getText());
				con.rs = con.ptmt.executeQuery();
				if (!con.rs.next())
					JOptionPane.showConfirmDialog(pnSearchPatient, "Not Found",
							"", JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE);
				con.rs.beforeFirst();
				table.setModel(DbUtils.resultSetToTableModel(con.rs));
				con.rs.close();
				con.ptmt.close();

			}
			if (pnSetApmt2.isVisible()) {
				String name = tf.getText();
				con.ptmt = con.conn.prepareStatement(
						"select * from patient where name like ?");
				con.ptmt.setString(1, name);
				con.rs = con.ptmt.executeQuery();
				if (!con.rs.next())
					JOptionPane.showConfirmDialog(pnSearchPatient, "Not Found",
							"", JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE);
				con.rs.beforeFirst();
				table.setModel(DbUtils.resultSetToTableModel(con.rs));
				con.rs.close();
				con.ptmt.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public Application() {
		listEmp = new Vector<Employee>();
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1076, 609);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel pnAdmin = new JPanel();
		frame.getContentPane().add(pnAdmin, "name_9235051444600");
		pnAdmin.setLayout(null);

		JLabel lbTitle = new JLabel("Hospital Management System");
		lbTitle.setOpaque(true);
		lbTitle.setForeground(new Color(255, 255, 255));
		lbTitle.setBackground(new Color(0, 51, 204));
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbTitle.setBounds(26, 11, 779, 57);
		pnAdmin.add(lbTitle);

		JLabel lbLogin = new JLabel("Login As");
		lbLogin.setOpaque(true);
		lbLogin.setBackground(new Color(0, 255, 255));
		lbLogin.setForeground(new Color(255, 255, 255));
		lbLogin.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLogin.setBounds(26, 108, 144, 46);
		pnAdmin.add(lbLogin);

		JLabel lbWelcome = new JLabel("Welcome to Mini Hospital");
		lbWelcome.setOpaque(true);
		lbWelcome.setBackground(new Color(0, 51, 204));
		lbWelcome.setForeground(new Color(255, 255, 255));
		lbWelcome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lbWelcome.setBounds(0, 176, 204, 210);
		pnAdmin.add(lbWelcome);

		JButton btAdmin = new JButton("Admin");
		btAdmin.setHorizontalTextPosition(SwingConstants.CENTER);
		btAdmin.setVerticalTextPosition(SwingConstants.BOTTOM);
		btAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnAdmin.setVisible(false);
				pnLoginAdmin.setVisible(true);

			}
		});
		btAdmin.setOpaque(true);
		btAdmin.setBackground(Color.GRAY);
		btAdmin.setForeground(Color.WHITE);

		Image imgAdmin = new ImageIcon(
				this.getClass().getResource("/admin.png")).getImage()
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		btAdmin.setIcon(new ImageIcon(imgAdmin));
		btAdmin.setBounds(225, 191, 124, 111);
		pnAdmin.add(btAdmin);

		JButton btDoctor = new JButton("Doctor");
		btDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnAdmin.setVisible(false);
				pnLoginDoctor.setVisible(true);
			}
		});
		btDoctor.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\doctor.png"));
		btDoctor.setVerticalTextPosition(SwingConstants.BOTTOM);
		btDoctor.setOpaque(true);
		btDoctor.setHorizontalTextPosition(SwingConstants.CENTER);
		btDoctor.setForeground(Color.WHITE);
		btDoctor.setBackground(Color.GRAY);
		btDoctor.setBounds(398, 191, 124, 111);
		pnAdmin.add(btDoctor);

		JButton btReceptionist = new JButton("Receptionist");
		btReceptionist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnAdmin.setVisible(false);
				pnLoginRecept.setVisible(true);

			}
		});
		btReceptionist.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\reception.png"));
		btReceptionist.setVerticalTextPosition(SwingConstants.BOTTOM);
		btReceptionist.setOpaque(true);
		btReceptionist.setHorizontalTextPosition(SwingConstants.CENTER);
		btReceptionist.setForeground(Color.WHITE);
		btReceptionist.setBackground(Color.GRAY);
		btReceptionist.setBounds(574, 191, 124, 111);
		pnAdmin.add(btReceptionist);

		pnLoginAdmin = new JPanel();
		frame.getContentPane().add(pnLoginAdmin, "name_207925250837300");
		pnLoginAdmin.setLayout(null);

		JLabel lbTitle1 = new JLabel("Hospital Management System");
		lbTitle1.setOpaque(true);
		lbTitle1.setForeground(Color.WHITE);
		lbTitle1.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbTitle1.setBackground(Color.BLUE);
		lbTitle1.setBounds(10, 51, 795, 57);
		pnLoginAdmin.add(lbTitle1);

		JLabel lblNewLabel = new JLabel("UserName:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(114, 184, 95, 38);
		pnLoginAdmin.add(lblNewLabel);

		tfUserName = new JTextField();
		tfUserName.setBounds(207, 184, 503, 32);
		pnLoginAdmin.add(tfUserName);
		tfUserName.setColumns(10);

		JLabel lbPassWord = new JLabel("PassWord:");
		lbPassWord.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbPassWord.setBounds(114, 285, 95, 38);
		pnLoginAdmin.add(lbPassWord);

		pfPassWord = new JPasswordField();
		pfPassWord.setEchoChar('*');
		pfPassWord.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pfPassWord.setBounds(207, 285, 503, 38);
		pnLoginAdmin.add(pfPassWord);

		JButton btHome = new JButton("Home");
		btHome.setBackground(Color.CYAN);
		btHome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnAdmin.setVisible(true);
				pnLoginAdmin.setVisible(false);
				tfUserName.setText("");
				pfPassWord.setText("");

			}
		});
		btHome.setBounds(247, 368, 74, 38);
		pnLoginAdmin.add(btHome);

		JButton btLogin = new JButton("Login");
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = new Conection();
				con.connect();
				String userName = tfUserName.getText();
				String passWord = String.valueOf(pfPassWord.getPassword());
				String sql = "select * from admin";
				try {
					con.ptmt = con.conn.prepareStatement(sql);
					con.rs = con.ptmt.executeQuery();
					while (con.rs.next()) {
						// System.out.println(con.rs.getString("username")+con.rs.getString("password"));
						if ((!userName.equals(con.rs.getString("username"))
								|| !passWord
										.equals(con.rs.getString("password")))
								&& pnLoginAdmin.isVisible()) {

							JOptionPane.showConfirmDialog(pnLoginAdmin,
									"Login Not Success", "",
									JOptionPane.DEFAULT_OPTION);

						} else if (userName.equals(con.rs.getString("username"))
								&& passWord
										.equals(con.rs.getString("password"))) {
							int info = JOptionPane.showConfirmDialog(
									pnLoginAdmin, "Login Success", "",
									JOptionPane.DEFAULT_OPTION);
							if (info == JOptionPane.OK_OPTION) {
								pnLoginAdmin.setVisible(false);
								pnAP.setVisible(true);

							}

						}

					}
					con.rs.close();
					con.ptmt.close();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btLogin.setBackground(Color.BLUE);
		btLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btLogin.setBounds(532, 368, 74, 38);
		pnLoginAdmin.add(btLogin);

		pnLoginDoctor = new JPanel();
		frame.getContentPane().add(pnLoginDoctor, "name_163062081874600");
		pnLoginDoctor.setLayout(null);

		JLabel lbTitle2 = new JLabel("Hospital Management System");
		lbTitle2.setOpaque(true);
		lbTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle2.setForeground(Color.WHITE);
		lbTitle2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbTitle2.setBackground(Color.BLUE);
		lbTitle2.setBounds(10, 51, 795, 57);
		pnLoginDoctor.add(lbTitle2);

		JLabel lbUsernameLgDoc = new JLabel("UserName:");
		lbUsernameLgDoc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbUsernameLgDoc.setBounds(114, 184, 95, 38);
		pnLoginDoctor.add(lbUsernameLgDoc);

		tfUsernameLgDoc = new JTextField();
		tfUsernameLgDoc.setColumns(10);
		tfUsernameLgDoc.setBounds(207, 184, 503, 32);
		pnLoginDoctor.add(tfUsernameLgDoc);

		JLabel lbPasswordLgDoc = new JLabel("PassWord:");
		lbPasswordLgDoc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbPasswordLgDoc.setBounds(114, 285, 95, 38);
		pnLoginDoctor.add(lbPasswordLgDoc);

		pfPasswordLgDoc = new JPasswordField();
		pfPasswordLgDoc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pfPasswordLgDoc.setEchoChar('*');
		pfPasswordLgDoc.setBounds(207, 285, 503, 38);
		pnLoginDoctor.add(pfPasswordLgDoc);

		JButton btHomeLgDoc = new JButton("Home");
		btHomeLgDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnLoginDoctor.setVisible(false);
				pnAdmin.setVisible(true);
				tfUsernameLgDoc.setText("");
				pfPasswordLgDoc.setText("");
			}
		});
		btHomeLgDoc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btHomeLgDoc.setBackground(Color.CYAN);
		btHomeLgDoc.setBounds(247, 368, 74, 38);
		pnLoginDoctor.add(btHomeLgDoc);

		JButton btLoginLgDoc = new JButton("Login");
		btLoginLgDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = new Conection();
				con.connect();
				boolean check = false;
				try {
					con.ptmt = con.conn.prepareStatement(
							"select username,password from doctor");
					con.rs = con.ptmt.executeQuery();
					while (con.rs.next()) {
						if (con.rs.getString("username")
								.equals(tfUsernameLgDoc.getText())
								&& con.rs.getString("password")
										.equals(String.valueOf(
												pfPasswordLgDoc.getPassword())))
							check = true;
						if (check == true&&pnLoginDoctor.isVisible()) {
							int info = JOptionPane.showConfirmDialog(
									pnLoginDoctor, "Login Success", "",
									JOptionPane.DEFAULT_OPTION);
							if (info == JOptionPane.OK_OPTION)
								pnLoginDoctor.setVisible(false);
							pnAD.setVisible(true);
						}

					}
					if (!check)
						JOptionPane.showConfirmDialog(pnLoginDoctor,
								"Login Not Success", "",
								JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btLoginLgDoc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btLoginLgDoc.setBackground(Color.BLUE);
		btLoginLgDoc.setBounds(532, 368, 74, 38);
		pnLoginDoctor.add(btLoginLgDoc);

		pnLoginRecept = new JPanel();
		pnLoginRecept.setLayout(null);
		frame.getContentPane().add(pnLoginRecept, "name_20418020526400");

		JLabel tbTitle3 = new JLabel("Hospital Management System");
		tbTitle3.setOpaque(true);
		tbTitle3.setHorizontalAlignment(SwingConstants.CENTER);
		tbTitle3.setForeground(Color.WHITE);
		tbTitle3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tbTitle3.setBackground(Color.BLUE);
		tbTitle3.setBounds(10, 51, 795, 57);
		pnLoginRecept.add(tbTitle3);

		JLabel lbUsernameLgRecept = new JLabel("UserName:");
		lbUsernameLgRecept.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbUsernameLgRecept.setBounds(114, 184, 95, 38);
		pnLoginRecept.add(lbUsernameLgRecept);

		tfUsernameLgRecept = new JTextField();
		tfUsernameLgRecept.setColumns(10);
		tfUsernameLgRecept.setBounds(207, 184, 503, 32);
		pnLoginRecept.add(tfUsernameLgRecept);

		JLabel lbPasswordLgRecept = new JLabel("PassWord:");
		lbPasswordLgRecept.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbPasswordLgRecept.setBounds(114, 285, 95, 38);
		pnLoginRecept.add(lbPasswordLgRecept);

		pfPasswordLgRecept = new JPasswordField();
		pfPasswordLgRecept.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pfPasswordLgRecept.setEchoChar('*');
		pfPasswordLgRecept.setBounds(207, 286, 503, 38);
		pnLoginRecept.add(pfPasswordLgRecept);

		JButton btHomeLgRecept = new JButton("Home");
		btHomeLgRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnLoginRecept.setVisible(false);
				pnAdmin.setVisible(true);
			}
		});
		btHomeLgRecept.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btHomeLgRecept.setBackground(Color.CYAN);
		btHomeLgRecept.setBounds(247, 368, 74, 38);
		pnLoginRecept.add(btHomeLgRecept);

		JButton btLoginLgRecept = new JButton("Login");
		btLoginLgRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = new Conection();
				con.connect();
				boolean check = false;
				try {
					con.ptmt = con.conn.prepareStatement(
							"select username,password from receptionist");
					con.rs = con.ptmt.executeQuery();
					while (con.rs.next()) {
						if (con.rs.getString("username")
								.equals(tfUsernameLgRecept.getText())
								&& con.rs.getString("password").equals(
										String.valueOf(pfPasswordLgRecept
												.getPassword())))
							check = true;
						if (check == true) {
							int info = JOptionPane.showConfirmDialog(
									pnLoginDoctor, "Login Success", "",
									JOptionPane.DEFAULT_OPTION);
							if (info == JOptionPane.OK_OPTION) {
								pnLoginRecept.setVisible(false);
								pnAR.setVisible(true);
							}

						}

					}
					if (!check)
						JOptionPane.showConfirmDialog(pnLoginDoctor,
								"Login Not Success", "",
								JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btLoginLgRecept.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btLoginLgRecept.setBackground(Color.BLUE);
		btLoginLgRecept.setBounds(532, 368, 74, 38);
		pnLoginRecept.add(btLoginLgRecept);

		pnAD = new JPanel();
		pnAD.setLayout(null);
		frame.getContentPane().add(pnAD, "name_2594226353400");

		JLabel lbHMS = new JLabel("Hospital Management System");
		lbHMS.setOpaque(true);
		lbHMS.setHorizontalAlignment(SwingConstants.CENTER);
		lbHMS.setForeground(Color.WHITE);
		lbHMS.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbHMS.setBackground(new Color(0, 51, 204));
		lbHMS.setBounds(26, 11, 779, 57);
		pnAD.add(lbHMS);

		JLabel lbWelcomeDoc = new JLabel("Welcome to Doctor Area");
		lbWelcomeDoc.setOpaque(true);
		lbWelcomeDoc.setHorizontalAlignment(SwingConstants.CENTER);
		lbWelcomeDoc.setForeground(Color.WHITE);
		lbWelcomeDoc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbWelcomeDoc.setBackground(new Color(0, 51, 204));
		lbWelcomeDoc.setBounds(0, 176, 204, 210);
		pnAD.add(lbWelcomeDoc);

		JButton btAptDoc = new JButton("Appointments");
		btAptDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					con.ptmt = con.conn
							.prepareStatement("select * from appointments");
					con.rs = con.ptmt.executeQuery();
//					if (!con.rs.next()) {
//						JOptionPane.showConfirmDialog(pnAD,
//								"Appointment is empty", "",
//								JOptionPane.DEFAULT_OPTION,
//								JOptionPane.ERROR_MESSAGE);
//					}
//					else {
//						tbViewAppointment.setModel(DbUtils.resultSetToTableModel(con.rs));
//						pnAD.setVisible(false);
//						pnAppointment.setVisible(true);
//						
//					}
					tbViewAppointment.setModel(DbUtils.resultSetToTableModel(con.rs));
					pnAD.setVisible(false);
					pnAppointment.setVisible(true);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btAptDoc.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\appointment.png"));
		btAptDoc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btAptDoc.setVerticalTextPosition(SwingConstants.BOTTOM);
		btAptDoc.setOpaque(true);
		btAptDoc.setHorizontalTextPosition(SwingConstants.CENTER);
		btAptDoc.setForeground(Color.WHITE);
		btAptDoc.setBackground(Color.GRAY);
		btAptDoc.setBounds(406, 176, 124, 111);
		pnAD.add(btAptDoc);

		JButton btBackAD = new JButton("");
		btBackAD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnAD.setVisible(false);
				pnAdmin.setVisible(true);
			}
		});
		btBackAD.setBackground(Color.BLUE);
		btBackAD.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackAD.setBounds(802, 11, 89, 57);
		pnAD.add(btBackAD);

		pnAP = new JPanel();
		pnAP.setLayout(null);
		frame.getContentPane().add(pnAP, "name_193927639980400");

		JLabel lbAP = new JLabel("Admin Portal");
		lbAP.setHorizontalAlignment(SwingConstants.CENTER);
		lbAP.setIcon(null);
		lbAP.setOpaque(true);
		lbAP.setHorizontalTextPosition(SwingConstants.CENTER);
		lbAP.setForeground(Color.WHITE);
		lbAP.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbAP.setBackground(new Color(0, 0, 255));
		lbAP.setBounds(26, 11, 711, 57);
		pnAP.add(lbAP);

		JLabel lbWelcomeAP = new JLabel("Welcome to Admin Portal");
		lbWelcomeAP.setOpaque(true);
		lbWelcomeAP.setHorizontalAlignment(SwingConstants.CENTER);
		lbWelcomeAP.setForeground(Color.WHITE);
		lbWelcomeAP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbWelcomeAP.setBackground(new Color(0, 0, 255));
		lbWelcomeAP.setBounds(0, 176, 204, 210);
		pnAP.add(lbWelcomeAP);

		JButton btPatientInfo = new JButton("Patient Info");
		btPatientInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnAP.setVisible(false);
				pnPatient.setVisible(true);
			}
		});
		btPatientInfo.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\patient.png"));
		btPatientInfo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btPatientInfo.setOpaque(true);
		btPatientInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		btPatientInfo.setForeground(Color.WHITE);
		btPatientInfo.setBackground(Color.GRAY);
		btPatientInfo.setBounds(225, 191, 124, 111);
		pnAP.add(btPatientInfo);

		JButton btDoctorInfo = new JButton("Doctor Info");
		btDoctorInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnAP.setVisible(false);
				pnDoctor.setVisible(true);

			}
		});
		btDoctorInfo.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\doctor.png"));
		btDoctorInfo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btDoctorInfo.setOpaque(true);
		btDoctorInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		btDoctorInfo.setForeground(Color.WHITE);
		btDoctorInfo.setBackground(Color.GRAY);
		btDoctorInfo.setBounds(398, 191, 124, 111);
		pnAP.add(btDoctorInfo);

		JButton btnReceptionistInfo = new JButton("Receptionist");
		btnReceptionistInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnAP.setVisible(false);
				pnRecept.setVisible(true);
			}
		});
		btnReceptionistInfo.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\reception.png"));
		btnReceptionistInfo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnReceptionistInfo.setOpaque(true);
		btnReceptionistInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReceptionistInfo.setForeground(Color.WHITE);
		btnReceptionistInfo.setBackground(Color.GRAY);
		btnReceptionistInfo.setBounds(574, 191, 124, 111);
		pnAP.add(btnReceptionistInfo);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBackground(new Color(0, 0, 255));
		Image img = new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png")
						.getImage()
						.getScaledInstance(58, 57, Image.SCALE_DEFAULT);
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setBounds(735, 11, 70, 57);
		pnAP.add(btnNewButton);

		pnAR = new JPanel();
		frame.getContentPane().add(pnAR, "name_26357467125900");
		pnAR.setLayout(null);

		JLabel lbTitle4 = new JLabel("Reception Area");
		lbTitle4.setOpaque(true);
		lbTitle4.setHorizontalTextPosition(SwingConstants.CENTER);
		lbTitle4.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle4.setForeground(Color.WHITE);
		lbTitle4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbTitle4.setBackground(Color.BLUE);
		lbTitle4.setBounds(26, 11, 650, 57);
		pnAR.add(lbTitle4);

		lblWelcomeToReception = new JLabel("Welcome to Reception Area");
		lblWelcomeToReception.setOpaque(true);
		lblWelcomeToReception.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToReception.setForeground(Color.WHITE);
		lblWelcomeToReception.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWelcomeToReception.setBackground(Color.BLUE);
		lblWelcomeToReception.setBounds(0, 79, 272, 210);
		pnAR.add(lblWelcomeToReception);

		JButton btAddPatientAR = new JButton("Add Patient");
		btAddPatientAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnAR.setVisible(false);
				checkPn = 1;
				pnAddPatient.setVisible(true);

			}
		});
		btAddPatientAR.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\addpatient.png"));
		btAddPatientAR.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btAddPatientAR.setVerticalTextPosition(SwingConstants.BOTTOM);
		btAddPatientAR.setOpaque(true);
		btAddPatientAR.setHorizontalTextPosition(SwingConstants.CENTER);
		btAddPatientAR.setForeground(Color.WHITE);
		btAddPatientAR.setBackground(Color.GRAY);
		btAddPatientAR.setBounds(282, 79, 124, 111);
		pnAR.add(btAddPatientAR);

		JButton btUpdatePatientAR = new JButton("Update Patient");
		btUpdatePatientAR.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\updatepatient.png"));
		btUpdatePatientAR.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btUpdatePatientAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnAR.setVisible(false);
				pnPatientAP.setVisible(true);
				setDataTable();
			}
		});
		btUpdatePatientAR.setVerticalTextPosition(SwingConstants.BOTTOM);
		btUpdatePatientAR.setOpaque(true);
		btUpdatePatientAR.setHorizontalTextPosition(SwingConstants.CENTER);
		btUpdatePatientAR.setForeground(Color.WHITE);
		btUpdatePatientAR.setBackground(Color.GRAY);
		btUpdatePatientAR.setBounds(430, 79, 124, 111);
		pnAR.add(btUpdatePatientAR);

		JButton btSetApmt = new JButton("Set Appoitments");
		btSetApmt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnAR.setVisible(false);
				pnSetApmt.setVisible(true);
				setDataTable();
			}
		});
		btSetApmt.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\setappoinment.png"));
		btSetApmt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btSetApmt.setVerticalTextPosition(SwingConstants.BOTTOM);
		btSetApmt.setOpaque(true);
		btSetApmt.setHorizontalTextPosition(SwingConstants.CENTER);
		btSetApmt.setForeground(Color.WHITE);
		btSetApmt.setBackground(Color.GRAY);
		btSetApmt.setBounds(581, 79, 133, 111);
		pnAR.add(btSetApmt);

		JButton btBackAR = new JButton("New button");
		btBackAR.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackAR.setBackground(Color.BLUE);
		btBackAR.setBounds(675, 11, 70, 57);
		pnAR.add(btBackAR);

		pnSetApmt = new JPanel();
		pnSetApmt.setLayout(null);
		frame.getContentPane().add(pnSetApmt, "name_103119776089900");

		JLabel lbTitle6 = new JLabel("Search Doctor");
		lbTitle6.setOpaque(true);
		lbTitle6.setHorizontalTextPosition(SwingConstants.CENTER);
		lbTitle6.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle6.setForeground(Color.WHITE);
		lbTitle6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbTitle6.setBackground(Color.RED);
		lbTitle6.setBounds(26, 11, 859, 57);
		pnSetApmt.add(lbTitle6);

		JButton button_20 = new JButton("New button");
		button_20.setBackground(Color.RED);
		button_20.setBounds(952, 11, 70, 57);
		pnSetApmt.add(button_20);

		JButton btBackSetApmt = new JButton("New button");
		btBackSetApmt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnSetApmt.setVisible(false);
				pnAR.setVisible(true);
			}
		});
		btBackSetApmt.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackSetApmt.setBackground(Color.RED);
		btBackSetApmt.setBounds(883, 11, 70, 57);
		pnSetApmt.add(btBackSetApmt);

		JScrollPane spDocApmt = new JScrollPane();
		spDocApmt.setBounds(26, 216, 1012, 293);
		pnSetApmt.add(spDocApmt);

		tbDocApmt = new JTable();
		spDocApmt.setViewportView(tbDocApmt);

		JLabel lbDepartApmt = new JLabel("DEPARTMENT");
		lbDepartApmt.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDepartApmt.setForeground(new Color(50, 205, 50));
		lbDepartApmt.setFont(new Font("Jokerman", Font.PLAIN, 21));
		lbDepartApmt.setBounds(22, 79, 320, 85);
		pnSetApmt.add(lbDepartApmt);

		JButton btSearchApmt = new JButton("SEARCH");
		btSearchApmt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				con = new Conection();
				con.connect();
				if (pnSetApmt.isVisible()) {
					String depart = (String) cbDepartApmt.getSelectedItem();
					try {
						con.ptmt = con.conn.prepareStatement(
								"select * from doctor where dept=?");
						con.ptmt.setString(1, depart);
						con.rs = con.ptmt.executeQuery();
						if (!con.rs.next())
							JOptionPane.showConfirmDialog(pnSetApmt,
									"Not Found", "", JOptionPane.DEFAULT_OPTION,
									JOptionPane.WARNING_MESSAGE);
						con.rs.beforeFirst();
						tbDocApmt.setModel(
								DbUtils.resultSetToTableModel(con.rs));
						con.ptmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		});
		btSearchApmt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSearchApmt.setBackground(Color.BLUE);
		btSearchApmt.setBounds(910, 98, 89, 52);
		pnSetApmt.add(btSearchApmt);

		JLabel lbMiniTitle = new JLabel("Select a Doctor and Press Next");
		lbMiniTitle.setForeground(Color.BLUE);
		lbMiniTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbMiniTitle.setBounds(53, 188, 269, 14);
		pnSetApmt.add(lbMiniTitle);

		cbDepartApmt = new JComboBox();
		cbDepartApmt.setBackground(Color.BLUE);
		cbDepartApmt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbDepartApmt.setModel(new DefaultComboBoxModel(
				new String[]{"Selected Department", "Medicine", "Microbiology",
						"Dental", "Gynaecology", "Nutrition", "Neurology",
						"Cardiology ", "Haematology"}));
		cbDepartApmt.setBounds(364, 105, 507, 45);
		pnSetApmt.add(cbDepartApmt);

		JButton btNextApmt = new JButton("NEXT");
		btNextApmt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnSetApmt.setVisible(false);
				pnSetApmt2.setVisible(true);

			}
		});
		btNextApmt.setBackground(Color.GREEN);
		btNextApmt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btNextApmt.setBounds(481, 520, 89, 39);
		pnSetApmt.add(btNextApmt);

		pnSetApmt2 = new JPanel();
		frame.getContentPane().add(pnSetApmt2, "name_113032341556600");
		pnSetApmt2.setLayout(null);

		JLabel blTitle7 = new JLabel("Search Patient");
		blTitle7.setOpaque(true);
		blTitle7.setHorizontalTextPosition(SwingConstants.CENTER);
		blTitle7.setHorizontalAlignment(SwingConstants.CENTER);
		blTitle7.setForeground(Color.WHITE);
		blTitle7.setFont(new Font("Tahoma", Font.PLAIN, 24));
		blTitle7.setBackground(Color.RED);
		blTitle7.setBounds(26, 11, 859, 57);
		pnSetApmt2.add(blTitle7);

		JButton button_21 = new JButton("New button");
		button_21.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_21.setBackground(Color.RED);
		button_21.setBounds(952, 11, 70, 57);
		pnSetApmt2.add(button_21);

		JButton btBackSetApmt2 = new JButton("New button");
		btBackSetApmt2.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackSetApmt2.setBackground(Color.RED);
		btBackSetApmt2.setBounds(883, 11, 70, 57);
		pnSetApmt2.add(btBackSetApmt2);

		JScrollPane spPatientApmt = new JScrollPane();
		spPatientApmt.setBounds(10, 188, 1012, 293);
		pnSetApmt2.add(spPatientApmt);

		tbPatientApmt = new JTable();
		spPatientApmt.setViewportView(tbPatientApmt);

		JLabel lbNamePatientApmt = new JLabel("NAME OF PATIENT");
		lbNamePatientApmt.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNamePatientApmt.setForeground(new Color(50, 205, 50));
		lbNamePatientApmt.setFont(new Font("Jokerman", Font.PLAIN, 21));
		lbNamePatientApmt.setBounds(22, 79, 320, 85);
		pnSetApmt2.add(lbNamePatientApmt);

		tfNamePatientApmt = new JTextField();
		tfNamePatientApmt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfNamePatientApmt.setColumns(10);
		tfNamePatientApmt.setBounds(352, 96, 548, 52);
		pnSetApmt2.add(tfNamePatientApmt);

		JButton btSearchPatientApmt = new JButton("SEARCH");
		btSearchPatientApmt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search(tbPatientApmt, tfNamePatientApmt);
			}
		});
		btSearchPatientApmt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSearchPatientApmt.setBackground(Color.BLUE);
		btSearchPatientApmt.setBounds(910, 98, 89, 52);
		pnSetApmt2.add(btSearchPatientApmt);

		JButton btNextApmt2 = new JButton("NEXT");
		btNextApmt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choose = JOptionPane.showConfirmDialog(pnSetApmt2,
						" PATIENT "
								+ (String) tbPatientApmt.getValueAt(
										tbPatientApmt.getSelectedRow(), 3)
								+ " Appointmented with DOCTOR "
								+ (String) tbDocApmt.getValueAt(
										tbDocApmt.getSelectedRow(), 3)
								+ " at room no "
								+ (int) tbDocApmt.getValueAt(
										tbDocApmt.getSelectedRow(), 12),
						"", JOptionPane.DEFAULT_OPTION);
				if (choose == JOptionPane.OK_OPTION) {
					con = new Conection();
					con.connect();
					try {
						con.ptmt = con.conn.prepareStatement(
								"insert into appointments(dName,pName,room) values(?,?,?)");
						con.ptmt.setString(1, (String) tbDocApmt
								.getValueAt(tbDocApmt.getSelectedRow(), 3));
						con.ptmt.setString(2, (String) tbPatientApmt
								.getValueAt(tbPatientApmt.getSelectedRow(), 3));
						con.ptmt.setInt(3, (int) tbDocApmt
								.getValueAt(tbDocApmt.getSelectedRow(), 12));
						con.ptmt.executeUpdate();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		btNextApmt2.setBackground(Color.YELLOW);
		btNextApmt2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btNextApmt2.setBounds(535, 509, 89, 37);
		pnSetApmt2.add(btNextApmt2);

		pnPatientAP = new JPanel();
		frame.getContentPane().add(pnPatientAP, "name_67336389095900");
		pnPatientAP.setLayout(null);

		JLabel lbTitle5 = new JLabel("Patient Management");
		lbTitle5.setOpaque(true);
		lbTitle5.setHorizontalTextPosition(SwingConstants.CENTER);
		lbTitle5.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle5.setForeground(Color.WHITE);
		lbTitle5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbTitle5.setBackground(Color.CYAN);
		lbTitle5.setBounds(47, 11, 841, 57);
		pnPatientAP.add(lbTitle5);

		JButton button_19 = new JButton("New button");
		button_19.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_19.setBackground(Color.CYAN);
		button_19.setBounds(954, 11, 70, 57);
		pnPatientAP.add(button_19);

		JButton btBackPatientAP = new JButton("New button");
		btBackPatientAP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnPatientAP.setVisible(false);
				pnAR.setVisible(true);
			}
		});
		btBackPatientAP.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackPatientAP.setBackground(Color.CYAN);
		btBackPatientAP.setBounds(886, 11, 70, 57);
		pnPatientAP.add(btBackPatientAP);

		JScrollPane spPatientAP = new JScrollPane();
		spPatientAP.setBounds(12, 159, 1012, 259);
		pnPatientAP.add(spPatientAP);

		tbPatientAP = new JTable();
		spPatientAP.setViewportView(tbPatientAP);

		JLabel lbNamePatientAP = new JLabel("NAME OF PATIENT");
		lbNamePatientAP.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNamePatientAP.setForeground(new Color(50, 205, 50));
		lbNamePatientAP.setFont(new Font("Jokerman", Font.PLAIN, 21));
		lbNamePatientAP.setBounds(10, 79, 320, 85);
		pnPatientAP.add(lbNamePatientAP);

		tfNamePatientAP = new JTextField();
		tfNamePatientAP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfNamePatientAP.setColumns(10);
		tfNamePatientAP.setBounds(340, 96, 548, 52);
		pnPatientAP.add(tfNamePatientAP);

		JButton btDeletePatientAP = new JButton("DELETE");
		btDeletePatientAP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteModel(tbPatientAP, tfNamePatientAP.getText());

			}
		});
		btDeletePatientAP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btDeletePatientAP.setBackground(Color.BLUE);
		btDeletePatientAP.setBounds(898, 98, 89, 52);
		pnPatientAP.add(btDeletePatientAP);

		JButton btUpdatePatientAP = new JButton("UPDATE");
		btUpdatePatientAP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean check = update(tbPatientAP, tbPatientAP.getEditingRow(),
						tbPatientAP.getEditingColumn());
				if (check)
					JOptionPane.showConfirmDialog(pnPatientAP, "Update Success",
							"", JOptionPane.DEFAULT_OPTION);
				else
					JOptionPane.showConfirmDialog(pnPatientAP,
							"Update Not Success", "",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.ERROR_MESSAGE);

			}
		});
		btUpdatePatientAP.setBackground(Color.GREEN);
		btUpdatePatientAP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btUpdatePatientAP.setBounds(468, 429, 89, 52);
		pnPatientAP.add(btUpdatePatientAP);
		
		pnAppointment = new JPanel();
		pnAppointment.setLayout(null);
		frame.getContentPane().add(pnAppointment, "name_260798852825400");
		
		JLabel lbTitle7 = new JLabel("View AppointMent");
		lbTitle7.setOpaque(true);
		lbTitle7.setHorizontalTextPosition(SwingConstants.CENTER);
		lbTitle7.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle7.setForeground(Color.WHITE);
		lbTitle7.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbTitle7.setBackground(Color.BLUE);
		lbTitle7.setBounds(26, 11, 701, 57);
		pnAppointment.add(lbTitle7);
		
		JButton button_22 = new JButton("New button");
		button_22.setBackground(Color.BLUE);
		button_22.setBounds(793, 11, 70, 57);
		pnAppointment.add(button_22);
		
		JButton btBackViewAppointment = new JButton("New button");
		btBackViewAppointment.setIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackViewAppointment.setBackground(Color.BLUE);
		btBackViewAppointment.setBounds(724, 11, 70, 57);
		pnAppointment.add(btBackViewAppointment);
		
		JScrollPane spViewAppointment = new JScrollPane();
		spViewAppointment.setBounds(10, 132, 853, 293);
		pnAppointment.add(spViewAppointment);
		
		tbViewAppointment = new JTable();
		spViewAppointment.setViewportView(tbViewAppointment);

		pnPatient = new JPanel();
		pnPatient.setLayout(null);
		frame.getContentPane().add(pnPatient, "name_206415846457000");

		JLabel lbPatientPanel = new JLabel("Patient Panel");
		lbPatientPanel.setOpaque(true);
		lbPatientPanel.setHorizontalTextPosition(SwingConstants.CENTER);
		lbPatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lbPatientPanel.setForeground(Color.WHITE);
		lbPatientPanel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbPatientPanel.setBackground(Color.BLUE);
		lbPatientPanel.setBounds(26, 11, 650, 57);
		pnPatient.add(lbPatientPanel);

		JLabel lbWelcomePatient = new JLabel("Welcome to Patient Panel");
		lbWelcomePatient.setOpaque(true);
		lbWelcomePatient.setHorizontalAlignment(SwingConstants.CENTER);
		lbWelcomePatient.setForeground(Color.WHITE);
		lbWelcomePatient.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbWelcomePatient.setBackground(Color.BLUE);
		lbWelcomePatient.setBounds(0, 79, 204, 210);
		pnPatient.add(lbWelcomePatient);

		JButton btAddPatient = new JButton("Add Patient");
		btAddPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnPatient.setVisible(false);
				checkPn = 0;
				pnAddPatient.setVisible(true);

			}
		});
		btAddPatient.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\addpatient.png"));
		btAddPatient.setVerticalTextPosition(SwingConstants.BOTTOM);
		btAddPatient.setOpaque(true);
		btAddPatient.setHorizontalTextPosition(SwingConstants.CENTER);
		btAddPatient.setForeground(Color.WHITE);
		btAddPatient.setBackground(Color.GRAY);
		btAddPatient.setBounds(222, 79, 124, 111);
		pnPatient.add(btAddPatient);

		JButton btUpdatePatient = new JButton("Update Patient");
		btUpdatePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnPatient.setVisible(false);
				pnUpdatePatient.setVisible(true);
				tbUpdatePatient = setDataTable();

			}
		});
		btUpdatePatient.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\updatepatient.png"));
		btUpdatePatient.setVerticalTextPosition(SwingConstants.BOTTOM);
		btUpdatePatient.setOpaque(true);
		btUpdatePatient.setHorizontalTextPosition(SwingConstants.CENTER);
		btUpdatePatient.setForeground(Color.WHITE);
		btUpdatePatient.setBackground(Color.GRAY);
		btUpdatePatient.setBounds(374, 79, 124, 111);
		pnPatient.add(btUpdatePatient);

		JButton btnDeletePatient = new JButton("Delete Patient");
		btnDeletePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnPatient.setVisible(false);
				pnDeletePatient.setVisible(true);
				setDataTable();
			}
		});
		btnDeletePatient.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\deletepatient.png"));
		btnDeletePatient.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDeletePatient.setOpaque(true);
		btnDeletePatient.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDeletePatient.setForeground(Color.WHITE);
		btnDeletePatient.setBackground(Color.GRAY);
		btnDeletePatient.setBounds(533, 79, 124, 111);
		pnPatient.add(btnDeletePatient);

		JButton button_3 = new JButton("New button");
		button_3.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_3.setBackground(Color.BLUE);
		button_3.setBounds(745, 11, 70, 57);
		pnPatient.add(button_3);

		JButton btBackPatient = new JButton("New button");
		btBackPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnPatient.setVisible(false);
				pnAP.setVisible(true);
			}
		});
		btBackPatient.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackPatient.setBackground(Color.BLUE);
		btBackPatient.setBounds(675, 11, 70, 57);
		pnPatient.add(btBackPatient);

		JButton btSearchPatient = new JButton("Search Patient");
		btSearchPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnPatient.setVisible(false);
				pnSearchPatient.setVisible(true);
			}
		});
		btSearchPatient.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\searchpatient.png"));
		btSearchPatient.setVerticalTextPosition(SwingConstants.BOTTOM);
		btSearchPatient.setOpaque(true);
		btSearchPatient.setHorizontalTextPosition(SwingConstants.CENTER);
		btSearchPatient.setForeground(Color.WHITE);
		btSearchPatient.setBackground(Color.GRAY);
		btSearchPatient.setBounds(222, 213, 124, 111);
		pnPatient.add(btSearchPatient);

		JButton btViewPatient = new JButton("View Patient");
		btViewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnPatient.setVisible(false);
				pnViewPatient.setVisible(true);
				// setTitle1();
				setDataTable();
				// dtm=new DefaultTableModel();
				// dtm.setDataVector(data, title);
				// // tbViewPatient.setModel(dtm);

			}
		});
		btViewPatient.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\viewpatient.png"));
		btViewPatient.setVerticalTextPosition(SwingConstants.BOTTOM);
		btViewPatient.setOpaque(true);
		btViewPatient.setHorizontalTextPosition(SwingConstants.CENTER);
		btViewPatient.setForeground(Color.WHITE);
		btViewPatient.setBackground(Color.GRAY);
		btViewPatient.setBounds(374, 213, 124, 111);
		pnPatient.add(btViewPatient);

		pnAddPatient = new JPanel();
		pnAddPatient.setLayout(null);
		frame.getContentPane().add(pnAddPatient, "name_207997970588400");

		JLabel lbAddPatient = new JLabel("Add Patient");
		lbAddPatient.setOpaque(true);
		lbAddPatient.setHorizontalTextPosition(SwingConstants.CENTER);
		lbAddPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lbAddPatient.setForeground(Color.WHITE);
		lbAddPatient.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbAddPatient.setBackground(Color.BLUE);
		lbAddPatient.setBounds(26, 11, 650, 57);
		pnAddPatient.add(lbAddPatient);

		JButton button_5 = new JButton("New button");
		button_5.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_5.setBackground(Color.BLUE);
		button_5.setBounds(745, 11, 70, 57);
		pnAddPatient.add(button_5);

		JButton btBackAddP = new JButton("New button");
		btBackAddP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkPn == 0) {
					pnAddPatient.setVisible(false);
					pnPatient.setVisible(true);
				} else {
					pnAddPatient.setVisible(false);
					pnAR.setVisible(true);
				}

			}
		});
		btBackAddP.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackAddP.setBackground(Color.BLUE);
		btBackAddP.setBounds(675, 11, 70, 57);
		pnAddPatient.add(btBackAddP);

		JLabel lbDatePatient = new JLabel("Date");
		lbDatePatient.setForeground(new Color(0, 128, 0));
		lbDatePatient.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbDatePatient.setBounds(94, 81, 46, 14);
		pnAddPatient.add(lbDatePatient);

		tfDatePatient = new JTextField();
		tfDatePatient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfDatePatient.setBounds(150, 79, 135, 20);
		pnAddPatient.add(tfDatePatient);
		tfDatePatient.setColumns(10);

		tfIDPatient = new JTextField();
		tfIDPatient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfIDPatient.setColumns(10);
		tfIDPatient.setBounds(150, 123, 135, 20);
		pnAddPatient.add(tfIDPatient);

		JLabel lbIDPatient = new JLabel("ID");
		lbIDPatient.setForeground(new Color(0, 128, 0));
		lbIDPatient.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbIDPatient.setBounds(94, 125, 46, 14);
		pnAddPatient.add(lbIDPatient);

		tfNamePatient = new JTextField();
		tfNamePatient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfNamePatient.setColumns(10);
		tfNamePatient.setBounds(150, 168, 135, 20);
		pnAddPatient.add(tfNamePatient);

		JLabel lbNamePatient = new JLabel("Name");
		lbNamePatient.setForeground(new Color(0, 128, 0));
		lbNamePatient.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbNamePatient.setBounds(94, 170, 46, 14);
		pnAddPatient.add(lbNamePatient);

		tfAgePatient = new JTextField();
		tfAgePatient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfAgePatient.setColumns(10);
		tfAgePatient.setBounds(150, 214, 135, 20);
		pnAddPatient.add(tfAgePatient);

		JLabel lbAgePatient = new JLabel("Age");
		lbAgePatient.setForeground(new Color(0, 128, 0));
		lbAgePatient.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbAgePatient.setBounds(94, 216, 46, 14);
		pnAddPatient.add(lbAgePatient);

		tfAddressPatient = new JTextField();
		tfAddressPatient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfAddressPatient.setColumns(10);
		tfAddressPatient.setBounds(532, 79, 135, 20);
		pnAddPatient.add(tfAddressPatient);

		JLabel lbAddressPatient = new JLabel("Address");
		lbAddressPatient.setForeground(new Color(0, 128, 0));
		lbAddressPatient.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbAddressPatient.setBounds(405, 81, 60, 14);
		pnAddPatient.add(lbAddressPatient);

		tfPhoneNumberPatient = new JTextField();
		tfPhoneNumberPatient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPhoneNumberPatient.setText("03");
		tfPhoneNumberPatient.setColumns(10);
		tfPhoneNumberPatient.setBounds(532, 123, 135, 20);
		pnAddPatient.add(tfPhoneNumberPatient);

		JLabel lbPhoneNumberPatient = new JLabel("Phone Number");
		lbPhoneNumberPatient.setForeground(new Color(0, 128, 0));
		lbPhoneNumberPatient
				.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbPhoneNumberPatient.setBounds(405, 127, 109, 14);
		pnAddPatient.add(lbPhoneNumberPatient);

		tfDiseaseNamePatient = new JTextField();
		tfDiseaseNamePatient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfDiseaseNamePatient.setColumns(10);
		tfDiseaseNamePatient.setBounds(532, 214, 135, 20);
		pnAddPatient.add(tfDiseaseNamePatient);

		JLabel lbDiseaseNamePatient = new JLabel("Disease Name");
		lbDiseaseNamePatient.setForeground(new Color(0, 128, 0));
		lbDiseaseNamePatient
				.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbDiseaseNamePatient.setBounds(405, 216, 92, 14);
		pnAddPatient.add(lbDiseaseNamePatient);

		tfRoomPatient = new JTextField();
		tfRoomPatient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfRoomPatient.setColumns(10);
		tfRoomPatient.setBounds(532, 273, 135, 20);
		pnAddPatient.add(tfRoomPatient);

		JLabel lbRoomPatient = new JLabel("Ward/Room no");
		lbRoomPatient.setForeground(new Color(0, 128, 0));
		lbRoomPatient.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbRoomPatient.setBounds(405, 275, 106, 14);
		pnAddPatient.add(lbRoomPatient);

		JLabel lbGenderPatient = new JLabel("Gender");
		lbGenderPatient.setForeground(new Color(0, 128, 0));
		lbGenderPatient.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbGenderPatient.setBounds(94, 273, 46, 14);
		pnAddPatient.add(lbGenderPatient);

		JLabel lbMarialStatusPatient = new JLabel("Maritial Status");
		lbMarialStatusPatient.setForeground(new Color(0, 128, 0));
		lbMarialStatusPatient
				.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbMarialStatusPatient.setBounds(405, 173, 92, 14);
		pnAddPatient.add(lbMarialStatusPatient);

		JComboBox cbStatusPatient = new JComboBox();
		cbStatusPatient.setModel(new DefaultComboBoxModel(
				new String[]{"Select Item", "Single", "Maried", "Divorced"}));
		cbStatusPatient.setBounds(532, 170, 135, 20);
		pnAddPatient.add(cbStatusPatient);

		JComboBox cbGenderPatient = new JComboBox();
		cbGenderPatient.setModel(new DefaultComboBoxModel(
				new String[]{"Select Item", "Male", "Female"}));
		cbGenderPatient.setBounds(150, 270, 135, 20);
		pnAddPatient.add(cbGenderPatient);

		JButton btClearPatient = new JButton("Clear");
		btClearPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfDatePatient.setText("");
				tfNamePatient.setText("");
				tfPhoneNumberPatient.setText("03");
				tfIDPatient.setText("");
				tfAddressPatient.setText("");
				tfDiseaseNamePatient.setText("");
				tfRoomPatient.setText("");
				tfAgePatient.setText("");
				cbGenderPatient.setSelectedIndex(0);
				cbStatusPatient.setSelectedIndex(0);

			}
		});
		btClearPatient.setForeground(UIManager.getColor("Button.background"));
		btClearPatient.setBackground(Color.CYAN);
		btClearPatient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btClearPatient.setBounds(196, 343, 89, 57);
		pnAddPatient.add(btClearPatient);

		JButton btAddMorePatient = new JButton("Add");
		btAddMorePatient.setBackground(new Color(0, 0, 205));
		btAddMorePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// con.connect();
				String sql = "insert into patient(date,id,name,age,gender,address,phone,status,disease,room) values(?,?,?,?,?,?,?,?,?,?)";
				try {
					con.ptmt = con.conn.prepareStatement(sql);
					Date dop = getDate(tfDatePatient.getText());
					con.ptmt.setString(1, dateToString(dop));
					con.ptmt.setString(2, tfIDPatient.getText());
					con.ptmt.setString(3, tfNamePatient.getText());
					con.ptmt.setInt(4,
							Integer.parseInt(tfAgePatient.getText()));
					con.ptmt.setString(5,
							(String) cbGenderPatient.getSelectedItem());
					con.ptmt.setString(6, tfAddressPatient.getText());
					con.ptmt.setString(7, tfPhoneNumberPatient.getText());
					con.ptmt.setString(8,
							(String) cbStatusPatient.getSelectedItem());
					con.ptmt.setString(9, tfDiseaseNamePatient.getText());
					con.ptmt.setInt(10,
							Integer.parseInt(tfRoomPatient.getText()));

					checkSql = con.ptmt.executeUpdate();
					if (checkSql != 0)
						JOptionPane.showConfirmDialog(pnAddPatient,
								"Add Success", "", JOptionPane.DEFAULT_OPTION);
					else
						JOptionPane.showConfirmDialog(pnAddPatient,
								"Add Unsuccess", "", JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE);

					con.ptmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btAddMorePatient.setForeground(new Color(255, 255, 255));
		btAddMorePatient.setBounds(408, 343, 89, 57);
		pnAddPatient.add(btAddMorePatient);

		pnViewPatient = new JPanel();
		frame.getContentPane().add(pnViewPatient, "name_96828546675600");
		pnViewPatient.setLayout(null);

		JLabel lblViewPatient = new JLabel("View Patient");
		lblViewPatient.setBounds(26, 11, 701, 57);
		lblViewPatient.setOpaque(true);
		lblViewPatient.setHorizontalTextPosition(SwingConstants.CENTER);
		lblViewPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewPatient.setForeground(Color.WHITE);
		lblViewPatient.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblViewPatient.setBackground(Color.BLUE);
		pnViewPatient.add(lblViewPatient);

		JButton button = new JButton("New button");
		button.setBounds(793, 11, 70, 57);
		button.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button.setBackground(Color.BLUE);
		pnViewPatient.add(button);

		JButton btBackViewP = new JButton("New button");
		btBackViewP.setBounds(724, 11, 70, 57);
		btBackViewP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnViewPatient.setVisible(false);
				pnPatient.setVisible(true);
			}
		});
		btBackViewP.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackViewP.setBackground(Color.BLUE);
		pnViewPatient.add(btBackViewP);

		JScrollPane spViewPatient = new JScrollPane();
		spViewPatient.setBounds(10, 132, 853, 293);
		pnViewPatient.add(spViewPatient);

		tbViewPatient = new JTable();
		spViewPatient.setViewportView(tbViewPatient);

		pnUpdatePatient = new JPanel();
		pnUpdatePatient.setLayout(null);
		frame.getContentPane().add(pnUpdatePatient, "name_8942751431700");

		JLabel lbUpdatePatient = new JLabel("Update Patient");
		lbUpdatePatient.setOpaque(true);
		lbUpdatePatient.setHorizontalTextPosition(SwingConstants.CENTER);
		lbUpdatePatient.setHorizontalAlignment(SwingConstants.CENTER);
		lbUpdatePatient.setForeground(Color.WHITE);
		lbUpdatePatient.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbUpdatePatient.setBackground(new Color(34, 139, 34));
		lbUpdatePatient.setBounds(26, 11, 701, 57);
		pnUpdatePatient.add(lbUpdatePatient);

		JButton button_6 = new JButton("New button");
		button_6.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_6.setBackground(new Color(34, 139, 34));
		button_6.setBounds(793, 11, 70, 57);
		pnUpdatePatient.add(button_6);

		JButton btBackUpdateP = new JButton("New button");
		btBackUpdateP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnUpdatePatient.setVisible(false);
				pnPatient.setVisible(true);
			}
		});
		btBackUpdateP.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackUpdateP.setBackground(new Color(34, 139, 34));
		btBackUpdateP.setBounds(724, 11, 70, 57);
		pnUpdatePatient.add(btBackUpdateP);

		JButton btUpdateMorePatient = new JButton("Update");
		btUpdateMorePatient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btUpdateMorePatient.setBackground(new Color(50, 205, 50));
		btUpdateMorePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean check = update(tbUpdatePatient,
						tbUpdatePatient.getEditingRow(),
						tbUpdatePatient.getEditingColumn());
				if (check)
					JOptionPane.showConfirmDialog(pnUpdatePatient,
							"Update Success", "", JOptionPane.DEFAULT_OPTION);
				else
					JOptionPane.showConfirmDialog(pnUpdatePatient,
							"Update Not Success", "",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.ERROR_MESSAGE);

			}
		});
		btUpdateMorePatient.setBounds(378, 421, 89, 39);
		pnUpdatePatient.add(btUpdateMorePatient);

		JScrollPane spUpdatePatient = new JScrollPane();
		spUpdatePatient.setBounds(10, 108, 840, 290);
		pnUpdatePatient.add(spUpdatePatient);

		tbUpdatePatient = new JTable();
		spUpdatePatient.setViewportView(tbUpdatePatient);

		pnDeletePatient = new JPanel();
		pnDeletePatient.setLayout(null);
		frame.getContentPane().add(pnDeletePatient, "name_170641931916800");

		JLabel lbDeletePatient = new JLabel("Delete Patient");
		lbDeletePatient.setOpaque(true);
		lbDeletePatient.setHorizontalTextPosition(SwingConstants.CENTER);
		lbDeletePatient.setHorizontalAlignment(SwingConstants.CENTER);
		lbDeletePatient.setForeground(Color.WHITE);
		lbDeletePatient.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbDeletePatient.setBackground(new Color(0, 255, 255));
		lbDeletePatient.setBounds(47, 11, 841, 57);
		pnDeletePatient.add(lbDeletePatient);

		JButton button_1 = new JButton("New button");
		button_1.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_1.setBackground(new Color(0, 255, 255));
		button_1.setBounds(954, 11, 70, 57);
		pnDeletePatient.add(button_1);

		JButton btBackDeleteP = new JButton("New button");
		btBackDeleteP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btBackDeleteP.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackDeleteP.setBackground(new Color(0, 255, 255));
		btBackDeleteP.setBounds(886, 11, 70, 57);
		pnDeletePatient.add(btBackDeleteP);

		JScrollPane spDeletePatient = new JScrollPane();
		spDeletePatient.setBounds(10, 222, 1012, 259);
		pnDeletePatient.add(spDeletePatient);

		tbDeletePatient = new JTable();
		spDeletePatient.setViewportView(tbDeletePatient);

		JLabel lbNameDeletePatient = new JLabel("NAME OF PATIENT");
		lbNameDeletePatient.setForeground(new Color(50, 205, 50));
		lbNameDeletePatient.setFont(new Font("Jokerman", Font.PLAIN, 21));
		lbNameDeletePatient.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNameDeletePatient.setBounds(10, 105, 320, 85);
		pnDeletePatient.add(lbNameDeletePatient);

		tfNameDeletePatient = new JTextField();
		tfNameDeletePatient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfNameDeletePatient.setBounds(340, 122, 548, 52);
		pnDeletePatient.add(tfNameDeletePatient);
		tfNameDeletePatient.setColumns(10);

		JButton btDeleteMorePatient = new JButton("DELETE");
		btDeleteMorePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfNameDeletePatient.getText();
				deleteModel(tbDeletePatient, name);

			}
		});
		btDeleteMorePatient.setBackground(new Color(0, 0, 255));
		btDeleteMorePatient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btDeleteMorePatient.setBounds(898, 124, 89, 52);
		pnDeletePatient.add(btDeleteMorePatient);

		pnSearchPatient = new JPanel();
		pnSearchPatient.setLayout(null);
		frame.getContentPane().add(pnSearchPatient, "name_153083961248000");

		JLabel lblSearchPatient = new JLabel("Search Patient");
		lblSearchPatient.setOpaque(true);
		lblSearchPatient.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSearchPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchPatient.setForeground(Color.WHITE);
		lblSearchPatient.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSearchPatient.setBackground(Color.RED);
		lblSearchPatient.setBounds(26, 11, 859, 57);
		pnSearchPatient.add(lblSearchPatient);

		JButton button_2 = new JButton("New button");
		button_2.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_2.setBackground(Color.RED);
		button_2.setBounds(952, 11, 70, 57);
		pnSearchPatient.add(button_2);

		JButton btBackSearchPatient = new JButton("New button");
		btBackSearchPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnSearchPatient.setVisible(false);
				pnPatient.setVisible(true);
			}
		});
		btBackSearchPatient.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackSearchPatient.setBackground(Color.RED);
		btBackSearchPatient.setBounds(883, 11, 70, 57);
		pnSearchPatient.add(btBackSearchPatient);

		JScrollPane spSearchPatient = new JScrollPane();
		spSearchPatient.setBounds(10, 188, 1012, 293);
		pnSearchPatient.add(spSearchPatient);

		tbSearchPatient = new JTable();
		spSearchPatient.setViewportView(tbSearchPatient);

		JLabel lbNameSearchPatient = new JLabel("NAME OF PATIENT");
		lbNameSearchPatient.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNameSearchPatient.setForeground(new Color(50, 205, 50));
		lbNameSearchPatient.setFont(new Font("Jokerman", Font.PLAIN, 21));
		lbNameSearchPatient.setBounds(22, 79, 320, 85);
		pnSearchPatient.add(lbNameSearchPatient);

		tfNameSearchPatient = new JTextField();
		tfNameSearchPatient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfNameSearchPatient.setColumns(10);
		tfNameSearchPatient.setBounds(352, 96, 548, 52);
		pnSearchPatient.add(tfNameSearchPatient);

		JButton btSearchNamePatient = new JButton("SEARCH");
		btSearchNamePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search(tbSearchPatient, tfNameSearchPatient);
			}
		});
		btSearchNamePatient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSearchNamePatient.setBackground(Color.BLUE);
		btSearchNamePatient.setBounds(910, 98, 89, 52);
		pnSearchPatient.add(btSearchNamePatient);

		pnDoctor = new JPanel();
		pnDoctor.setForeground(Color.GREEN);
		pnDoctor.setLayout(null);
		frame.getContentPane().add(pnDoctor, "name_101503335568400");

		JLabel lblDoctorPanel = new JLabel("Doctor Panel");
		lblDoctorPanel.setOpaque(true);
		lblDoctorPanel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDoctorPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorPanel.setForeground(Color.WHITE);
		lblDoctorPanel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblDoctorPanel.setBackground(Color.PINK);
		lblDoctorPanel.setBounds(26, 11, 872, 57);
		pnDoctor.add(lblDoctorPanel);

		JLabel lblWelcomeToDoctor = new JLabel("Welcome to Doctor Panel");
		lblWelcomeToDoctor.setOpaque(true);
		lblWelcomeToDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToDoctor.setForeground(Color.WHITE);
		lblWelcomeToDoctor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWelcomeToDoctor.setBackground(Color.PINK);
		lblWelcomeToDoctor.setBounds(0, 79, 204, 210);
		pnDoctor.add(lblWelcomeToDoctor);

		JButton btAddDoctor = new JButton("Add New");
		btAddDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnDoctor.setVisible(false);
				pnAddDoc.setVisible(true);
			}
		});
		btAddDoctor.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\addpatient.png"));
		btAddDoctor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btAddDoctor.setVerticalTextPosition(SwingConstants.BOTTOM);
		btAddDoctor.setOpaque(true);
		btAddDoctor.setHorizontalTextPosition(SwingConstants.CENTER);
		btAddDoctor.setForeground(Color.GREEN);
		btAddDoctor.setBackground(Color.MAGENTA);
		btAddDoctor.setBounds(222, 79, 124, 111);
		pnDoctor.add(btAddDoctor);

		JButton btUpdateDoctor = new JButton("Update Doctor");
		btUpdateDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnDoctor.setVisible(false);
				pnUpdateDoc.setVisible(true);
				tbUpdateDoc = setDataTable();
			}
		});
		btUpdateDoctor.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\updatepatient.png"));
		btUpdateDoctor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btUpdateDoctor.setVerticalTextPosition(SwingConstants.BOTTOM);
		btUpdateDoctor.setOpaque(true);
		btUpdateDoctor.setHorizontalTextPosition(SwingConstants.CENTER);
		btUpdateDoctor.setForeground(Color.GREEN);
		btUpdateDoctor.setBackground(Color.MAGENTA);
		btUpdateDoctor.setBounds(374, 79, 124, 111);
		pnDoctor.add(btUpdateDoctor);

		JButton btDeleteDoctor = new JButton("Delete Doctor");
		btDeleteDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnDoctor.setVisible(false);
				pnDeleteDoc.setVisible(true);
				tbDeleteDoc = setDataTable();
			}
		});
		btDeleteDoctor.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\deletepatient.png"));
		btDeleteDoctor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btDeleteDoctor.setVerticalTextPosition(SwingConstants.BOTTOM);
		btDeleteDoctor.setOpaque(true);
		btDeleteDoctor.setHorizontalTextPosition(SwingConstants.CENTER);
		btDeleteDoctor.setForeground(Color.GREEN);
		btDeleteDoctor.setBackground(Color.MAGENTA);
		btDeleteDoctor.setBounds(533, 79, 124, 111);
		pnDoctor.add(btDeleteDoctor);

		JButton button_9 = new JButton("New button");
		button_9.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_9.setBackground(Color.PINK);
		button_9.setBounds(966, 11, 70, 57);
		pnDoctor.add(button_9);

		JButton button_10 = new JButton("New button");
		button_10.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		button_10.setBackground(Color.PINK);
		button_10.setBounds(896, 11, 70, 57);
		pnDoctor.add(button_10);

		JButton btSearchDoctor = new JButton("Search Doctor");
		btSearchDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnDoctor.setVisible(false);
				pnSearchDoc.setVisible(true);
			}
		});
		btSearchDoctor.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\searchpatient.png"));
		btSearchDoctor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSearchDoctor.setVerticalTextPosition(SwingConstants.BOTTOM);
		btSearchDoctor.setOpaque(true);
		btSearchDoctor.setHorizontalTextPosition(SwingConstants.CENTER);
		btSearchDoctor.setForeground(Color.GREEN);
		btSearchDoctor.setBackground(Color.MAGENTA);
		btSearchDoctor.setBounds(222, 201, 124, 111);
		pnDoctor.add(btSearchDoctor);

		JButton btViewDoctor = new JButton("View Doctor");
		btViewDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnDoctor.setVisible(false);
				pnViewDoc.setVisible(true);
				tbViewDoc = setDataTable();

			}
		});
		btViewDoctor.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\viewpatient.png"));
		btViewDoctor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btViewDoctor.setVerticalTextPosition(SwingConstants.BOTTOM);
		btViewDoctor.setOpaque(true);
		btViewDoctor.setHorizontalTextPosition(SwingConstants.CENTER);
		btViewDoctor.setForeground(Color.GREEN);
		btViewDoctor.setBackground(Color.MAGENTA);
		btViewDoctor.setBounds(374, 201, 124, 111);
		pnDoctor.add(btViewDoctor);

		JButton btBackViewDoc = new JButton("New button");
		btBackViewDoc.setBounds(0, 0, 70, 57);
		pnDoctor.add(btBackViewDoc);
		btBackViewDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnViewDoc.setVisible(false);
				pnDoctor.setVisible(true);
			}
		});
		btBackViewDoc.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackViewDoc.setBackground(Color.PINK);

		pnAddDoc = new JPanel();
		pnAddDoc.setLayout(null);
		frame.getContentPane().add(pnAddDoc, "name_135899365771499");

		JLabel lbAddDoc = new JLabel("Doctor Panel");
		lbAddDoc.setOpaque(true);
		lbAddDoc.setHorizontalTextPosition(SwingConstants.CENTER);
		lbAddDoc.setHorizontalAlignment(SwingConstants.CENTER);
		lbAddDoc.setForeground(Color.WHITE);
		lbAddDoc.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbAddDoc.setBackground(Color.PINK);
		lbAddDoc.setBounds(26, 11, 876, 57);
		pnAddDoc.add(lbAddDoc);

		JButton button_4 = new JButton("New button");
		button_4.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_4.setBackground(Color.PINK);
		button_4.setBounds(969, 11, 70, 57);
		pnAddDoc.add(button_4);

		JButton btBackAddDoc = new JButton("New button");
		btBackAddDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnAddDoc.setVisible(false);
				pnDoctor.setVisible(true);
			}
		});
		btBackAddDoc.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackAddDoc.setBackground(Color.PINK);
		btBackAddDoc.setBounds(899, 11, 70, 57);
		pnAddDoc.add(btBackAddDoc);

		JLabel lbDateDoc = new JLabel("Joining Date");
		lbDateDoc.setForeground(new Color(0, 128, 0));
		lbDateDoc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbDateDoc.setBounds(48, 81, 92, 14);
		pnAddDoc.add(lbDateDoc);

		tfDateDoc = new JTextField();
		tfDateDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfDateDoc.setColumns(10);
		tfDateDoc.setBounds(150, 79, 135, 20);
		pnAddDoc.add(tfDateDoc);

		tfIDDoc = new JTextField();
		tfIDDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfIDDoc.setColumns(10);
		tfIDDoc.setBounds(150, 123, 135, 20);
		pnAddDoc.add(tfIDDoc);

		JLabel lbIDDoc = new JLabel("ID");
		lbIDDoc.setForeground(new Color(0, 128, 0));
		lbIDDoc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbIDDoc.setBounds(48, 129, 46, 14);
		pnAddDoc.add(lbIDDoc);

		tfNameDoc = new JTextField();
		tfNameDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfNameDoc.setColumns(10);
		tfNameDoc.setBounds(150, 168, 135, 20);
		pnAddDoc.add(tfNameDoc);

		JLabel lbNameDoc = new JLabel("Name");
		lbNameDoc.setForeground(new Color(0, 128, 0));
		lbNameDoc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbNameDoc.setBounds(48, 174, 46, 14);
		pnAddDoc.add(lbNameDoc);

		tfAgeDoc = new JTextField();
		tfAgeDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfAgeDoc.setColumns(10);
		tfAgeDoc.setBounds(150, 214, 135, 20);
		pnAddDoc.add(tfAgeDoc);

		lbAgeDoc = new JLabel("Age");
		lbAgeDoc.setForeground(new Color(0, 128, 0));
		lbAgeDoc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbAgeDoc.setBounds(48, 220, 46, 14);
		pnAddDoc.add(lbAgeDoc);

		tfAddressDoc = new JTextField();
		tfAddressDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfAddressDoc.setColumns(10);
		tfAddressDoc.setBounds(532, 79, 135, 20);
		pnAddDoc.add(tfAddressDoc);

		JLabel lbAddressDoc = new JLabel("Address");
		lbAddressDoc.setForeground(new Color(0, 128, 0));
		lbAddressDoc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbAddressDoc.setBounds(405, 81, 60, 14);
		pnAddDoc.add(lbAddressDoc);

		tfPhoneDoc = new JTextField();
		tfPhoneDoc.setText("03");
		tfPhoneDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPhoneDoc.setColumns(10);
		tfPhoneDoc.setBounds(532, 123, 135, 20);
		pnAddDoc.add(tfPhoneDoc);

		JLabel lbPhoneDoc = new JLabel("Phone Number");
		lbPhoneDoc.setForeground(new Color(0, 128, 0));
		lbPhoneDoc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbPhoneDoc.setBounds(405, 127, 109, 14);
		pnAddDoc.add(lbPhoneDoc);

		tfRoomDoc = new JTextField();
		tfRoomDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfRoomDoc.setColumns(10);
		tfRoomDoc.setBounds(532, 256, 135, 20);
		pnAddDoc.add(tfRoomDoc);

		JLabel lbRoomDoc = new JLabel("Ward/Room no");
		lbRoomDoc.setForeground(new Color(0, 128, 0));
		lbRoomDoc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbRoomDoc.setBounds(405, 258, 106, 14);
		pnAddDoc.add(lbRoomDoc);

		JLabel lbGenderDoc = new JLabel("Gender");
		lbGenderDoc.setForeground(new Color(0, 128, 0));
		lbGenderDoc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbGenderDoc.setBounds(48, 260, 46, 14);
		pnAddDoc.add(lbGenderDoc);

		JLabel lbStatusDoc = new JLabel("Maritial Status");
		lbStatusDoc.setForeground(new Color(0, 128, 0));
		lbStatusDoc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbStatusDoc.setBounds(405, 173, 92, 14);
		pnAddDoc.add(lbStatusDoc);

		cbStatusDoc = new JComboBox();
		cbStatusDoc.setModel(new DefaultComboBoxModel(
				new String[]{"Select Item", "Single", "Maried", "Divorced"}));
		cbStatusDoc.setBounds(532, 170, 135, 20);
		pnAddDoc.add(cbStatusDoc);

		cbGenderDoc = new JComboBox();
		cbGenderDoc.setModel(new DefaultComboBoxModel(
				new String[]{"Selected Item", "Male", "Female"}));
		cbGenderDoc.setBounds(150, 255, 135, 20);
		pnAddDoc.add(cbGenderDoc);

		JButton btClearDoc = new JButton("Clear");
		btClearDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfDateDoc.setText("");
				tfIDDoc.setText("");
				tfNameDoc.setText("");
				tfAgeDoc.setText("");
				tfPhoneDoc.setText("03");
				tfEmailDoc.setText("");
				tfRoomDoc.setText("");
				tfAddressDoc.setText("");
				tfBloodDoc.setText("");
				tfUsernameDoc.setText("");
				tfPasswordDoc.setText("");
				cbGenderDoc.setSelectedIndex(0);
				cbStatusDoc.setSelectedIndex(0);
				cbDeptDoc.setSelectedIndex(0);

			}
		});
		btClearDoc.setForeground(Color.RED);
		btClearDoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btClearDoc.setBackground(Color.CYAN);
		btClearDoc.setBounds(189, 424, 89, 57);
		pnAddDoc.add(btClearDoc);

		JButton btAddMoreDoc = new JButton("Add");
		btAddMoreDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				con.connect();
				try {
					con.ptmt = con.conn.prepareStatement(
							"insert into doctor(date,id,name,age,gender,blood,dept,phone,email,status,address,room,username,password) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					con.ptmt.setString(1, tfDateDoc.getText());
					con.ptmt.setString(2, tfIDDoc.getText());
					con.ptmt.setString(3, tfNameDoc.getText());
					con.ptmt.setInt(4, Integer.parseInt(tfAgeDoc.getText()));
					con.ptmt.setString(5,
							(String) cbGenderDoc.getSelectedItem());
					con.ptmt.setString(6, tfBloodDoc.getText());
					con.ptmt.setString(7, (String) cbDeptDoc.getSelectedItem());
					con.ptmt.setString(8, tfPhoneDoc.getText());
					con.ptmt.setString(9, tfEmailDoc.getText());
					con.ptmt.setString(10,
							(String) cbStatusDoc.getSelectedItem());
					con.ptmt.setString(11, tfAddressDoc.getText());
					con.ptmt.setInt(12, Integer.parseInt(tfRoomDoc.getText()));
					con.ptmt.setString(13, tfUsernameDoc.getText());
					con.ptmt.setString(14, tfPasswordDoc.getText());
					checkSql = con.ptmt.executeUpdate();
					if (checkSql != 0)
						JOptionPane.showConfirmDialog(pnAddDoc, "Success", "",
								JOptionPane.DEFAULT_OPTION);
					else
						JOptionPane.showConfirmDialog(pnAddPatient, "Unsuccess",
								"", JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE);
					con.ptmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btAddMoreDoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btAddMoreDoc.setForeground(Color.RED);
		btAddMoreDoc.setBackground(new Color(0, 0, 205));
		btAddMoreDoc.setBounds(405, 424, 89, 57);
		pnAddDoc.add(btAddMoreDoc);

		JLabel lbBloodDoc = new JLabel("Blood");
		lbBloodDoc.setForeground(new Color(0, 128, 0));
		lbBloodDoc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbBloodDoc.setBounds(48, 298, 46, 14);
		pnAddDoc.add(lbBloodDoc);

		JLabel lbDeptDoc = new JLabel("Department");
		lbDeptDoc.setForeground(new Color(0, 128, 0));
		lbDeptDoc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbDeptDoc.setBounds(405, 296, 109, 14);
		pnAddDoc.add(lbDeptDoc);
		cbDeptDoc = new JComboBox();
		cbDeptDoc.setModel(new DefaultComboBoxModel(
				new String[]{"Selected Department", "Medicine", "Microbiology",
						"Dental", "Gynaecology", "Nutrition", "Neurology",
						"Cardiology ", "Haematology", ""}));
		cbDeptDoc.setBounds(532, 294, 135, 20);
		pnAddDoc.add(cbDeptDoc);

		tfBloodDoc = new JTextField();
		tfBloodDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfBloodDoc.setColumns(10);
		tfBloodDoc.setBounds(150, 296, 135, 20);
		pnAddDoc.add(tfBloodDoc);

		JLabel lbUsernameDoc = new JLabel("Username");
		lbUsernameDoc.setForeground(new Color(0, 128, 0));
		lbUsernameDoc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbUsernameDoc.setBounds(724, 168, 70, 14);
		pnAddDoc.add(lbUsernameDoc);

		tfUsernameDoc = new JTextField();
		tfUsernameDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfUsernameDoc.setColumns(10);
		tfUsernameDoc.setBounds(828, 157, 222, 31);
		pnAddDoc.add(tfUsernameDoc);

		JLabel lbPasswordDoc = new JLabel("Password");
		lbPasswordDoc.setForeground(new Color(0, 128, 0));
		lbPasswordDoc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbPasswordDoc.setBounds(724, 236, 76, 14);
		pnAddDoc.add(lbPasswordDoc);

		tfPasswordDoc = new JTextField();
		tfPasswordDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPasswordDoc.setColumns(10);
		tfPasswordDoc.setBounds(828, 227, 222, 31);
		pnAddDoc.add(tfPasswordDoc);

		tfEmailDoc = new JTextField();
		tfEmailDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfEmailDoc.setColumns(10);
		tfEmailDoc.setBounds(532, 214, 135, 20);
		pnAddDoc.add(tfEmailDoc);

		JLabel lbEmailDoc = new JLabel("Email");
		lbEmailDoc.setForeground(new Color(0, 128, 0));
		lbEmailDoc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbEmailDoc.setBounds(405, 218, 46, 14);
		pnAddDoc.add(lbEmailDoc);

		pnViewDoc = new JPanel();
		pnViewDoc.setLayout(null);
		frame.getContentPane().add(pnViewDoc, "name_150208075192000");

		JLabel lbViewDoc = new JLabel("View Doctor");
		lbViewDoc.setOpaque(true);
		lbViewDoc.setHorizontalTextPosition(SwingConstants.CENTER);
		lbViewDoc.setHorizontalAlignment(SwingConstants.CENTER);
		lbViewDoc.setForeground(Color.WHITE);
		lbViewDoc.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbViewDoc.setBackground(Color.PINK);
		lbViewDoc.setBounds(26, 11, 885, 57);
		pnViewDoc.add(lbViewDoc);

		JButton button_7 = new JButton("New button");
		button_7.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_7.setBackground(Color.PINK);
		button_7.setBounds(980, 11, 70, 57);
		pnViewDoc.add(button_7);

		JScrollPane spViewDoc = new JScrollPane();
		spViewDoc.setBounds(10, 132, 1040, 293);
		pnViewDoc.add(spViewDoc);

		tbViewDoc = new JTable();
		spViewDoc.setViewportView(tbViewDoc);

		pnUpdateDoc = new JPanel();
		pnUpdateDoc.setLayout(null);
		frame.getContentPane().add(pnUpdateDoc, "name_150986464753300");

		JLabel lbUpdateDoc = new JLabel("Update Doctor");
		lbUpdateDoc.setOpaque(true);
		lbUpdateDoc.setHorizontalTextPosition(SwingConstants.CENTER);
		lbUpdateDoc.setHorizontalAlignment(SwingConstants.CENTER);
		lbUpdateDoc.setForeground(Color.WHITE);
		lbUpdateDoc.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbUpdateDoc.setBackground(new Color(34, 139, 34));
		lbUpdateDoc.setBounds(26, 11, 887, 57);
		pnUpdateDoc.add(lbUpdateDoc);

		JButton button_12 = new JButton("New button");
		button_12.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_12.setBackground(new Color(34, 139, 34));
		button_12.setBounds(980, 11, 70, 57);
		pnUpdateDoc.add(button_12);

		JButton btBackUpdateDoc = new JButton("New button");
		btBackUpdateDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnUpdateDoc.setVisible(false);
				pnDoctor.setVisible(true);
			}
		});
		btBackUpdateDoc.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackUpdateDoc.setBackground(new Color(34, 139, 34));
		btBackUpdateDoc.setBounds(911, 11, 70, 57);
		pnUpdateDoc.add(btBackUpdateDoc);

		JButton btUpdateMoreDoc = new JButton("Update");
		btUpdateMoreDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = update(tbUpdateDoc, tbUpdateDoc.getEditingRow(),
						tbUpdateDoc.getEditingColumn());
				if (check)
					JOptionPane.showConfirmDialog(pnUpdateDoc, "Success", "",
							JOptionPane.DEFAULT_OPTION);
				else
					JOptionPane.showConfirmDialog(pnUpdateDoc, "Not Success",
							"", JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE);

			}
		});
		btUpdateMoreDoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btUpdateMoreDoc.setBackground(new Color(50, 205, 50));
		btUpdateMoreDoc.setBounds(463, 419, 89, 39);
		pnUpdateDoc.add(btUpdateMoreDoc);

		JScrollPane spUpdateDoc = new JScrollPane();
		spUpdateDoc.setBounds(10, 108, 1050, 290);
		pnUpdateDoc.add(spUpdateDoc);

		tbUpdateDoc = new JTable();
		spUpdateDoc.setViewportView(tbUpdateDoc);

		pnDeleteDoc = new JPanel();
		pnDeleteDoc.setLayout(null);
		frame.getContentPane().add(pnDeleteDoc, "name_153020684196100");

		JLabel lbDeleteDoc = new JLabel("Delete Docter");
		lbDeleteDoc.setOpaque(true);
		lbDeleteDoc.setHorizontalTextPosition(SwingConstants.CENTER);
		lbDeleteDoc.setHorizontalAlignment(SwingConstants.CENTER);
		lbDeleteDoc.setForeground(Color.WHITE);
		lbDeleteDoc.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbDeleteDoc.setBackground(Color.CYAN);
		lbDeleteDoc.setBounds(47, 11, 841, 57);
		pnDeleteDoc.add(lbDeleteDoc);

		JButton button_8 = new JButton("New button");
		button_8.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_8.setBackground(Color.CYAN);
		button_8.setBounds(952, 11, 70, 57);
		pnDeleteDoc.add(button_8);

		JButton btBackDeleteDoc = new JButton("New button");
		btBackDeleteDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnDeleteDoc.setVisible(false);
				pnDoctor.setVisible(true);
			}
		});
		btBackDeleteDoc.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackDeleteDoc.setBackground(Color.CYAN);
		btBackDeleteDoc.setBounds(884, 11, 70, 57);
		pnDeleteDoc.add(btBackDeleteDoc);

		JScrollPane spDeleteDoc = new JScrollPane();
		spDeleteDoc.setBounds(10, 222, 1012, 259);
		pnDeleteDoc.add(spDeleteDoc);

		tbDeleteDoc = new JTable();
		spDeleteDoc.setViewportView(tbDeleteDoc);

		JLabel lbNameOfDoctor = new JLabel("NAME OF DOCTOR");
		lbNameOfDoctor.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNameOfDoctor.setForeground(new Color(50, 205, 50));
		lbNameOfDoctor.setFont(new Font("Jokerman", Font.PLAIN, 21));
		lbNameOfDoctor.setBounds(10, 105, 320, 85);
		pnDeleteDoc.add(lbNameOfDoctor);

		tfNameOfDoctor = new JTextField();
		tfNameOfDoctor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfNameOfDoctor.setColumns(10);
		tfNameOfDoctor.setBounds(340, 122, 548, 52);
		pnDeleteDoc.add(tfNameOfDoctor);

		JButton btDeleteDoc = new JButton("DELETE");
		btDeleteDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteModel(tbDeleteDoc, tfNameOfDoctor.getText());

			}
		});
		btDeleteDoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btDeleteDoc.setBackground(Color.BLUE);
		btDeleteDoc.setBounds(898, 124, 89, 52);
		pnDeleteDoc.add(btDeleteDoc);

		pnSearchDoc = new JPanel();
		pnSearchDoc.setLayout(null);
		frame.getContentPane().add(pnSearchDoc, "name_155135873041900");

		JLabel lbSearchDoc = new JLabel("Search Doctor");
		lbSearchDoc.setOpaque(true);
		lbSearchDoc.setHorizontalTextPosition(SwingConstants.CENTER);
		lbSearchDoc.setHorizontalAlignment(SwingConstants.CENTER);
		lbSearchDoc.setForeground(Color.WHITE);
		lbSearchDoc.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbSearchDoc.setBackground(Color.RED);
		lbSearchDoc.setBounds(26, 11, 859, 57);
		pnSearchDoc.add(lbSearchDoc);

		JButton button_11 = new JButton("New button");
		button_11.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_11.setBackground(Color.RED);
		button_11.setBounds(952, 11, 70, 57);
		pnSearchDoc.add(button_11);

		JButton btBackSearchDoc = new JButton("New button");
		btBackSearchDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnSearchDoc.setVisible(false);
				pnDoctor.setVisible(true);
			}
		});
		btBackSearchDoc.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackSearchDoc.setBackground(Color.RED);
		btBackSearchDoc.setBounds(883, 11, 70, 57);
		pnSearchDoc.add(btBackSearchDoc);

		JScrollPane spSearchDoc = new JScrollPane();
		spSearchDoc.setBounds(26, 175, 1012, 293);
		pnSearchDoc.add(spSearchDoc);

		tbSearchDoc = new JTable();
		spSearchDoc.setViewportView(tbSearchDoc);

		JLabel lbNameSearchDoc = new JLabel("NAME OF DOCTOR");
		lbNameSearchDoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNameSearchDoc.setForeground(new Color(50, 205, 50));
		lbNameSearchDoc.setFont(new Font("Jokerman", Font.PLAIN, 21));
		lbNameSearchDoc.setBounds(22, 79, 320, 85);
		pnSearchDoc.add(lbNameSearchDoc);

		tfNameSearchDoc = new JTextField();
		tfNameSearchDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfNameSearchDoc.setColumns(10);
		tfNameSearchDoc.setBounds(352, 96, 548, 52);
		pnSearchDoc.add(tfNameSearchDoc);

		JButton btSearchDoc = new JButton("SEARCH");
		btSearchDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search(tbSearchDoc, tfNameSearchDoc);

			}
		});
		btSearchDoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSearchDoc.setBackground(Color.BLUE);
		btSearchDoc.setBounds(910, 98, 89, 52);
		pnSearchDoc.add(btSearchDoc);

		pnRecept = new JPanel();
		pnRecept.setLayout(null);
		pnRecept.setForeground(Color.GREEN);
		frame.getContentPane().add(pnRecept, "name_487500729869200");

		JLabel lbRecept = new JLabel("Receptionist Panel");
		lbRecept.setOpaque(true);
		lbRecept.setHorizontalTextPosition(SwingConstants.CENTER);
		lbRecept.setHorizontalAlignment(SwingConstants.CENTER);
		lbRecept.setForeground(Color.WHITE);
		lbRecept.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbRecept.setBackground(new Color(139, 69, 19));
		lbRecept.setBounds(26, 11, 872, 57);
		pnRecept.add(lbRecept);

		JLabel lblWelcomeToReceptionist = new JLabel(
				"Welcome to Receptionist Panel");
		lblWelcomeToReceptionist.setOpaque(true);
		lblWelcomeToReceptionist.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToReceptionist.setForeground(Color.WHITE);
		lblWelcomeToReceptionist.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWelcomeToReceptionist.setBackground(new Color(139, 69, 19));
		lblWelcomeToReceptionist.setBounds(0, 79, 256, 210);
		pnRecept.add(lblWelcomeToReceptionist);

		JButton btAddRecept = new JButton("Add New");
		btAddRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnRecept.setVisible(false);
				pnAddRecept.setVisible(true);
			}
		});
		btAddRecept.setVerticalTextPosition(SwingConstants.BOTTOM);
		btAddRecept.setOpaque(true);
		btAddRecept.setHorizontalTextPosition(SwingConstants.CENTER);
		btAddRecept.setForeground(Color.GREEN);
		btAddRecept.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btAddRecept.setBackground(new Color(139, 69, 19));
		btAddRecept.setBounds(277, 79, 167, 111);
		pnRecept.add(btAddRecept);

		JButton bnUpdateRecept = new JButton("Update Receptionist");
		bnUpdateRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnRecept.setVisible(false);
				pnUpdateRecept.setVisible(true);
				setDataTable();
			}
		});
		bnUpdateRecept.setVerticalTextPosition(SwingConstants.BOTTOM);
		bnUpdateRecept.setOpaque(true);
		bnUpdateRecept.setHorizontalTextPosition(SwingConstants.CENTER);
		bnUpdateRecept.setForeground(Color.GREEN);
		bnUpdateRecept.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bnUpdateRecept.setBackground(new Color(139, 69, 19));
		bnUpdateRecept.setBounds(454, 79, 159, 111);
		pnRecept.add(bnUpdateRecept);

		JButton btDeleteRecept = new JButton("Delete Receptionist");
		btDeleteRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnRecept.setVisible(false);
				pnDeleteRecept.setVisible(true);
				tbDeleteRecept = setDataTable();
			}
		});
		btDeleteRecept.setVerticalTextPosition(SwingConstants.BOTTOM);
		btDeleteRecept.setOpaque(true);
		btDeleteRecept.setHorizontalTextPosition(SwingConstants.CENTER);
		btDeleteRecept.setForeground(Color.GREEN);
		btDeleteRecept.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btDeleteRecept.setBackground(new Color(139, 69, 19));
		btDeleteRecept.setBounds(623, 79, 149, 111);
		pnRecept.add(btDeleteRecept);

		JButton button_16 = new JButton("");
		button_16.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_16.setBackground(Color.PINK);
		button_16.setBounds(966, 11, 70, 57);
		pnRecept.add(button_16);

		JButton bnBackRecept = new JButton("");
		bnBackRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnRecept.setVisible(false);
				pnAP.setVisible(true);
			}
		});
		bnBackRecept.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		bnBackRecept.setBackground(Color.PINK);
		bnBackRecept.setBounds(896, 11, 70, 57);
		pnRecept.add(bnBackRecept);

		JButton bnSearchRecept = new JButton("Search Receptionist");
		bnSearchRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnRecept.setVisible(false);
				pnSearchRecept.setVisible(true);
			}
		});
		bnSearchRecept.setVerticalTextPosition(SwingConstants.BOTTOM);
		bnSearchRecept.setOpaque(true);
		bnSearchRecept.setHorizontalTextPosition(SwingConstants.CENTER);
		bnSearchRecept.setForeground(Color.GREEN);
		bnSearchRecept.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bnSearchRecept.setBackground(new Color(139, 69, 19));
		bnSearchRecept.setBounds(277, 201, 167, 111);
		pnRecept.add(bnSearchRecept);

		JButton btViewRecept = new JButton("View Receptionist");
		btViewRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnRecept.setVisible(false);
				pnViewRecept.setVisible(true);
				setDataTable();

			}
		});
		btViewRecept.setVerticalTextPosition(SwingConstants.BOTTOM);
		btViewRecept.setOpaque(true);
		btViewRecept.setHorizontalTextPosition(SwingConstants.CENTER);
		btViewRecept.setForeground(Color.GREEN);
		btViewRecept.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btViewRecept.setBackground(new Color(139, 69, 19));
		btViewRecept.setBounds(454, 201, 159, 111);
		pnRecept.add(btViewRecept);

		pnAddRecept = new JPanel();
		pnAddRecept.setLayout(null);
		frame.getContentPane().add(pnAddRecept, "name_488623454074600");

		JLabel lbAddRecept = new JLabel("Receptionist Panel");
		lbAddRecept.setOpaque(true);
		lbAddRecept.setHorizontalTextPosition(SwingConstants.CENTER);
		lbAddRecept.setHorizontalAlignment(SwingConstants.CENTER);
		lbAddRecept.setForeground(Color.WHITE);
		lbAddRecept.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbAddRecept.setBackground(Color.PINK);
		lbAddRecept.setBounds(26, 11, 884, 57);
		pnAddRecept.add(lbAddRecept);

		JButton button_13 = new JButton("New button");
		button_13.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_13.setBackground(Color.PINK);
		button_13.setBounds(980, 11, 70, 57);
		pnAddRecept.add(button_13);

		JButton btBackAddRecept = new JButton("New button");
		btBackAddRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnAddRecept.setVisible(false);
				pnRecept.setVisible(true);
			}
		});
		btBackAddRecept.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackAddRecept.setBackground(Color.PINK);
		btBackAddRecept.setBounds(910, 11, 70, 57);
		pnAddRecept.add(btBackAddRecept);

		JLabel lbDateRecept = new JLabel("Joining Date");
		lbDateRecept.setForeground(new Color(0, 128, 0));
		lbDateRecept.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbDateRecept.setBounds(48, 81, 92, 14);
		pnAddRecept.add(lbDateRecept);

		tfDateRecept = new JTextField();
		tfDateRecept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfDateRecept.setColumns(10);
		tfDateRecept.setBounds(150, 79, 135, 20);
		pnAddRecept.add(tfDateRecept);

		tfIDRecept = new JTextField();
		tfIDRecept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfIDRecept.setColumns(10);
		tfIDRecept.setBounds(150, 123, 135, 20);
		pnAddRecept.add(tfIDRecept);

		JLabel lbIDRecept = new JLabel("ID");
		lbIDRecept.setForeground(new Color(0, 128, 0));
		lbIDRecept.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbIDRecept.setBounds(48, 129, 46, 14);
		pnAddRecept.add(lbIDRecept);

		tfNameRecept = new JTextField();
		tfNameRecept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfNameRecept.setColumns(10);
		tfNameRecept.setBounds(150, 168, 135, 20);
		pnAddRecept.add(tfNameRecept);

		JLabel lbNameRecept = new JLabel("Name");
		lbNameRecept.setForeground(new Color(0, 128, 0));
		lbNameRecept.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbNameRecept.setBounds(48, 174, 46, 14);
		pnAddRecept.add(lbNameRecept);

		tfAgeRecept = new JTextField();
		tfAgeRecept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfAgeRecept.setColumns(10);
		tfAgeRecept.setBounds(150, 214, 135, 20);
		pnAddRecept.add(tfAgeRecept);

		JLabel lbAgeRecept = new JLabel("Age");
		lbAgeRecept.setForeground(new Color(0, 128, 0));
		lbAgeRecept.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbAgeRecept.setBounds(48, 220, 46, 14);
		pnAddRecept.add(lbAgeRecept);

		tfAddressRecept = new JTextField();
		tfAddressRecept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfAddressRecept.setColumns(10);
		tfAddressRecept.setBounds(532, 79, 135, 20);
		pnAddRecept.add(tfAddressRecept);

		JLabel lbAddressRecept = new JLabel("Address");
		lbAddressRecept.setForeground(new Color(0, 128, 0));
		lbAddressRecept.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbAddressRecept.setBounds(405, 81, 60, 14);
		pnAddRecept.add(lbAddressRecept);

		tfPhoneRecept = new JTextField();
		tfPhoneRecept.setText("03");
		tfPhoneRecept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPhoneRecept.setColumns(10);
		tfPhoneRecept.setBounds(532, 123, 135, 20);
		pnAddRecept.add(tfPhoneRecept);

		JLabel lbPhoneRecept = new JLabel("Phone Number");
		lbPhoneRecept.setForeground(new Color(0, 128, 0));
		lbPhoneRecept.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbPhoneRecept.setBounds(405, 127, 109, 14);
		pnAddRecept.add(lbPhoneRecept);

		JLabel lbGenderRecept = new JLabel("Gender");
		lbGenderRecept.setForeground(new Color(0, 128, 0));
		lbGenderRecept.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbGenderRecept.setBounds(48, 260, 46, 14);
		pnAddRecept.add(lbGenderRecept);

		JLabel lbStatusRecept = new JLabel("Maritial Status");
		lbStatusRecept.setForeground(new Color(0, 128, 0));
		lbStatusRecept.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbStatusRecept.setBounds(405, 173, 92, 14);
		pnAddRecept.add(lbStatusRecept);

		JComboBox cbStatusRecept = new JComboBox();
		cbStatusRecept.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbStatusRecept.setModel(new DefaultComboBoxModel(
				new String[]{"Select Item", "Single", "Maried", "Divorced"}));
		cbStatusRecept.setBounds(532, 170, 135, 20);
		pnAddRecept.add(cbStatusRecept);

		JComboBox cbGenderRecept = new JComboBox();
		cbGenderRecept.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbGenderRecept.setModel(new DefaultComboBoxModel(
				new String[]{"Selected Item", "Male", "Female"}));
		cbGenderRecept.setBounds(150, 255, 135, 20);
		pnAddRecept.add(cbGenderRecept);

		JButton btClearRecept = new JButton("Clear");
		btClearRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tfDateRecept.setText("");
				tfNameRecept.setText("");
				tfPhoneRecept.setText("03");
				tfIDRecept.setText("");
				tfAddressRecept.setText("");
				tfAgeRecept.setText("");
				tfEmailRecept.setText("");
				tfBloodRecept.setText("");
				tfUsernameRecept.setText("");
				tfPasswordRecept.setText("");
				cbGenderRecept.setSelectedIndex(0);
				cbStatusRecept.setSelectedIndex(0);

			}
		});
		btClearRecept.setForeground(Color.RED);
		btClearRecept.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btClearRecept.setBackground(Color.CYAN);
		btClearRecept.setBounds(189, 424, 89, 57);
		pnAddRecept.add(btClearRecept);

		JButton btAddMoreRecept = new JButton("Add");
		btAddMoreRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "insert into receptionist(joining,id,name,age,gender,blood,email,phone,address,status,username,password) values(?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					con.ptmt = con.conn.prepareStatement(sql);
					con.ptmt.setString(1, tfDateRecept.getText());
					con.ptmt.setString(2, tfIDRecept.getText());
					con.ptmt.setString(3, tfNameRecept.getText());
					con.ptmt.setInt(4, Integer.parseInt(tfAgeRecept.getText()));
					con.ptmt.setObject(5, cbGenderRecept.getSelectedItem());
					con.ptmt.setString(6, tfBloodRecept.getText());
					con.ptmt.setString(7, tfEmailRecept.getText());
					con.ptmt.setString(8, tfPhoneRecept.getText());
					con.ptmt.setString(9, tfAddressRecept.getText());
					con.ptmt.setObject(10, cbStatusRecept.getSelectedItem());
					con.ptmt.setString(11, tfUsernameRecept.getText());
					con.ptmt.setString(12, tfPasswordRecept.getText());
					checkSql = con.ptmt.executeUpdate();
					if (checkSql != 0)
						JOptionPane.showConfirmDialog(pnAddRecept, "Success",
								"", JOptionPane.DEFAULT_OPTION);
					else
						JOptionPane.showConfirmDialog(pnAddRecept, "No Success",
								"", JOptionPane.DEFAULT_OPTION,
								JOptionPane.ERROR_MESSAGE);
					con.ptmt.close();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btAddMoreRecept.setForeground(Color.RED);
		btAddMoreRecept.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btAddMoreRecept.setBackground(new Color(0, 0, 205));
		btAddMoreRecept.setBounds(502, 424, 89, 57);
		pnAddRecept.add(btAddMoreRecept);

		JLabel lbBloodRecept = new JLabel("Blood");
		lbBloodRecept.setForeground(new Color(0, 128, 0));
		lbBloodRecept.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbBloodRecept.setBounds(405, 262, 46, 14);
		pnAddRecept.add(lbBloodRecept);

		tfBloodRecept = new JTextField();
		tfBloodRecept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfBloodRecept.setColumns(10);
		tfBloodRecept.setBounds(532, 256, 135, 20);
		pnAddRecept.add(tfBloodRecept);

		JLabel lbUsernameRecept = new JLabel("Username");
		lbUsernameRecept.setForeground(new Color(0, 128, 0));
		lbUsernameRecept.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbUsernameRecept.setBounds(724, 168, 70, 14);
		pnAddRecept.add(lbUsernameRecept);

		tfUsernameRecept = new JTextField();
		tfUsernameRecept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfUsernameRecept.setColumns(10);
		tfUsernameRecept.setBounds(828, 157, 222, 31);
		pnAddRecept.add(tfUsernameRecept);

		JLabel lbPasswordRecept = new JLabel("Password");
		lbPasswordRecept.setForeground(new Color(0, 128, 0));
		lbPasswordRecept.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbPasswordRecept.setBounds(724, 236, 76, 14);
		pnAddRecept.add(lbPasswordRecept);

		tfPasswordRecept = new JTextField();
		tfPasswordRecept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPasswordRecept.setColumns(10);
		tfPasswordRecept.setBounds(828, 227, 222, 31);
		pnAddRecept.add(tfPasswordRecept);

		tfEmailRecept = new JTextField();
		tfEmailRecept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfEmailRecept.setColumns(10);
		tfEmailRecept.setBounds(532, 214, 135, 20);
		pnAddRecept.add(tfEmailRecept);

		JLabel lbEmailRecept = new JLabel("Email");
		lbEmailRecept.setForeground(new Color(0, 128, 0));
		lbEmailRecept.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lbEmailRecept.setBounds(405, 218, 46, 14);
		pnAddRecept.add(lbEmailRecept);

		pnUpdateRecept = new JPanel();
		pnUpdateRecept.setLayout(null);
		frame.getContentPane().add(pnUpdateRecept, "name_33855778419299");

		JLabel lbUpdateRecept = new JLabel("Update Receptionist");
		lbUpdateRecept.setOpaque(true);
		lbUpdateRecept.setHorizontalTextPosition(SwingConstants.CENTER);
		lbUpdateRecept.setHorizontalAlignment(SwingConstants.CENTER);
		lbUpdateRecept.setForeground(Color.WHITE);
		lbUpdateRecept.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbUpdateRecept.setBackground(new Color(34, 139, 34));
		lbUpdateRecept.setBounds(26, 11, 887, 57);
		pnUpdateRecept.add(lbUpdateRecept);

		JButton button_14 = new JButton("New button");
		button_14.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_14.setBackground(new Color(34, 139, 34));
		button_14.setBounds(980, 11, 70, 57);
		pnUpdateRecept.add(button_14);

		JButton btBackUpdateRecept = new JButton("New button");
		btBackUpdateRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnUpdateRecept.setVisible(false);
				pnRecept.setVisible(true);
			}
		});
		btBackUpdateRecept.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackUpdateRecept.setBackground(new Color(34, 139, 34));
		btBackUpdateRecept.setBounds(911, 11, 70, 57);
		pnUpdateRecept.add(btBackUpdateRecept);

		JButton btUpdateMoreRecept = new JButton("Update");
		btUpdateMoreRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = update(tbUpdateRecept,
						tbUpdateRecept.getEditingRow(),
						tbUpdateRecept.getEditingColumn());
				if (check)

					JOptionPane.showConfirmDialog(pnUpdateRecept,
							"Update Success", "", JOptionPane.DEFAULT_OPTION);

				else
					JOptionPane.showConfirmDialog(pnUpdateRecept, "No Success",
							"", JOptionPane.DEFAULT_OPTION,
							JOptionPane.ERROR_MESSAGE);
			}
		});
		btUpdateMoreRecept.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btUpdateMoreRecept.setBackground(new Color(50, 205, 50));
		btUpdateMoreRecept.setBounds(463, 419, 89, 39);
		pnUpdateRecept.add(btUpdateMoreRecept);

		JScrollPane spUpdateRecept = new JScrollPane();
		spUpdateRecept.setBounds(10, 108, 1050, 290);
		pnUpdateRecept.add(spUpdateRecept);

		tbUpdateRecept = new JTable();
		spUpdateRecept.setViewportView(tbUpdateRecept);

		pnViewRecept = new JPanel();
		pnViewRecept.setLayout(null);
		frame.getContentPane().add(pnViewRecept, "name_34375642319900");

		JLabel lbViewRecept = new JLabel("View Receptionist");
		lbViewRecept.setOpaque(true);
		lbViewRecept.setHorizontalTextPosition(SwingConstants.CENTER);
		lbViewRecept.setHorizontalAlignment(SwingConstants.CENTER);
		lbViewRecept.setForeground(Color.WHITE);
		lbViewRecept.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbViewRecept.setBackground(new Color(220, 20, 60));
		lbViewRecept.setBounds(26, 11, 885, 57);
		pnViewRecept.add(lbViewRecept);

		JButton button_15 = new JButton("New button");
		button_15.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_15.setBackground(Color.PINK);
		button_15.setBounds(980, 11, 70, 57);
		pnViewRecept.add(button_15);

		JButton btBackViewRecept = new JButton("New button");
		btBackViewRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnViewRecept.setVisible(false);
				pnRecept.setVisible(true);
			}
		});
		btBackViewRecept.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackViewRecept.setBackground(Color.PINK);
		btBackViewRecept.setBounds(911, 11, 70, 57);
		pnViewRecept.add(btBackViewRecept);

		JScrollPane spViewRecept = new JScrollPane();
		spViewRecept.setBounds(10, 132, 1040, 293);
		pnViewRecept.add(spViewRecept);

		tbViewRecept = new JTable();
		spViewRecept.setViewportView(tbViewRecept);

		pnSearchRecept = new JPanel();
		pnSearchRecept.setLayout(null);
		frame.getContentPane().add(pnSearchRecept, "name_36854266031700");

		lbSearchRecept = new JLabel("Search Receptionist");
		lbSearchRecept.setOpaque(true);
		lbSearchRecept.setHorizontalTextPosition(SwingConstants.CENTER);
		lbSearchRecept.setHorizontalAlignment(SwingConstants.CENTER);
		lbSearchRecept.setForeground(Color.WHITE);
		lbSearchRecept.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbSearchRecept.setBackground(Color.RED);
		lbSearchRecept.setBounds(26, 11, 859, 57);
		pnSearchRecept.add(lbSearchRecept);

		JButton button_17 = new JButton("New button");
		button_17.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_17.setBackground(Color.RED);
		button_17.setBounds(952, 11, 70, 57);
		pnSearchRecept.add(button_17);

		JButton btBackSearchRecept = new JButton("New button");
		btBackSearchRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnSearchRecept.setVisible(false);
				pnRecept.setVisible(true);
			}
		});
		btBackSearchRecept.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackSearchRecept.setBackground(Color.RED);
		btBackSearchRecept.setBounds(883, 11, 70, 57);
		pnSearchRecept.add(btBackSearchRecept);

		JScrollPane spSearchRecept = new JScrollPane();
		spSearchRecept.setBounds(10, 188, 1012, 293);
		pnSearchRecept.add(spSearchRecept);

		tbSearchRecept = new JTable();
		spSearchRecept.setViewportView(tbSearchRecept);

		JLabel lbNameOfRecept = new JLabel("NAME OF RECEPTIONIST");
		lbNameOfRecept.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNameOfRecept.setForeground(new Color(50, 205, 50));
		lbNameOfRecept.setFont(new Font("Jokerman", Font.PLAIN, 21));
		lbNameOfRecept.setBounds(22, 79, 320, 85);
		pnSearchRecept.add(lbNameOfRecept);

		tfNameOfRecept = new JTextField();
		tfNameOfRecept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfNameOfRecept.setColumns(10);
		tfNameOfRecept.setBounds(352, 96, 548, 52);
		pnSearchRecept.add(tfNameOfRecept);

		JButton btSearchMoreRecept = new JButton("SEARCH");
		btSearchMoreRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search(tbSearchRecept, tfNameOfRecept);

			}
		});
		btSearchMoreRecept.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btSearchMoreRecept.setBackground(Color.BLUE);
		btSearchMoreRecept.setBounds(910, 98, 89, 52);
		pnSearchRecept.add(btSearchMoreRecept);

		pnDeleteRecept = new JPanel();
		pnDeleteRecept.setLayout(null);
		frame.getContentPane().add(pnDeleteRecept, "name_40569470508200");

		JLabel lbDeleteRecept = new JLabel("Delete Receptionist");
		lbDeleteRecept.setOpaque(true);
		lbDeleteRecept.setHorizontalTextPosition(SwingConstants.CENTER);
		lbDeleteRecept.setHorizontalAlignment(SwingConstants.CENTER);
		lbDeleteRecept.setForeground(Color.WHITE);
		lbDeleteRecept.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbDeleteRecept.setBackground(Color.CYAN);
		lbDeleteRecept.setBounds(47, 11, 841, 57);
		pnDeleteRecept.add(lbDeleteRecept);

		JButton button_18 = new JButton("New button");
		button_18.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\cross.png"));
		button_18.setBackground(Color.CYAN);
		button_18.setBounds(954, 11, 70, 57);
		pnDeleteRecept.add(button_18);

		JButton btBackDeleteRecept = new JButton("New button");
		btBackDeleteRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnDeleteRecept.setVisible(false);
				pnRecept.setVisible(true);
			}
		});
		btBackDeleteRecept.setIcon(new ImageIcon(
				"C:\\Users\\DELL\\Desktop\\de thi JDBC\\de2\\Hospital-Management-System-master\\Hospital-Management-System-master\\src\\Icon\\backs.png"));
		btBackDeleteRecept.setBackground(Color.CYAN);
		btBackDeleteRecept.setBounds(886, 11, 70, 57);
		pnDeleteRecept.add(btBackDeleteRecept);

		JScrollPane spDeleteRecept = new JScrollPane();
		spDeleteRecept.setBounds(10, 222, 1012, 259);
		pnDeleteRecept.add(spDeleteRecept);

		tbDeleteRecept = new JTable();
		spDeleteRecept.setViewportView(tbDeleteRecept);

		JLabel lbNameDeleteRecept = new JLabel("NAME OF RECEPTIONIST");
		lbNameDeleteRecept.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNameDeleteRecept.setForeground(new Color(50, 205, 50));
		lbNameDeleteRecept.setFont(new Font("Jokerman", Font.PLAIN, 21));
		lbNameDeleteRecept.setBounds(10, 105, 320, 85);
		pnDeleteRecept.add(lbNameDeleteRecept);

		tfNameDeleteRecept = new JTextField();
		tfNameDeleteRecept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfNameDeleteRecept.setColumns(10);
		tfNameDeleteRecept.setBounds(340, 122, 548, 52);
		pnDeleteRecept.add(tfNameDeleteRecept);

		JButton btDeleteMoreRecept = new JButton("DELETE");
		btDeleteMoreRecept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteModel(tbDeleteRecept, tfNameDeleteRecept.getText());

			}
		});
		btDeleteMoreRecept.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btDeleteMoreRecept.setBackground(Color.BLUE);
		btDeleteMoreRecept.setBounds(898, 124, 89, 52);
		pnDeleteRecept.add(btDeleteMoreRecept);

	}
}
