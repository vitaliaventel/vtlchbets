package ua.kpi.leshchenko.commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.kpi.leshchenko.beans.Bet;
import ua.kpi.leshchenko.beans.Event;
import ua.kpi.leshchenko.beans.User;
import ua.kpi.leshchenko.dao.BetDAO;
import ua.kpi.leshchenko.dao.DAOFactory;
import ua.kpi.leshchenko.dao.EventDAO;
import ua.kpi.leshchenko.dao.UserDAO;
import ua.kpi.leshchenko.manager.Config;

public class CommandEventDelete implements ICommand {

	private Logger logger = Logger.getLogger(CommandEventDelete.class.getName());
	private static final String ID = "id";
	private EventDAO daoEvent = DAOFactory.createEventDAO();
	private UserDAO daoUser = DAOFactory.createUserDAO();
	private BetDAO daoBet = DAOFactory.createBetDAO();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException {
		String page = null;
		int id = Integer.parseInt(request.getParameter(ID));
		User user = null;
		try {
			Event event = daoEvent.read(id);
			if (event.getResult() == null) {
				ArrayList<Bet> bets = daoBet.findByEvent(id);
				for (Bet bet : bets) {
					user = daoUser.read(bet.getUser());
					user.setBalance(bet.getBetValue() + user.getBalance());
					if (!daoUser.update(user)) {
						logger.info("Update user fail " + user.getEmail());
						throw new Exception();
					}
					if (!daoBet.delete(bet.getIdBet())) {
						logger.info("Delete bet fail " + bet.getIdBet());
						throw new Exception();
					}
				}
			}
			if (!daoEvent.delete(id)) {
				logger.info("Delete event fail");
				throw new Exception();
			}
			page = Config.getInstance().getProperty(Config.MODER);
			logger.info("Create event");

		} catch (NullPointerException e) {
			// request.getSession().setAttribute("error",
			// Message.getInstance().getProperty(Message.SESSION_END));
			page = Config.getInstance().getProperty(Config.ERRORPAGE);
			logger.error("Session ended ", e);
		} catch (Exception e) {
			// request.getSession().setAttribute("error",
			// Message.getInstance().getProperty(Message.SESSION_END));
			page = Config.getInstance().getProperty(Config.ERRORPAGE);
			logger.error("Something wrong ", e);
		}
		return page;
	}

}
