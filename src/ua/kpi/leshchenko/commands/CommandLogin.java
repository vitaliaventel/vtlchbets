package ua.kpi.leshchenko.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.kpi.leshchenko.beans.User;
import ua.kpi.leshchenko.dao.BetDAO;
import ua.kpi.leshchenko.dao.DAOFactory;
import ua.kpi.leshchenko.dao.UserDAO;
import ua.kpi.leshchenko.manager.Config;

public class CommandLogin implements ICommand {

	private static Logger logger = Logger.getLogger(CommandLogin.class.getName());
	private UserDAO daoUsers = DAOFactory.createUserDAO();
	private BetDAO daoBets = DAOFactory.createBetDAO();
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	private static final int USERTYPE = 1;
	private static final int MODERTYPE = 2;
	private static final int ADMINTYPE = 3;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException {
		String page = null;
		String email = request.getParameter(EMAIL);
		String password = request.getParameter(PASSWORD);

		try {
			if (daoUsers.find(email, password)) {
				User user = daoUsers.findByEmail(email);
				if (user.getUserType() == MODERTYPE) {
					request.getSession(false).setAttribute("name", user.getFirstName());
					request.getSession(false).setAttribute("balance", user.getBalance());
					page = Config.getInstance().getProperty(Config.MAINLOGGED);
					logger.info("This is moderator.");
				} else if (user.getUserType() == ADMINTYPE) {
					request.getSession(false).setAttribute("name", user.getFirstName());
					request.getSession(false).setAttribute("balance", user.getBalance());
					page = Config.getInstance().getProperty(Config.MAINLOGGED);
					logger.info("This is administrator");
				} else if (user.getUserType() == USERTYPE) {
					request.getSession(false).setAttribute("name", user.getFirstName());
					request.getSession(false).setAttribute("balance", user.getBalance());
					page = Config.getInstance().getProperty(Config.MAINLOGGED);
					logger.info("Correct login/password!");
				}
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
