package com.masai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DButil {
    
	  private static final String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=BuseData;user=sa;password=reallyStrongPwd1234";

	    public static Connection provideConnection() {
	        try {
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            Properties props = new Properties();
	            props.setProperty("encrypt", "false");
	            props.setProperty("trustServerCertificate", "true");
	            Connection connection = DriverManager.getConnection(connectionUrl, props);
	            return connection;
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
}