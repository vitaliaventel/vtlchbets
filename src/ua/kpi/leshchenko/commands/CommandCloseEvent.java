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
import ua.kpi.leshchenko.manager.Message;

public class CommandCloseEvent implements ICommand {

	private static Logger logger = Logger.getLogger(CommandCloseEvent.class.getName());
	private BetDAO daoBet = DAOFactory.createBetDAO();
	private UserDAO daoUser = DAOFactory.createUserDAO();
	private EventDAO daoEvent = DAOFactory.createEventDAO();
	private static final String WINNER = "winner";
	private static final String ID = "id";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException {
		String page = null;
		double coeffiecient = 0;
		try {
			int id = Integer.parseInt(request.getParameter(ID));
			String winner = request.getParameter(WINNER);
			Event event = daoEvent.read(id);
			event.setResult(winner);
			if (!daoEvent.update(event)) {
				request.getSession().setAttribute("error", Message.getInstance().getProperty(Message.UPDATE_EVENT_ERROR));
				logger.info("Cant update event info" + event.getIdEvent());
				throw new Exception();
			}

			double teamValue1 = event.getTeamValue1();
			double teamValue2 = event.getTeamValue2();
			if (winner.equals("team1")) {
				coeffiecient = (teamValue2 / teamValue1 + 1);
			} else {
				coeffiecient = (teamValue1 / teamValue2 + 1);
			}

			ArrayList<Bet> bets = daoBet.findByEvent(id);
			for (Bet b : bets) {
				if (b.getWinner().equals(winner)) {
					User us = daoUser.read(b.getUser());
					us.setBalance(us.getBalance() + b.getBetValue() * coeffiecient);
					if (!daoUser.update(us)) {
						 request.getSession().setAttribute("error",
						 Message.getInstance().getProperty(Message.UPDATE_USER_ERROR));
						logger.info("Cant update user info" + us.getEmail());
						throw new Exception();
					}
				}
			}
			page = Config.getInstance().getProperty(Config.MODER);
			logger.info("Successful event close " + event.getIdEvent());
		} catch (NullPointerException e) {
			request.getSession().setAttribute("error", Message.getInstance().getProperty(Message.SESSION_END));
			page = Config.getInstance().getProperty(Config.ERRORPAGE);
			logger.error("Session ended ", e);
		} catch (Exception e) {
			page = Config.getInstance().getProperty(Config.ERRORPAGE);
			logger.error("Troubles with close event ", e);
		}
		return page;
	}

}
