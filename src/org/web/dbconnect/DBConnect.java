package org.web.dbconnect;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnect {

	public static Connection getConnection() {

		Connection conn = null;
		DataSource dataSource;

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/MysqlDB");
			conn = dataSource.getConnection();
			if (conn != null) {
				System.out.println("can Access to DB");
			} else {
				System.out.println("fail to connect to DB. Try again.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return conn;
	}
}
