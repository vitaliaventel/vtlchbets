package ua.kpi.leshchenko.commands;

import java.io.IOException;
import java.util.ArrayList;

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

public class CommandAdminViewProfile implements ICommand {

	private Logger logger = Logger.getLogger(CommandAdminViewProfile.class.getName());
	private static final String ID = "id";
	private UserDAO daoUser = DAOFactory.createUserDAO();
	private BetDAO daoBet = DAOFactory.createBetDAO();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException {
		String page = null;
		int id = Integer.parseInt(request.getParameter(ID));
		try {
			User user = daoUser.read(id);
			request.getSession(false).setAttribute("viewId", id);
			request.getSession(false).setAttribute("betListUp", daoBet.findByUserUpcoming(user.getIdUser()));
			request.getSession(false).setAttribute("betListFinish", daoBet.findByUserFinished(user.getIdUser()));
			page = Config.getInstance().getProperty(Config.PROFILEVIEW);

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
