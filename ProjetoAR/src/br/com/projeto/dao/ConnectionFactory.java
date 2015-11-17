package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Fabrica de Conexoes
 * 
 * Conexao com banco de dados MySQL
 * 
 * */
public class ConnectionFactory {
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoteste", "root", "d04m10");
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

	}

	public static void close(Connection conn) throws SQLException {
		if (conn != null)
			conn.close();
	}

	public static void close(Connection conn, Statement stmt) throws SQLException {
		stmt.close();
		close(conn);
	}

	public static void close(Connection conn, Statement stmt, ResultSet result) throws SQLException {
		result.close();
		close(conn, stmt);

	}

}
