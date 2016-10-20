package ua.kpi.leshchenko.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import ua.kpi.leshchenko.commands.CommandMissing;
import ua.kpi.leshchenko.commands.ICommand;

public class CHelper {

	private static Logger logger = Logger.getLogger(CHelper.class.getName());
	private static CHelper instance = null;
	private HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

	private CHelper() {

	}

	public ICommand getCommand(HttpServletRequest request) {
		logger.info("Try to get_Command.");
		ICommand command = commands.get(request.getParameter("command"));
		if (command == null) {
			logger.warn("Command is missing!");
			command = new CommandMissing();
		}
		return command;
	}

	public static CHelper getInstance() {
		if (instance == null) {
			instance = new CHelper();
		}
		return instance;
	}
}
