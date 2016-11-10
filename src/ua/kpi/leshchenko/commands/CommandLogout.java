package ua.kpi.leshchenko.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.kpi.leshchenko.manager.Config;

public class CommandLogout implements ICommand {

	private static Logger logger = Logger.getLogger(CommandLogout.class.getName());
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException {
		String page = null;
		try {
			page = Config.getInstance().getProperty(Config.MAIN);
			request.getSession(false).invalidate();
			logger.info("Logging out.");
		} catch (NullPointerException e) {
			//request.getSession().setAttribute("error", Message.getInstance().getProperty(Message.SESSION_END));
			page = Config.getInstance().getProperty(Config.ERRORPAGE);
			logger.error("Session ended ", e);
		}
		return page;
	}

}
