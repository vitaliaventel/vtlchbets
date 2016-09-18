package ua.kpi.leshchenko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import ua.kpi.leshchenko.beans.Event;
import ua.kpi.leshchenko.connection.Database;

public class EventDAOImpl implements EventDAO {

	private static Logger logger = Logger.getLogger(EventDAOImpl.class.getName());
	private final String sqlCreate = "INSERT INTO mydb.event(team1,team2,result,game) VALUES(?,?,?,?)";
	private final String sqlRead = "SELECT * FROM mydb.event WHERE idevent = ";
	private final String sqlUpdate = "UPDATE mydb.event SET team1=?, team2=?, result=?, game=? WHERE idevent=?";
	private final String sqlDelete = "DELETE FROM mydb.event WHERE idevent=";
	private Database db;

	public EventDAOImpl(Database db) {
		this.db = db;
	}

	@Override
	public boolean create(Event event) {
		Connection conn = db.getConn();
		try (PreparedStatement ps = conn.prepareStatement(sqlCreate)) {
			ps.setString(1, event.getTeam1());
			ps.setString(2, event.getTeam2());
			ps.setString(3, event.getResult());
			ps.setInt(4, event.getGameType());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("DB problems create() ", e);
			return false;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("New event was created!" + event);
		return true;
	}

	@Override
	public Event read(int id) {
		Event event = new Event();
		Connection conn = db.getConn();
		try (ResultSet rs = conn.createStatement().executeQuery(sqlRead + id)) {
			while (rs.next()) {
				event.setIdEvent(rs.getInt("idevent"));
				event.setTeam1(rs.getString("team1"));
				event.setTeam2(rs.getString("team2"));
				event.setResult(rs.getString("result"));
				event.setGameType(rs.getInt("game"));
			}
		} catch (SQLException e) {
			logger.error("DB problems read() ", e);
			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("Read event id = " + id);
		return event;
	}

	@Override
	public boolean update(Event event) {
		Connection conn = db.getConn();
		try (PreparedStatement ps = conn.prepareStatement(sqlUpdate)) {
			ps.setString(1, event.getTeam1());
			ps.setString(2, event.getTeam2());
			ps.setString(3, event.getResult());
			ps.setInt(4, event.getGameType());
			ps.setInt(5, event.getIdEvent());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("DB problem update() ", e);
			return false;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("Event " + event.getIdEvent() + " was updated!");
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
		logger.info("Event " + id + " was deleted!");
		return true;
	}

	@Override
	public ArrayList<Event> findByTeam(String team) {
		ArrayList<Event> eventList = new ArrayList<>();
		Connection conn = db.getConn();
		try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM mydb.event WHERE team1 = ? OR team2=?")) {
			ps.setString(1, team);
			ps.setString(2, team);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Event ev = new Event();
				ev.setIdEvent(rs.getInt("idevent"));
				ev.setTeam1(rs.getString("team1"));
				ev.setTeam2(rs.getString("team2"));
				ev.setResult(rs.getString("result"));
				ev.setGameType(rs.getInt("game"));
				eventList.add(ev);
			}
		} catch (Exception e) {
			logger.error("EventDAO.findByTeam() problems.");
			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("EventDAO.findByTeam() is ok.");
		return eventList;
	}

	@Override
	public ArrayList<Event> findAll() {
		ArrayList<Event> eventList = new ArrayList<>();
		Connection conn = db.getConn();
		try (ResultSet rs = conn.createStatement().executeQuery(
				"SELECT idevent,team1,team2,result,game,name FROM mydb.event JOIN mydb.game WHERE event.game = game.idgame")) {
			while (rs.next()) {
				Event ev = new Event();
				ev.setIdEvent(rs.getInt("idevent"));
				ev.setTeam1(rs.getString("team1"));
				ev.setTeam2(rs.getString("team2"));
				ev.setResult(rs.getString("result"));
				ev.setGameType(rs.getInt("game"));
				ev.setGameName(rs.getString("name"));
				eventList.add(ev);
			}
		} catch (Exception e) {
			logger.error("EventDAO.findAll() problems.");
			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("EventDAO.findAll() is ok.");
		return eventList;
	}

	@Override
	public ArrayList<Event> findByResult(String result) {
		ArrayList<Event> eventList = new ArrayList<>();
		Connection conn = db.getConn();
		try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM mydb.event WHERE result = ?")) {
			ps.setString(1, result);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Event ev = new Event();
				ev.setIdEvent(rs.getInt("idevent"));
				ev.setTeam1(rs.getString("team1"));
				ev.setTeam2(rs.getString("team2"));
				ev.setResult(rs.getString("result"));
				ev.setGameType(rs.getInt("game"));
				eventList.add(ev);
			}
		} catch (Exception e) {
			logger.error("EventDAO.findByResult() problems.");
			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("EventDAO.findByResult() is ok.");
		return eventList;
	}

	@Override
	public ArrayList<Event> findByGametype(int gameType) {
		ArrayList<Event> eventList = new ArrayList<>();
		Connection conn = db.getConn();
		try (ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM mydb.event WHERE game = " + gameType)) {
			while (rs.next()) {
				Event ev = new Event();
				ev.setIdEvent(rs.getInt("idevent"));
				ev.setTeam1(rs.getString("team1"));
				ev.setTeam2(rs.getString("team2"));
				ev.setResult(rs.getString("result"));
				ev.setGameType(rs.getInt("game"));
				eventList.add(ev);
			}
		} catch (Exception e) {
			logger.error("EventDAO.findByGametype() problems.");
			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("EventDAO.findByGametype() is ok.");
		return eventList;
	}

}
