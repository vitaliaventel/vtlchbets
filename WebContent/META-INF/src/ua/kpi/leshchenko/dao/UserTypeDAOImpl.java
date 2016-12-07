package ua.kpi.leshchenko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import ua.kpi.leshchenko.beans.UserType;
import ua.kpi.leshchenko.connection.Database;

public class UserTypeDAOImpl implements UserTypeDAO {

	private static Logger logger = Logger.getLogger(UserTypeDAOImpl.class.getName());
	private final String sqlCreate = "INSERT INTO mydb.usertype(type) VALUES(?)";
	private final String sqlRead = "SELECT * FROM mydb.usertype WHERE idusertype = ";
	private final String sqlUpdate = "UPDATE mydb.usertype SET type=? WHERE idusertype=?";
	private final String sqlDelete = "DELETE FROM mydb.usertype WHERE idusertype=";
	private Database db;

	public UserTypeDAOImpl(Database db) {
		this.db = db;
	}

	@Override
	public boolean create(UserType type) {
		Connection conn = db.getConn();
		try (PreparedStatement ps = conn.prepareStatement(sqlCreate)) {
			ps.setString(1, type.getType());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("DB problems create() ", e);
			return false;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("New usertype was created!" + type);
		return true;
	}

	@Override
	public UserType read(int id) {
		UserType ut = new UserType();
		Connection conn = db.getConn();
		try (ResultSet rs = conn.createStatement().executeQuery(sqlRead + id)) {
			while (rs.next()) {
				ut.setIdUserType(rs.getInt("idusertype"));
				ut.setType(rs.getString("type"));
			}
		} catch (SQLException e) {
			logger.error("DB problems read() ", e);
			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("Read usertype id = " + id);
		return ut;
	}

	@Override
	public boolean update(UserType type) {
		Connection conn = db.getConn();
		try (PreparedStatement ps = conn.prepareStatement(sqlUpdate)) {
			ps.setString(1, type.getType());
			ps.setInt(2, type.getIdUserType());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("DB problem update() ", e);
			return false;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("Usertype " + type.getIdUserType() + " was updated!");
		return true;
	}

	@Override
	public boolean delete(int id) {
		Connection conn = db.getConn();
		try (Statement stmn = conn.createStatement()) {
			stmn.executeUpdate(sqlDelete + id);
		} catch (SQLException e) {
			logger.error("DB problems delete() ", e);
			return false;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("Usertype " + id + " was deleted!");
		return true;
	}

	@Override
	public ArrayList<UserType> findAll() {
		ArrayList<UserType> typesList = new ArrayList<>();
		Connection conn = db.getConn();
		try (ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM mydb.usertype")) {
			while (rs.next()) {
				UserType ut = new UserType();
				ut.setIdUserType(rs.getInt("idusertype"));
				ut.setType(rs.getString("type"));
				typesList.add(ut);
			}
		} catch (Exception e) {
			logger.error("Something wrong findAll() ", e);
			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("Successful findAll().");
		return typesList;
	}

}
