package ua.kpi.leshchenko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ua.kpi.leshchenko.beans.User;
import ua.kpi.leshchenko.connection.Database;

public class UserDAOImpl implements UserDAO {

	private final String sqlCreate = "INSERT INTO mydb.users(firstname,lastname,email,password,balance,usertype) VALUES(?,?,?,?,?,?)";
	private final String sqlRead = "SELECT * FROM mydb.users WHERE idUsers = ";
	private final String sqlUpdate = "UPDATE mydb.users SET firstname=?, lastname=?, email=?, password=?, balance=?, usertype=? WHERE idUsers=?";
	private final String sqlDelete = "DELETE FROM mydb.users WHERE idUsers=";
	private Database db;

	public UserDAOImpl(Database db) {
		this.db = db;
	}

	@Override
	public boolean create(User user) {
		Connection conn = db.getConn();
		try (PreparedStatement ps = conn.prepareStatement(sqlCreate)) {
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setDouble(5, user.getBalance());
			ps.setInt(6, user.getUserType());
			ps.executeUpdate();
		} catch (SQLException e) {
			return false;
		} finally {
			db.returnConnectionToPool(conn);
		}
		return true;
	}

	@Override
	public User read(int id) {
		Connection conn = db.getConn();
		User u = new User();
		try (ResultSet rs = conn.createStatement().executeQuery(sqlRead + id)) {
			while (rs.next()) {
				u.setIdUser(rs.getInt("idUsers"));
				u.setFirstName(rs.getString("firstname"));
				u.setLastName(rs.getString("lastname"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setBalance(rs.getDouble("balance"));
				u.setUserType(rs.getInt("usertype"));
			}
		} catch (SQLException e) {

			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		return u;
	}

	@Override
	public boolean update(User user) {
		Connection conn = db.getConn();
		try (PreparedStatement ps = conn.prepareStatement(sqlUpdate)) {
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setDouble(5, user.getBalance());
			ps.setInt(6, user.getUserType());
			ps.setInt(7, user.getIdUser());
			ps.executeUpdate();
		} catch (SQLException e) {

			return false;
		} finally {
			db.returnConnectionToPool(conn);
		}

		return true;
	}

	@Override
	public boolean delete(int id) {
		Connection conn = db.getConn();
		try (Statement stmn = conn.createStatement()) {
			stmn.executeUpdate(sqlDelete + id);
		} catch (SQLException e) {
			return false;
		} finally {
			db.returnConnectionToPool(conn);
		}
		return true;
	}

	@Override
	public boolean find(String email, String password) {
		Connection conn = db.getConn();
		try (PreparedStatement ps = conn
				.prepareStatement("SELECT * FROM mydb.users WHERE email = ? AND password = ?")) {
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			return false;
		} finally {
			db.returnConnectionToPool(conn);
		}
	}

	@Override
	public ArrayList<User> findAll() {
		ArrayList<User> usersList = new ArrayList<>();
		Connection conn = db.getConn();
		try (ResultSet rs = conn.createStatement()
				.executeQuery("SELECT IDUSERS, FIRSTNAME, LASTNAME, EMAIL, BALANCE, USERTYPE, TYPE FROM mydb.users JOIN mydb.usertype where users.userType=usertype.idUserType")) {
			while (rs.next()) {
				User u = new User();
				u.setIdUser(rs.getInt("idUsers"));
				u.setFirstName(rs.getString("firstname"));
				u.setLastName(rs.getString("lastname"));
				u.setEmail(rs.getString("email"));
				u.setUserType(rs.getInt("usertype"));
				u.setTypeName(rs.getString("type"));
				u.setBalance(rs.getDouble("balance"));
				usersList.add(u);
			}
		} catch (Exception e) {
			
			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		
		return usersList;
	}

	@Override
	public User findByEmail(String email) {
		User u = new User();
		Connection conn = db.getConn();
		try (PreparedStatement ps = conn
				.prepareStatement("SELECT IDUSERS, FIRSTNAME, LASTNAME, BALANCE, EMAIL, USERTYPE FROM mydb.users WHERE email = ?")) {
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u.setIdUser(rs.getInt("idUsers"));
				u.setFirstName(rs.getString("firstname"));
				u.setLastName(rs.getString("lastname"));
				u.setBalance(rs.getDouble("balance"));
				u.setEmail(rs.getString("email"));
				u.setUserType(rs.getInt("usertype"));
			}
		} catch (Exception e) {
			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		return u;
	}

	@Override
	public ArrayList<User> findByUsertype(int userType) {
		ArrayList<User> usersList = new ArrayList<>();
		Connection conn = db.getConn();
		try (ResultSet rs = conn.createStatement()
				.executeQuery("SELECT IDUSERS, FIRSTNAME, LASTNAME, EMAIL, BALANCE, USERTYPE FROM mydb.users WHERE userType = " + userType)) {
			while (rs.next()) {
				User u = new User();
				u.setIdUser(rs.getInt("idUsers"));
				u.setFirstName(rs.getString("firstname"));
				u.setLastName(rs.getString("lastname"));
				u.setBalance(rs.getDouble("balance"));
				u.setEmail(rs.getString("email"));
				u.setUserType(rs.getInt("usertype"));
				usersList.add(u);
			}
		} catch (Exception e) {
			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		return usersList;
	}

	@Override
	public ArrayList<User> findByBalance() {
		ArrayList<User> usersList = new ArrayList<>();
		Connection conn = db.getConn();
		try (ResultSet rs = conn.createStatement()
				.executeQuery("SELECT IDUSERS, FIRSTNAME, LASTNAME, BALANCE FROM mydb.users order by balance desc")) {
			while (rs.next()) {
				User u = new User();
				u.setIdUser(rs.getInt("idUsers"));
				u.setFirstName(rs.getString("firstname"));
				u.setLastName(rs.getString("lastname"));
				u.setBalance(rs.getDouble("balance"));
				usersList.add(u);
			}
		} catch (Exception e) {
			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		return usersList;
	}

}
