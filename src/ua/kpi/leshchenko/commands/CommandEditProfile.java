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

public class CommandEditProfile implements ICommand {

	private static Logger logger = Logger.getLogger(CommandLogin.class.getName());
	private UserDAO daoUsers = DAOFactory.createUserDAO();
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	private static final String LASTNAME = "lastname";
	private static final String FIRSTNAME = "firstname";
	private static final String ID = "id";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException {
		String page = null;
		String email = request.getParameter(EMAIL);
		String password = request.getParameter(PASSWORD);
		int id = Integer.parseInt(request.getParameter(ID));
		String lastName = request.getParameter(LASTNAME);
		String firstName = request.getParameter(FIRSTNAME);

		try {
			User user = daoUsers.read(id);
			user.setEmail(email);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPassword(password);

			if (daoUsers.update(user)) {
				request.getSession(false).setAttribute("name", user.getFirstName());
				request.getSession(false).setAttribute("lastname", user.getLastName());
				request.getSession(false).setAttribute("email", user.getEmail());
				request.getSession(false).setAttribute("password", user.getPassword());
				page = Config.getInstance().getProperty(Config.PROFILE);
				logger.info("User info updated!");
			} else {
				// request.getSession().setAttribute("error",
				// Message.getInstance().getProperty(Message.SESSION_END));
				logger.info("Cant update user info.");
				throw new Exception();
			}

		} catch (NullPointerException e) {
			// request.getSession().setAttribute("error",
			// Message.getInstance().getProperty(Message.SESSION_END));
			page = Config.getInstance().getProperty(Config.ERRORPAGE);
			logger.error("Session ended ", e);
		} catch (Exception e) {
			// request.getSession().setAttribute("error",
			// Message.getInstance().getProperty(Message.SESSION_END));
			page = Config.getInstance().getProperty(Config.ERRORPAGE);
			logger.error("Error ", e);
		}
		return page;
	}

}
