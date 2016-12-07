package ua.kpi.leshchenko.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.kpi.leshchenko.beans.User;
import ua.kpi.leshchenko.dao.DAOFactory;
import ua.kpi.leshchenko.dao.UserDAO;
import ua.kpi.leshchenko.manager.Config;
import ua.kpi.leshchenko.manager.Message;

public class CommandSignUp implements ICommand {

	private static Logger logger = Logger.getLogger(CommandSignUp.class.getName());
	private UserDAO daoUsers = DAOFactory.createUserDAO();
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	private static final String FIRSTNAME = "firstName";
	private static final String LASTNAME = "lastName";
	private static final int USERTYPE = 1;
	private static final double BALANCE = 1000;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException {
		String page = null;
		String email = request.getParameter(EMAIL);
		String password = request.getParameter(PASSWORD);
		String firstName = request.getParameter(FIRSTNAME);
		String lastName = request.getParameter(LASTNAME);
		User user = new User();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setUserType(USERTYPE);
		user.setBalance(BALANCE);
		try {
			if (daoUsers.create(user)) {
				request.getSession(false).setAttribute("name", user.getFirstName());
				request.getSession(false).setAttribute("balance", user.getBalance());
				request.getSession(false).setAttribute(EMAIL, user.getEmail());
				request.getSession(false).setAttribute("type", user.getUserType());
				page = Config.getInstance().getProperty(Config.MAINLOGGED);
				logger.info("Register new user.");
			} else {
				request.getSession().setAttribute("error", Message.getInstance().getProperty(Message.REGISTER_ERROR));
				page = Config.getInstance().getProperty(Config.ERRORPAGE);
				logger.info("Current username is already use.");
			}
		} catch (NullPointerException e) {
			request.getSession().setAttribute("error", Message.getInstance().getProperty(Message.SESSION_END));
			page = Config.getInstance().getProperty(Config.ERRORPAGE);
			logger.error("Session ended ", e);
		}
		return page;
	}

}
