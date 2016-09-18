package ua.kpi.leshchenko.connection;

import ua.kpi.leshchenko.beans.User;
import ua.kpi.leshchenko.dao.DAOFactory;
import ua.kpi.leshchenko.dao.UserDAO;

public class Runner {

	public static void main(String[] args) {
		UserDAO udao = DAOFactory.createUserDAO();
		for(User u : udao.findByUsertype(3)){
			System.out.println(u);
		}
	}

}
