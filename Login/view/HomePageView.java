package view;

import java.awt.EventQueue;
 

import model.BenhNhan;
import model.ResultSetTableModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.xdevapi.PreparableStatement;

import dao.BenhNhanDAO;
import database.ketnoiquanli;
import model.BenhNhan;

import java.awt.FlowLayout;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class HomePageView extends JFrame {
	

	private JPanel HPPanel;
	private JTabbedPane tabbedPane;
	private JComboBox comboBox;
	private JTextField nameTF;
	private JTextField hoVaTentf;
	private JTextField gioiTinhtf;
	private JTextField ngaySinhtf;
	private JTextField queQuantf;
	private JTextField tenBenhtf;
	private JTextField ngayVaoVientf;
	private JTextField tenBacSitf;
	private JTextField phongtf;
	private JTextField maBNtf;
	private JTable homeTable, managerTable, tenTable;
	private JScrollPane homeScrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePageView frame = new HomePageView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePageView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 669);
		this.setLocationRelativeTo(null);
		HPPanel = new JPanel();
		HPPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.loadDataToJTable_quanLy();
		setContentPane(HPPanel);
		HPPanel.setLayout(new BoxLayout(HPPanel, BoxLayout.X_AXIS));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		HPPanel.add(tabbedPane);
		
		JPanel HomePanel = new JPanel();
		HomePanel.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Home", null, HomePanel, null);
		HomePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Qu???n L?? B???nh Nh??n");
		lblNewLabel.setBounds(279, 11, 408, 60);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 44));
		HomePanel.add(lblNewLabel);
		
		
		homeScrollPane = new JScrollPane();
		homeScrollPane.setBounds(10, 71, 905, 288);
		HomePanel.add(homeScrollPane);
		
		
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null},
//			},
//			new String[] {
//				"New column", "New column", "New column", "New column"
//			}
//		));
		
		
		JLabel lblNewLabel_1 = new JLabel("T??m ki???m theo:");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(82, 423, 140, 26);
		HomePanel.add(lblNewLabel_1);
		
		String cot[]= {"H??? V?? T??n B???nh Nh??n","Gi???i T??nh","Qu?? Qu??n","T??n B??c S??","T??n B???nh"};
		
		nameTF = new JTextField();
		nameTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nameTF.setBounds(368, 424, 352, 22);
		HomePanel.add(nameTF);
		nameTF.setColumns(10);
		
		
		JButton btnNewButton = new JButton("???");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				truyXuat();
			}
		});
		btnNewButton.setForeground(SystemColor.inactiveCaptionBorder);
		btnNewButton.setBackground(new Color(184, 126, 48));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(730, 424, 58, 23);
		HomePanel.add(btnNewButton);
		
		JButton seeAllButton = new JButton("Hi???n T???t C???");
		seeAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				homeScrollPane.setViewportView(homeTable);
			}
		});
		seeAllButton.setForeground(new Color(255, 255, 255));
		seeAllButton.setBackground(new Color(184, 126, 48));
		seeAllButton.setFont(new Font("Consolas", Font.BOLD, 18));
		seeAllButton.setBounds(360, 474, 179, 42);
		HomePanel.add(seeAllButton);
		
		JButton logoutButton = new JButton("Log out?");
		logoutButton.setFont(new Font("Tahoma", Font.ITALIC, 12));
		logoutButton.setBounds(826, 558, 89, 23);
		HomePanel.add(logoutButton);
		
		comboBox = new JComboBox(cot);
		comboBox.setBounds(226, 424, 134, 22);
		HomePanel.add(comboBox);
		logoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginView lv = new LoginView();
				lv.setVisible(true);
			}
		});
		
		JPanel ManagerPanel = new JPanel();
		ManagerPanel.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Manager", null, ManagerPanel, null);
		ManagerPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Qu???n L?? B???nh Nh??n");
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 44));
		lblNewLabel_2.setBounds(279, 11, 408, 60);
		ManagerPanel.add(lblNewLabel_2);
		
		JScrollPane managerScrollPane = new JScrollPane(managerTable);
		managerScrollPane.setBounds(10, 71, 905, 288);
		ManagerPanel.add(managerScrollPane);
		
		JLabel MaBNLabel_1 = new JLabel("Qu?? Qu??n:\r\n");
		MaBNLabel_1.setFont(new Font("Consolas", Font.BOLD, 13));
		MaBNLabel_1.setBounds(357, 410, 69, 29);
		ManagerPanel.add(MaBNLabel_1);
		
		JLabel MaBNLabel_2 = new JLabel("H??? V?? T??n B???nh Nh??n:");
		MaBNLabel_2.setFont(new Font("Consolas", Font.BOLD, 13));
		MaBNLabel_2.setBounds(20, 410, 146, 29);
		ManagerPanel.add(MaBNLabel_2);
		
		JLabel MaBNLabel_3 = new JLabel("T??n B???nh:");
		MaBNLabel_3.setFont(new Font("Consolas", Font.BOLD, 13));
		MaBNLabel_3.setBounds(357, 451, 69, 29);
		ManagerPanel.add(MaBNLabel_3);
		
		JLabel MaBNLabel_4 = new JLabel("Gi???i T??nh:");
		MaBNLabel_4.setFont(new Font("Consolas", Font.BOLD, 13));
		MaBNLabel_4.setBounds(91, 451, 76, 29);
		ManagerPanel.add(MaBNLabel_4);
		
		JLabel MaBNLabel_5 = new JLabel("Ng??y Sinh:\r\n");
		MaBNLabel_5.setFont(new Font("Consolas", Font.BOLD, 13));
		MaBNLabel_5.setBounds(350, 371, 76, 29);
		ManagerPanel.add(MaBNLabel_5);
		
		JLabel MaBNLabel_1_1 = new JLabel("T??n B??c S??:\r\n");
		MaBNLabel_1_1.setFont(new Font("Consolas", Font.BOLD, 13));
		MaBNLabel_1_1.setBounds(626, 408, 86, 29);
		ManagerPanel.add(MaBNLabel_1_1);
		
		JLabel MaBNLabel_3_1 = new JLabel("Ph??ng:");
		MaBNLabel_3_1.setFont(new Font("Consolas", Font.BOLD, 13));
		MaBNLabel_3_1.setBounds(661, 448, 51, 29);
		ManagerPanel.add(MaBNLabel_3_1);
		
		JLabel MaBNLabel_5_1 = new JLabel("Ng??y V??o Vi???n:");
		MaBNLabel_5_1.setFont(new Font("Consolas", Font.BOLD, 13));
		MaBNLabel_5_1.setBounds(600, 370, 112, 29);
		ManagerPanel.add(MaBNLabel_5_1);
		
		hoVaTentf = new JTextField();
		hoVaTentf.setColumns(10);
		hoVaTentf.setBounds(166, 413, 152, 20);
		ManagerPanel.add(hoVaTentf);
		
		gioiTinhtf = new JTextField();
		gioiTinhtf.setColumns(10);
		gioiTinhtf.setBounds(166, 453, 152, 20);
		ManagerPanel.add(gioiTinhtf);
		
		ngaySinhtf = new JTextField();
		ngaySinhtf.setColumns(10);
		ngaySinhtf.setBounds(430, 370, 137, 20);
		ManagerPanel.add(ngaySinhtf);
		
		queQuantf = new JTextField();
		queQuantf.setColumns(10);
		queQuantf.setBounds(429, 410, 138, 20);
		ManagerPanel.add(queQuantf);
		
		tenBenhtf = new JTextField();
		tenBenhtf.setColumns(10);
		tenBenhtf.setBounds(429, 450, 138, 20);
		ManagerPanel.add(tenBenhtf);
		
		ngayVaoVientf = new JTextField();
		ngayVaoVientf.setColumns(10);
		ngayVaoVientf.setBounds(711, 370, 156, 20);
		ManagerPanel.add(ngayVaoVientf);
		
		tenBacSitf = new JTextField();
		tenBacSitf.setColumns(10);
		tenBacSitf.setBounds(710, 410, 157, 20);
		ManagerPanel.add(tenBacSitf);
		
		phongtf = new JTextField();
		phongtf.setColumns(10);
		phongtf.setBounds(710, 450, 157, 20);
		ManagerPanel.add(phongtf);
		
		JButton btnNewButton_1 = new JButton("Th??m");
		btnNewButton_1.setFont(new Font("Consolas", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(184, 126, 48));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
				themm();
			}
		});
		btnNewButton_1.setBounds(266, 512, 98, 42);
		ManagerPanel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("X??a");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				xoa();
			}
		});
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setFont(new Font("Consolas", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(new Color(184, 126, 48));
		btnNewButton_1_1.setBounds(482, 512, 98, 42);
		ManagerPanel.add(btnNewButton_1_1);
		
		maBNtf = new JTextField();
		maBNtf.setColumns(10);
		maBNtf.setBounds(166, 372, 152, 20);
		ManagerPanel.add(maBNtf);
		
		JLabel MaBNLabel_4_1 = new JLabel("M?? B???nh Nh??n:");
		MaBNLabel_4_1.setFont(new Font("Consolas", Font.BOLD, 13));
		MaBNLabel_4_1.setBounds(69, 370, 98, 29);
		ManagerPanel.add(MaBNLabel_4_1);
		
		JButton btnNewButton_1_2 = new JButton("S???a");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				them();
				suaa();
			}
		});
		btnNewButton_1_2.setForeground(Color.WHITE);
		btnNewButton_1_2.setFont(new Font("Consolas", Font.BOLD, 20));
		btnNewButton_1_2.setBackground(new Color(184, 126, 48));
		btnNewButton_1_2.setBounds(374, 512, 98, 42);
		ManagerPanel.add(btnNewButton_1_2);
		
		managerTable.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int selectedRow = managerTable.getSelectedRow();
		        maBNtf.setText(managerTable.getValueAt(selectedRow, 0).toString());
		        hoVaTentf.setText(managerTable.getValueAt(selectedRow, 1).toString());
		        gioiTinhtf.setText(managerTable.getValueAt(selectedRow, 2).toString());
		        ngaySinhtf.setText(managerTable.getValueAt(selectedRow, 3).toString());
		        queQuantf.setText(managerTable.getValueAt(selectedRow, 4).toString());
		        tenBenhtf.setText(managerTable.getValueAt(selectedRow, 6).toString());
		        ngayVaoVientf.setText(managerTable.getValueAt(selectedRow, 5).toString());
		        tenBacSitf.setText(managerTable.getValueAt(selectedRow, 7).toString());
		        phongtf.setText(managerTable.getValueAt(selectedRow, 8).toString());
		    }
		});
		

		
	}
	public void loadDataToJTable_quanLy() {
		Connection con = null;
	    String url = "jdbc:mysql://localhost:3306/ketnoicsdl";
	    String user = "root";
	    String password = "";
	    String query = "SELECT * FROM benhnhan";
	    try {
	      con = DriverManager.getConnection(url, user, password);
	      Statement st = con.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      ResultSetMetaData rsmd = rs.getMetaData();
	      int columns = rsmd.getColumnCount();
	      DefaultTableModel dtm = new DefaultTableModel();
	      Vector columns_name = new Vector();
	      Vector data_rows = new Vector();
	      for (int i = 1; i <= columns; i++) {
	        columns_name.addElement(rsmd.getColumnName(i));
	      }
	      columns_name.setElementAt("M?? B???nh Nh??n", 0);
	      columns_name.setElementAt("H??? v?? T??n b???nh nh??n", 1);
	      columns_name.setElementAt("Gi???i t??nh", 2);
	      columns_name.setElementAt("Ng??y Sinh", 3);
	      columns_name.setElementAt("Qu?? qu??n", 4);
	      columns_name.setElementAt("T??n b???nh", 5);
	      columns_name.setElementAt("Ng??y v??o vi???n", 6);
	      columns_name.setElementAt("T??n b??c s??", 7);
	      columns_name.setElementAt("Ph??ng", 8);
	      dtm.setColumnIdentifiers(columns_name);
	      while (rs.next()) {
	        data_rows = new Vector();
	        for (int j = 1; j <= columns; j++) {
	          data_rows.addElement(rs.getString(j));
	        }
	        dtm.addRow(data_rows);
	      }
	      homeTable = new JTable(dtm);
	      homeTable.setFont(new Font("Arial", Font.BOLD, 14));
	      managerTable = new JTable(dtm);
	      managerTable.setFont(new Font("Arial", Font.BOLD, 14));
//	      table = new JTable(dtm);
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    }
	}
	
	public void truyXuat() {
		
		Connection con = null;
	    String url = "jdbc:mysql://localhost:3306/ketnoicsdl";
	    String user = "root";
	    String password = "";
	    
	    try {
	    	String cbb = (String) comboBox.getSelectedItem();
	    	String tf = nameTF.getText();
	    	String cbbText="";
	    	
	    	switch (cbb) {
	    		case "H??? v?? T??n B???nh Nh??n":{
	    			cbbText="hoVaTen";
	    			break;
	    		}
	    		case "Gi???i T??nh":{
	    			cbbText="gioiTinh";
	    			break;
	    		}case "Qu?? Qu??n":{
	    			cbbText="queQuan";
	    			break;
	    		}case "T??n B??c S??":{
	    			cbbText="tenBacSi";
	    			break;
	    		}
	    		case "T??n B???nh":{
	    			cbbText="tenBenh";
	    			break;
	    		}
	    		
	    	}
	    	
	    	String query ="SELECT * FROM benhnhan where "+cbbText+"='"+tf+"'";
	    	
	    	System.out.print(query);
	      con = DriverManager.getConnection(url, user, password);
	      Statement st = con.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      ResultSetMetaData rsmd = rs.getMetaData();
	      int columns = rsmd.getColumnCount();
	      DefaultTableModel dtm = new DefaultTableModel();
	      Vector columns_name = new Vector();
	      Vector data_rows = new Vector();
	      for (int i = 1; i <= columns; i++) {
	        columns_name.addElement(rsmd.getColumnName(i));
	      }
	      columns_name.setElementAt("M?? B???nh Nh??n", 0);
	      columns_name.setElementAt("H??? v?? T??n b???nh nh??n", 1);
	      columns_name.setElementAt("Gi???i t??nh", 2);
	      columns_name.setElementAt("Ng??y Sinh", 3);
	      columns_name.setElementAt("Qu?? qu??n", 4);
	      columns_name.setElementAt("Ng??y v??o vi???n", 5);
	      columns_name.setElementAt("T??n b???nh", 6);
	      columns_name.setElementAt("T??n b??c s??", 7);
	      columns_name.setElementAt("Ph??ng", 8);
	      dtm.setColumnIdentifiers(columns_name);
	      while (rs.next()) {
	        data_rows = new Vector();
	        for (int j = 1; j <= columns; j++) {
	          data_rows.addElement(rs.getString(j));
	        }
	        dtm.addRow(data_rows);
	      }
	      tenTable = new JTable(dtm);
	      tenTable.setFont(new Font("Arial", Font.BOLD, 14));
//	      table = new JTable(dtm);
	      homeScrollPane.setViewportView(tenTable);
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    }
	}
	
	public void delete() {
		DefaultTableModel model = (DefaultTableModel) managerTable.getModel();
		int selectedRow = managerTable.getSelectedRow();
		if (selectedRow != -1) {
		    model.removeRow(selectedRow);
		}
	}
	
public void xoa() {
		
		
	    try {Connection con = ketnoiquanli.getConnection();
	    	
	    	String maBN = maBNtf.getText();
			 String hvt = hoVaTentf.getText();
			 String gt = gioiTinhtf.getText();
			 String ns = ngaySinhtf.getText();
			 String qq = queQuantf.getText();
			 String tb = tenBenhtf.getText();
			 String nvv = ngayVaoVientf.getText();
			 String tbs = tenBacSitf.getText();
			 int p = Integer.parseInt(phongtf.getText());
	    	
	    	String query =" DELETE FROM benhnhan "+
					" Where MaBN="+maBN+"'";
	    	
	    	System.out.print(query);
	      Statement st = con.createStatement();
	      int c = st.executeUpdate(query);
	      
	      ketnoiquanli.closeConnection(con);
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    }
	}
	
	

	
	public void themm() {
		
		
	    try {
	    	Connection con = ketnoiquanli.getConnection();
	    	
	    	String maBN = maBNtf.getText();
			 String hvt = hoVaTentf.getText();
			 String gt = gioiTinhtf.getText();
			 String ns = ngaySinhtf.getText();
			 String qq = queQuantf.getText();
			 String tb = tenBenhtf.getText();
			 String nvv = ngayVaoVientf.getText();
			 String tbs = tenBacSitf.getText();
			 int p = Integer.parseInt(phongtf.getText());
	    	
	    	String query ="INSERT INTO benhnhan (hoVaten, gioiTinh, ngaySinh, queQuan, ngayVaoVien, tenBenh, tenBacSi, phong)"+
					" VALUES ('"+maBN+"','"+hvt+"','"+gt+"','"+ns+"','"+qq+"','"+tb+"','"+
					nvv+"','"+tbs+"',"+p+")";
	    	
	    	System.out.print(query);
//	      con = DriverManager.getConnection(url, user, password);
	      Statement st = con.createStatement();
	      int c = st.executeUpdate(query);
	      
	      ketnoiquanli.closeConnection(con);
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    }
	}
	


	
	public void them() {
		String maBN = maBNtf.getText();
		 String hvt = hoVaTentf.getText();
		 String gt = gioiTinhtf.getText();
		 String ns = ngaySinhtf.getText();
		 String qq = queQuantf.getText();
		 String tb = tenBenhtf.getText();
		 String nvv = ngayVaoVientf.getText();
		 String tbs = tenBacSitf.getText();
		 int p = Integer.parseInt(phongtf.getText());
		
		DefaultTableModel model = (DefaultTableModel) managerTable.getModel();
		model.addRow(new Object[] {	maBN, 
									hvt, 
									gt, 
									ns,  
									qq, 
									tb, 
									nvv,
									tbs,
									p});

		

	}
	
public void suaa() {
		
		
	    
	    try {
	    	Connection con = ketnoiquanli.getConnection();
	    	String maBN = maBNtf.getText();
			 String hvt = hoVaTentf.getText();
			 String gt = gioiTinhtf.getText();
			 String ns = ngaySinhtf.getText();
			 String qq = queQuantf.getText();
			 String tb = tenBenhtf.getText();
			 String nvv = ngayVaoVientf.getText();
			 String tbs = tenBacSitf.getText();
			 int p = Integer.parseInt(phongtf.getText());
	    	
	    	String query =" UPDATE benhnhan "+
					" SET "+
					" hoVaTen= '"+ hvt+"',"+
					" gioiTinh= '"+ gt+"',"+
					" ngaySinh= '"+ ns+"',"+
					" queQuan= '"+ qq+"',"+
					" ngayVaoVien= '"+ nvv+"',"+
					" tenBenh= '"+ tb+"',"+
					" tenBacSi= '"+ tbs+"',"+
					" phong= "+ p+
					" Where MaBN="+maBN+"'";
	    	
	    	System.out.print(query);

	      Statement st = con.createStatement();
	      int c = st.executeUpdate(query);
	      
	      ketnoiquanli.closeConnection(con);
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    }
	}
	

}
