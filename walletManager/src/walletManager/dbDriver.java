package walletManager;

import java.sql.*;

public class dbDriver {
    private Connection connection;
    private String dbName;
    private String dbServer;
    
    public dbDriver() {
	
    }
    
    private void init() {
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    public void initDatabase(String dbName, String dbServer, String user, String pass) {
	init();
	this.dbName = dbName;
	this.dbServer = dbServer;
	try {
	    this.connection = DriverManager.getConnection("jdbc:mysql://" + dbServer + "/mysql", user, pass);
	    Statement st = connection.createStatement();
	    st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public void resetDatabase(String user, String pass) {
	init();
	try {
	    this.connection = DriverManager.getConnection("jdbc:mysql://" + dbServer +"/mysql", user, pass);
	    Statement st = connection.createStatement();
	    st.executeUpdate("DROP DATABASE " + this.dbName);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public void closeDatabse() {
	try {
	    this.connection.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public void addTransaction(Transaction transaction) {
	// TODO
    }
}
