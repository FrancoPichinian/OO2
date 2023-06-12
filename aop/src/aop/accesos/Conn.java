package aop.accesos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class Conn {
	private static final String URL = "jdbc:mysql://localhost:3306/aop";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public Connection abrir() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
