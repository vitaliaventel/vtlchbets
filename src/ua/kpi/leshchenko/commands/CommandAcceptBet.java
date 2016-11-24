package ua.kpi.leshchenko.commands;

import java.io.IOException;

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

public class CommandAcceptBet implements ICommand {

	private static Logger logger = Logger.getLogger(CommandAcceptBet.class.getName());
	private BetDAO daoBet = DAOFactory.createBetDAO();
	private UserDAO daoUser = DAOFactory.createUserDAO();
	private EventDAO daoEvent = DAOFactory.createEventDAO();
	private static final String WINNER = "winner";
	private static final String BET = "betValue";
	private static final String ID = "id";
	private static final String EMAIL = "email";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException {
		String page = null;
		Bet bet = new Bet();
		try {
			User user = daoUser.findByEmail((String) request.getSession(false).getAttribute(EMAIL));
			int id = Integer.parseInt(request.getParameter(ID));
			String winner = request.getParameter(WINNER);
			double betValue = Double.parseDouble(request.getParameter(BET));
			user.setBalance(user.getBalance() - betValue);
			if (!daoUser.update(user)) {
				// request.getSession().setAttribute("error",
				// Message.getInstance().getProperty(Message.LOGIN_ERROR));
				page = Config.getInstance().getProperty(Config.ERRORPAGE);
				logger.info("Cant update user balance " + user.getEmail());
				throw new Exception();
			}
			Event event = daoEvent.read(id);
			if (winner.equals("team1")) {
				event.setTeamValue1(event.getTeamValue1() + betValue);
			} else {
				event.setTeamValue2(event.getTeamValue2() + betValue);
			}
			if (!daoEvent.update(event)) {
				// request.getSession().setAttribute("error",
				// Message.getInstance().getProperty(Message.LOGIN_ERROR));
				page = Config.getInstance().getProperty(Config.ERRORPAGE);
				logger.info("Cant update event info" + event.getIdEvent());
				throw new Exception();
			}
			bet.setBetValue(betValue);
			bet.setEvent(event.getIdEvent());
			bet.setUser(user.getIdUser());
			bet.setWinner(winner);
			if(!daoBet.create(bet)){
				// request.getSession().setAttribute("error",
				// Message.getInstance().getProperty(Message.LOGIN_ERROR));
				page = Config.getInstance().getProperty(Config.ERRORPAGE);
				logger.info("Cant create bet, for user " + user.getEmail() + " and event " + event.getIdEvent());
				throw new Exception();
			}

			request.getSession(false).setAttribute("balance", user.getBalance());
			page = Config.getInstance().getProperty(Config.MAINLOGGED);
			logger.info("Successful bet for user " + user.getEmail());
		} catch (NullPointerException e) {
			// request.getSession().setAttribute("error",
			// Message.getInstance().getProperty(Message.SESSION_END));
			page = Config.getInstance().getProperty(Config.ERRORPAGE);
			logger.error("Session ended ", e);
		} catch (Exception e) {
			page = Config.getInstance().getProperty(Config.ERRORPAGE);
			logger.error("Troubles with accept bet ", e);
		}
		return page;
	}

}
