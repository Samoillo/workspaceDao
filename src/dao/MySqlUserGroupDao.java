package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlUserGroupDao implements UserGroupDao {
	
	// DANE DO LACZENIA SIE Z BAZA DANYCH
	private final String jdbcUrl;
	private final String password;
	private final String user;

	//KONSTRUKTOR wprowadzajacy dane do palaczenia z baza danych
	public MySqlUserGroupDao(String jdbcUrl, String password, String user) {
		this.jdbcUrl = jdbcUrl;
		this.password = password;
		this.user = user;
	}

	// NAWIAZYWANIE POLACZENIA Z BAZA DANYCH
	private Connection createConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrl, user, password);
	}
	
}