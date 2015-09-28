package walletManager;

import java.sql.*;

public class dbDriver {
    private Connection connection = null;
    private String dbName;
    private String dbServer;
    private Statement st = null;
    
    public dbDriver() {
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    public void initDatabase(String dbName, String dbServer, String user, String pass) {
	this.dbName = dbName;
	this.dbServer = dbServer;
	if (this.connection == null || this.st == null) {
	    try {
		this.connection = DriverManager.getConnection("jdbc:mysql://" + dbServer + "/mysql", user, pass);
		    this.st = connection.createStatement();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	try {
	    this.st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    public void resetDatabase(String user, String pass) {
	if (this.connection == null || this.st == null) {
	    try {
		this.connection = DriverManager.getConnection("jdbc:mysql://" + dbServer + "/mysql", user, pass);
		    this.st = connection.createStatement();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}

	try {
	    this.st.executeUpdate("DROP DATABASE " + this.dbName);
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
