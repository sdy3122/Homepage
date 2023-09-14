package kr.co.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
static final String driverName = "com.mysql.cj.jdbc.Driver";
static final String url="jdbc:mysql://127.0.0.1:3306/homepage_db";
static final String user="root";
static final String passwd="0000";
public JDBCUtil() {
	
}
public static Connection connect() {
	Connection conn = null;
	try {
		Class.forName(driverName);
		conn = DriverManager.getConnection(url, user, passwd);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return conn;
}
public static void disconnect(Statement stmt,Connection conn) {
	try {
		stmt.close();
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
