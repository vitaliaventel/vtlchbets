package ua.kpi.leshchenko.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.kpi.leshchenko.beans.Event;
import ua.kpi.leshchenko.beans.Game;
import ua.kpi.leshchenko.dao.DAOFactory;
import ua.kpi.leshchenko.dao.EventDAO;
import ua.kpi.leshchenko.dao.GameDAO;
import ua.kpi.leshchenko.manager.Config;

public class CommandEventCreate implements ICommand {

	private Logger logger = Logger.getLogger(CommandEventCreate.class.getName());
	private static final String GAMENAME = "gameName";
	private static final String TEAM1 = "team1";
	private static final String TEAM2 = "team2";
	private EventDAO daoEvent = DAOFactory.createEventDAO();
	private GameDAO daoGame = DAOFactory.createGameDAO();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException {
		String page = null;
		String team1 = request.getParameter(TEAM1);
		String team2 = request.getParameter(TEAM2);
		String gameName = request.getParameter(GAMENAME);

		try {
			Game game = daoGame.findByName(gameName);
			Event event = new Event();
			event.setTeam1(team1);
			event.setTeam2(team2);
			event.setGameType(game.getIdGame());
			if (!daoEvent.create(event)) {
				logger.info("Create event fail");
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
