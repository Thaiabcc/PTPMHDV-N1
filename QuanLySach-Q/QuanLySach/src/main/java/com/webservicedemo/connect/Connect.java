package com.webservicedemo.connect;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Connect {

	public static Connection getConnection() {
		Connection c = null;
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String url = "jdbc:sqlserver://localhost:1433;databaseName=PTPMHDV;encrypt=true;trustServerCertificate=true";
			String taiKhoan = "sa";
			String matKhau = "12345678";
			c = DriverManager.getConnection(url, taiKhoan, matKhau);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null)
				c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
