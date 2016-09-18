package ua.kpi.leshchenko.dao;

import org.apache.log4j.Logger;

import ua.kpi.leshchenko.connection.Database;

public class DAOFactory {

	private static Logger logger = Logger.getLogger(DAOFactory.class.getName());
	
	public static UserDAO createUserDAO() {
		logger.info("Creating a instance of UserDAO.");
		return new UserDAOImpl(Database.getInstance());
	}
	
	public static UserTypeDAO createUsertypeDAO(){
		logger.info("Creating a instance of UserTypeDAO.");
		return new UserTypeDAOImpl(Database.getInstance());
	}
	
	public static GameDAO createGameDAO(){
		logger.info("Creating a instance of GameDAO.");
		return new GameDAOImpl(Database.getInstance());
	}
	
	public static EventDAO createEventDAO(){
		logger.info("Creating a instance of EventDAO.");
		return new EventDAOImpl(Database.getInstance());
	}
	
	public static BetDAO createBetDAO(){
		logger.info("Creating a instance of BetDAO.");
		return new BetDAOImpl(Database.getInstance());
	}
}
