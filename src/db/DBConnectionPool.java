package db;

import java.sql.*;
import java.util.*;
import endpoint.Actor;
import config.Config;

public class DBConnectionPool extends Actor {

	/*
	 * Driver della connessione al database di JDBC per MySQL
	 */

	private static List<Connection> freeDbConnections;

	static {
		freeDbConnections = new LinkedList<Connection>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			new DBConnectionPool().debug("!Impossibile trovare i driver MySQL");
			new DBConnectionPool().debug("?Tento ugualmente di accedere al database...");
		}
	}

	private static Connection createDBConnection() throws SQLException {
		Connection newConnection = null;

		String ip = "localhost";
		String port = "3306";

		String db = Config.DB_NAME;
		String username = Config.DB_USERNAME;
		String password = Config.DB_PASSWORD;

		String params = "?serverTimezone=UTC&useLegacyDatetimeCode=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&zeroDateTimeBehavior=CONVERT_TO_NULL&autoReconnect=true";

		new DBConnectionPool().debug("?Tentativo di connessione al database...");

		new DBConnectionPool().debug("?Database: " + db);
		new DBConnectionPool().debug("?Username: " + username);
		new DBConnectionPool().debug("?Password: " + password);

		if (db.equals("db_name") || username.equals("db_password") || username.equals("db_password"))
			new DBConnectionPool().debug(
					"!Risulta che tu stia usando i parametri di accesso predefiniti. Per connetterti al database, modifica il file di configurazione. In caso di difficoltà, consulta la documentazione");
		new DBConnectionPool().debug(
				"!Risulta che tu stia usando i parametri di accesso predefiniti. Per connetterti al database, modifica il file di configurazione. In caso di difficoltà, consulta la documentazione");
		new DBConnectionPool().debug(
				"!Risulta che tu stia usando i parametri di accesso predefiniti. Per connetterti al database, modifica il file di configurazione. In caso di difficoltà, consulta la documentazione");

		newConnection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + db + params, username,
				password);
		newConnection.setAutoCommit(true);

		return newConnection;
	}

	public static synchronized Connection getConnection() throws SQLException {
		Connection connection;

		if (!freeDbConnections.isEmpty()) {
			connection = (Connection) freeDbConnections.get(0);
			DBConnectionPool.freeDbConnections.remove(0);

			try {
				if (connection.isClosed()) {
					connection = DBConnectionPool.getConnection();
				}
			} catch (SQLException e) {
				connection = DBConnectionPool.getConnection();
			}
		} else {
			connection = DBConnectionPool.createDBConnection();

		}

		return connection;
	}

	public static synchronized void releaseConnection(Connection connection) {
		DBConnectionPool.freeDbConnections.add(connection);
	}

}
