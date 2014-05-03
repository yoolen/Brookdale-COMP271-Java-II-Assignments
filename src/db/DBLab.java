package db;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

import javax.swing.*;

import java.sql.*;

import javax.swing.border.*;


public class DBLab extends JApplet {
  boolean isStandalone = false;
  JPanel jpDisplay = new JPanel();
  JLabel jlblStatus = new JLabel();
  JPanel jpButtons = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jpStaff = new JPanel();
  JButton jbtView = new JButton("View");
  JButton jbtInsert = new JButton("Insert");
  JButton jbtUpdate = new JButton("Update");
  JButton jbtClear = new JButton("Clear");
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JLabel jLabelid = new JLabel("ID");
  JLabel jLabellname = new JLabel("Last Name");
 
  FlowLayout flowLayout = new FlowLayout();
 
  JTextField jtfID = new JTextField(11);
  JTextField jtfLastName = new JTextField(10);
  JLabel jLabelfname = new JLabel("First Name");
  JTextField jtfFirstName = new JTextField(10); 
 
  JLabel jLabelcity = new JLabel("City");
  JTextField jtfCity = new JTextField(15);

  JLabel jLabelstate = new JLabel("State");
  JTextField jtfState = new JTextField(2);
 
  JLabel jLabelphone = new JLabel("Telephone");
  JTextField jtfTelephone = new JTextField(12);
 

  // The Statement for processing queries
  Statement stmt;
  TitledBorder titledBorder1;
  GridLayout gridLayout1 = new GridLayout();

  /**Initialize the applet*/
  public void init() {
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    this.setSize(400,300);
    jpDisplay.setLayout(borderLayout1);
    jpStaff.setLayout(gridLayout1);
   
    jbtView.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jbtView_actionPerformed(e);
      }
    });
  
    jbtInsert.addActionListener(new java.awt.event.ActionListener(){
      public void actionPerformed(ActionEvent e) {
        jbtInsert_actionPerformed(e);
      }
    });
   
    jbtUpdate.addActionListener(new java.awt.event.ActionListener(){
      public void actionPerformed(ActionEvent e) {
        jbtUpdate_actionPerformed(e);
      }
    });
   
    jbtClear.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jbtClear_actionPerformed(e);
      }
    });
    jPanel5.setLayout(flowLayout);
    jPanel4.setLayout(flowLayout);
    jPanel3.setLayout(flowLayout);
    jPanel2.setLayout(flowLayout);
    jPanel1.setLayout(flowLayout);
    
    jLabellname.setText("Last Name");
    
    flowLayout.setAlignment(0);   
   
    jtfID.setBackground(Color.yellow);    
   
    jlblStatus.setBackground(Color.pink);
    jlblStatus.setText("Connecting ...");
    jpStaff.setBorder(titledBorder1);
    titledBorder1.setTitle("Staff Information");
    gridLayout1.setColumns(1);
    gridLayout1.setRows(5);
    this.getContentPane().add(jpDisplay, BorderLayout.CENTER);
    jpDisplay.add(jpButtons, BorderLayout.SOUTH);
    jpButtons.add(jbtView, null);
    jpButtons.add(jbtInsert, null);
    jpButtons.add(jbtUpdate, null);
    jpButtons.add(jbtClear, null);
    jpDisplay.add(jpStaff, BorderLayout.CENTER);
    jpStaff.add(jPanel1, null);
    jPanel1.add(jLabelid, null);
    jPanel1.add(jtfID, null);
    jpStaff.add(jPanel2, null);
    jPanel2.add(jLabellname, null);
    jPanel2.add(jtfLastName, null);
    jPanel2.add(jLabelfname, null);
    jPanel2.add(jtfFirstName, null);
    
  
    jpStaff.add(jPanel4, null);
    jPanel4.add(jLabelcity, null);
    jPanel4.add(jtfCity, null);
    jPanel4.add(jLabelstate, null);
    jPanel4.add(jtfState, null);
    jpStaff.add(jPanel5, null);
    jPanel5.add(jLabelphone, null);
    jPanel5.add(jtfTelephone, null);
   
    this.getContentPane().add(jlblStatus, BorderLayout.SOUTH);

    // Connect to the database
    initializeDB();
  }

  private void initializeDB() {
    try {
      // Load the driver
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded\n");

      // Connect to the local InterBase database
      Connection conn = DriverManager.getConnection
//        ("jdbc:odbc:exampleMDBDataSource", "", "" );
        ("jdbc:mysql://localhost/project", "root", "");
      System.out.println("Database connected\n");

      jlblStatus.setText("Database connected");

      // Create a statement
      stmt = conn.createStatement();
    }
    catch (Exception ex) {
      jlblStatus.setText("Connection failed: " + ex);
    }
  }

  void jbtInsert_actionPerformed(ActionEvent e) {
    insert();
  }

  void jbtView_actionPerformed(ActionEvent e) {
    view();
  }

  void jbtUpdate_actionPerformed(ActionEvent e) {
    update();
  }

  void jbtClear_actionPerformed(ActionEvent e) {
    clear();
  }

  /**View record by ID*/
  private void view() {
  // Build a SQL SELECT statement
    String select = "select * from staff where id = '" + jtfID.getText() + "';";

    try {
      // Execute query
    	ResultSet rs = stmt.executeQuery(select);
     // and populate the fields on the screen
    	if(rs.next()){
    		 jtfLastName.setText(rs.getString(2));
    		 jtfFirstName.setText(rs.getString(3));      
    		 jtfCity.setText(rs.getString(4));
    		 jtfState.setText(rs.getString(5));
    		 jtfTelephone.setText(rs.getString(6));
    		 jlblStatus.setText("Staff member found!");
    	}
    	else{
   	  	 	this.clear();
    		jlblStatus.setText("Staff member not found!");
    	}
    }
    catch(Exception ex) {
      jlblStatus.setText("Select failed: " + ex);
    }
  }

 
  /**Insert a new record*/
  private void insert() {
    // Build a SQL INSERT statement
     String insert = "insert into staff values ('" + jtfID.getText().trim() + "','" +
    	      jtfLastName.getText().trim() + "','" + jtfFirstName.getText().trim() + "','" +      
    	      jtfCity.getText().trim() + "','" + jtfState.getText().trim() + "','" +
    	      jtfTelephone.getText().trim() + "',null);"; // needed to include null for formatting
     
     //System.out.println(insert); // use this to check for errors

	 // execute the statement
    try {
		stmt.executeUpdate(insert);
		jlblStatus.setText("Insert succeeded!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		jlblStatus.setText("Insert failed!");
	}
    
  }

  /**Update a record*/
  private void update() {
 // Build a SQL UPDATE statement
    String updateStmt = "UPDATE Staff " +
      "SET LastName = '" + jtfLastName.getText().trim() + "'," +
      "FirstName = '" + jtfFirstName.getText().trim() + "'," +      
      "City = '" + jtfCity.getText().trim() + "'," +
      "State = '" + jtfState.getText().trim() + "'," +
      "Telephone = '" + jtfTelephone.getText().trim() + "' " +
      "WHERE ID = '" + jtfID.getText().trim() + "'";

    try {
      stmt.executeUpdate(updateStmt);
      jlblStatus.setText("Record updated");
    }
    catch(SQLException ex) {
      jlblStatus.setText("Update failed: " + ex);
    }
    
    
  }
  /**Clear text fields*/
  private void clear() {
	  	 jtfID.setText("");
		 jtfLastName.setText("");
		 jtfFirstName.setText("");      
		 jtfCity.setText("");
		 jtfState.setText("");
		 jtfTelephone.setText("");
  }
  
  /**Main method*/
  public static void main(String[] args) {
    DBLab applet = new DBLab();
    applet.isStandalone = true;
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(3);
    frame.setTitle("DB Lab");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    applet.init();  
    frame.setSize(400,320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
  }