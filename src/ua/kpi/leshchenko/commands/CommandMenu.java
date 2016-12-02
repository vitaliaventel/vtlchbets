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
import ua.kpi.leshchenko.manager.Message;

public class CommandMenu implements ICommand {

	private Logger logger = Logger.getLogger(CommandMenu.class.getName());
	private static final String BUTTON = "buttonName";
	private static final String EMAIL = "email";
	private UserDAO daoUser = DAOFactory.createUserDAO();
	private BetDAO daoBet = DAOFactory.createBetDAO();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException {
		String page = null;
		String menu = request.getParameter(BUTTON);
		String email = (String) request.getSession(false).getAttribute(EMAIL);
		try {
			if (menu.equals("home")) {
				if (email != null) {
					page = Config.getInstance().getProperty(Config.MAINLOGGED);
					logger.info("Go to mainlogged.jsp");
				} else {
					page = Config.getInstance().getProperty(Config.MAIN);
					logger.info("Go to main.jsp");
				}
			} else if (menu.equals("hall")) {
				page = Config.getInstance().getProperty(Config.HALLOFFAME);
				logger.info("Go to halloffame.jsp");
			} else if (menu.equals("moder")) {
				page = Config.getInstance().getProperty(Config.MODER);
				logger.info("Go to moder.jsp");
			} else if (menu.equals("admin")) {
				request.getSession(false).setAttribute("users", daoUser.findAll());
				page = Config.getInstance().getProperty(Config.ADMIN);
				logger.info("Go to admin.jsp");
			} else if (menu.equals("about")) {
				page = Config.getInstance().getProperty(Config.ABOUT);
				logger.info("Go to about.jsp");
			} else if (menu.equals("profile")) {
				User user = daoUser.findByEmail(email);
				request.getSession(false).setAttribute("id", user.getIdUser());
				request.getSession(false).setAttribute("firstname", user.getFirstName());
				request.getSession(false).setAttribute("lastname", user.getLastName());
				request.getSession(false).setAttribute("email", user.getEmail());
				request.getSession(false).setAttribute("password", user.getPassword());
				request.getSession(false).setAttribute("betListUp", daoBet.findByUserUpcoming(user.getIdUser()));
				request.getSession(false).setAttribute("betListFinish", daoBet.findByUserFinished(user.getIdUser()));
				page = Config.getInstance().getProperty(Config.PROFILE);
				logger.info("Go to profile.jsp");
			}
		} catch (NullPointerException e) {
			request.getSession().setAttribute("error", Message.getInstance().getProperty(Message.SESSION_END));
			page = Config.getInstance().getProperty(Config.ERRORPAGE);
			logger.error("Session ended ", e);
		} catch (Exception e) {
			page = Config.getInstance().getProperty(Config.ERRORPAGE);
			logger.error("Something wrong ", e);
		}
		return page;
	}

}
