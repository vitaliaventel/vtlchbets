package ua.kpi.leshchenko.dao;

import ua.kpi.leshchenko.connection.Database;

public class DAOFactory {

	public static UserDAO createUserDAO() {
		return new UserDAOImpl(Database.getInstance());
	}
	
//	public static UserTypeDAO createUsertypeDAO(){
//		return new UserTypeDAOImpl(Database.getInstance());
//	}
//	
//	public static GameDAO createGameDAO(){
//		return new GameDAOImpl(Database.getInstance());
//	}
//	
//	public static EventDAO createEventDAO(){
//		return new EventDAOImpl(Database.getInstance());
//	}
//	
//	public static BetDAO createBetDAO(){
//		return new BetDAOImpl(Database.getInstance());
//	}
}
