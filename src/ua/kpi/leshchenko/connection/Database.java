package ua.kpi.leshchenko.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.kpi.leshchenko.manager.Config;

public class Database {

	private static Database instance;
	private List<Connection> availableConnections = new ArrayList<>();

	public Database() {
		initializeConnectionPool();
	}

	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}

	private void initializeConnectionPool() {
		while (!checkPoolFull()) {
			try {
				availableConnections.add(createNewConnection());

			} catch (SQLException e) {

			}
		}
	}

	private synchronized boolean checkPoolFull() {
		if (availableConnections.size() < Integer
				.parseInt(Config.getInstance().getProperty(Config.CONNECTION_POOL_SIZE))) {
			return false;
		}
		return true;
	}

	private Connection createNewConnection() throws SQLException {
		String url = Config.getInstance().getProperty(Config.URL);
		String driver = Config.getInstance().getProperty(Config.DRIVER);
		String user = Config.getInstance().getProperty(Config.DB_USERNAME);
		String pass = Config.getInstance().getProperty(Config.DB_PASSWORD);
		try {
			Class.forName(driver).newInstance();
		} catch (ClassNotFoundException e) {
			throw new SQLException("Driver isn't download!");
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		return DriverManager.getConnection(url, user, pass);

	}

	public Connection getConn() {
		Connection con = null;
		if (availableConnections.size() > 0) {
			con = availableConnections.get(0);
			availableConnections.remove(0);
		}
		return con;
	}

	public synchronized void returnConnectionToPool(Connection connection) {
		availableConnections.add(connection);
	}
}
