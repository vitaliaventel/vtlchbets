package ua.kpi.leshchenko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import ua.kpi.leshchenko.beans.Bet;
import ua.kpi.leshchenko.beans.Event;
import ua.kpi.leshchenko.connection.Database;

public class BetDAOImpl implements BetDAO {

	private static Logger logger = Logger.getLogger(BetDAOImpl.class.getName());
	private final String sqlCreate = "INSERT INTO mydb.bets(event,user,winner) VALUES(?,?,?)";
	private final String sqlRead = "SELECT * FROM mydb.bets WHERE idbets = ";
	private final String sqlUpdate = "UPDATE mydb.bets SET event=?, user=?, winner=? WHERE idbets=?";
	private final String sqlDelete = "DELETE FROM mydb.bets WHERE idbets=";
	private Database db;

	public BetDAOImpl(Database db) {
		this.db = db;
	}

	@Override
	public boolean create(Bet bet) {
		Connection conn = db.getConn();
		try (PreparedStatement ps = conn.prepareStatement(sqlCreate)) {
			ps.setInt(1, bet.getEvent());
			ps.setInt(2, bet.getUser());
			ps.setString(3, bet.getWinner());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("DB problems create() ", e);
			return false;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("New bet was created!" + bet);
		return true;
	}

	@Override
	public Bet read(int id) {
		Bet bet = new Bet();
		Connection conn = db.getConn();
		try (ResultSet rs = conn.createStatement().executeQuery(sqlRead + id)) {
			while (rs.next()) {
				bet.setIdBet(rs.getInt("idbets"));
				bet.setEvent(rs.getInt("event"));
				bet.setUser(rs.getInt("user"));
				bet.setWinner(rs.getString("winner"));
			}
		} catch (SQLException e) {
			logger.error("DB problems read() ", e);
			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("Read bet id = " + id);
		return bet;
	}

	@Override
	public boolean update(Bet bet) {
		Connection conn = db.getConn();
		try (PreparedStatement ps = conn.prepareStatement(sqlUpdate)) {
			ps.setInt(1, bet.getEvent());
			ps.setInt(2, bet.getUser());
			ps.setString(3, bet.getWinner());
			ps.setInt(4, bet.getIdBet());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("DB problem update() ", e);
			return false;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("Bet " + bet.getIdBet() + " was updated!");
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
		logger.info("Bet " + id + " was deleted!");
		return true;
	}

	@Override
	public ArrayList<Bet> findByUser(int id) {
		ArrayList<Bet> betList = new ArrayList<>();
		Connection conn = db.getConn();
		try (ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM mydb.bets WHERE user=" + id)) {
			while (rs.next()) {
				Bet bet = new Bet();
				bet.setIdBet(rs.getInt("idbets"));
				bet.setEvent(rs.getInt("event"));
				bet.setUser(rs.getInt("user"));
				bet.setWinner(rs.getString("winner"));
				betList.add(bet);
			}
		} catch (Exception e) {
			logger.error("BetDAO.findByUser() problems.");
			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("BetDAO.findByUser() is ok.");
		return betList;
	}

	@Override
	public ArrayList<Bet> findAll() {
		ArrayList<Bet> betList = new ArrayList<>();
		Connection conn = db.getConn();
		try (ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM mydb.bets")) {
			while (rs.next()) {
				Bet bet = new Bet();
				bet.setIdBet(rs.getInt("idbets"));
				bet.setEvent(rs.getInt("event"));
				bet.setUser(rs.getInt("user"));
				bet.setWinner(rs.getString("winner"));
				betList.add(bet);
			}
		} catch (Exception e) {
			logger.error("BetDAO.findAll() problems.");
			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("BetDAO.findAll() is ok.");
		return betList;
	}

	@Override
	public ArrayList<Bet> findByEvent(int id) {
		ArrayList<Bet> betList = new ArrayList<>();
		Connection conn = db.getConn();
		try (ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM mydb.bets WHERE event=" + id)) {
			while (rs.next()) {
				Bet bet = new Bet();
				bet.setIdBet(rs.getInt("idbets"));
				bet.setEvent(rs.getInt("event"));
				bet.setUser(rs.getInt("user"));
				bet.setWinner(rs.getString("winner"));
				betList.add(bet);
			}
		} catch (Exception e) {
			logger.error("BetDAO.findByEvent() problems.");
			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("BetDAO.findByEvent() is ok.");
		return betList;

	}

}
