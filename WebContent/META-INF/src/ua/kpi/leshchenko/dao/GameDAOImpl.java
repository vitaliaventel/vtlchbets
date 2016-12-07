package ua.kpi.leshchenko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import ua.kpi.leshchenko.beans.Game;
import ua.kpi.leshchenko.beans.User;
import ua.kpi.leshchenko.connection.Database;

public class GameDAOImpl implements GameDAO {

	private static Logger logger = Logger.getLogger(GameDAOImpl.class.getName());
	private final String sqlCreate = "INSERT INTO mydb.game(name) VALUES(?)";
	private final String sqlRead = "SELECT * FROM mydb.game WHERE idgame = ";
	private final String sqlUpdate = "UPDATE mydb.game SET name=? WHERE idgame=?";
	private final String sqlDelete = "DELETE FROM mydb.game WHERE idgame=";
	private Database db;

	public GameDAOImpl(Database db) {
		this.db = db;
	}

	@Override
	public boolean create(Game game) {
		Connection conn = db.getConn();
		try (PreparedStatement ps = conn.prepareStatement(sqlCreate)) {
			ps.setString(1, game.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("DB problems create() ", e);
			return false;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("New gameType was created!" + game);
		return true;
	}

	@Override
	public Game read(int id) {
		Game game = new Game();
		Connection conn = db.getConn();
		try (ResultSet rs = conn.createStatement().executeQuery(sqlRead + id)) {
			while (rs.next()) {
				game.setIdGame(rs.getInt("idgame"));
				game.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			logger.error("DB problems read() ", e);
			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("Read gameType id = " + id);
		return game;
	}

	@Override
	public boolean update(Game game) {
		Connection conn = db.getConn();
		try (PreparedStatement ps = conn.prepareStatement(sqlUpdate)) {
			ps.setString(1, game.getName());
			ps.setInt(2, game.getIdGame());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("DB problem update() ", e);
			return false;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("GameType " + game.getIdGame() + " was updated!");
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
		logger.info("GameType " + id + " was deleted!");
		return true;
	}

	@Override
	public ArrayList<Game> findAll() {
		ArrayList<Game> typesList = new ArrayList<>();
		Connection conn = db.getConn();
		try (ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM mydb.game")) {
			while (rs.next()) {
				Game game = new Game();
				game.setIdGame(rs.getInt("idgame"));
				game.setName(rs.getString("name"));
				typesList.add(game);
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

	@Override
	public Game findByName(String name) {
		Game game = new Game();
		Connection conn = db.getConn();
		try (PreparedStatement ps = conn.prepareStatement(
				"SELECT * FROM mydb.game WHERE name = ?")) {
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				game.setIdGame(rs.getInt("idgame"));
				game.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			logger.error("GameDAO.findByEmail() problems.");
			return null;
		} finally {
			db.returnConnectionToPool(conn);
		}
		logger.info("GameDAO.findByEmail() is ok.");
		return game;
	}

}
