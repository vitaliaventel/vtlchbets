package ua.kpi.leshchenko.commands;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.kpi.leshchenko.beans.User;
import ua.kpi.leshchenko.dao.DAOFactory;
import ua.kpi.leshchenko.dao.UserDAO;
import ua.kpi.leshchenko.manager.Config;

public class CommandLogin implements ICommand {

	private static Logger logger = Logger.getLogger(CommandLogin.class.getName());
	private UserDAO daoUsers = DAOFactory.createUserDAO();
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException {
		String page = null;
		String email = request.getParameter(EMAIL);
		String password = request.getParameter(PASSWORD);

		try {
			if (daoUsers.find(email, password)) {
				User user = daoUsers.findByEmail(email);
					request.getSession(false).setAttribute("name", user.getFirstName());
					request.getSession(false).setAttribute(EMAIL, email);
					request.getSession(false).setAttribute("balance", user.getBalance());
					request.getSession(false).setAttribute("type", user.getUserType());
					page = Config.getInstance().getProperty(Config.MAINLOGGED);
					logger.info("Correct login/password!");
			} else {
				//request.getSession().setAttribute("error", Message.getInstance().getProperty(Message.LOGIN_ERROR));
				page = Config.getInstance().getProperty(Config.ERRORPAGE);
				logger.info("Incorrect login/password");
			}
		} catch (NullPointerException e) {
			//request.getSession().setAttribute("error", Message.getInstance().getProperty(Message.SESSION_END));
			page = Config.getInstance().getProperty(Config.ERRORPAGE);
			logger.error("Session ended ", e);
		}
		return page;
	}
}
