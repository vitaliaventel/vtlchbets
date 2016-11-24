package ua.kpi.leshchenko.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import ua.kpi.leshchenko.commands.CommandAcceptBet;
import ua.kpi.leshchenko.commands.CommandEditProfile;
import ua.kpi.leshchenko.commands.CommandLogin;
import ua.kpi.leshchenko.commands.CommandLogout;
import ua.kpi.leshchenko.commands.CommandMenu;
import ua.kpi.leshchenko.commands.CommandMissing;
import ua.kpi.leshchenko.commands.CommandSignUp;
import ua.kpi.leshchenko.commands.CommandToSignUp;
import ua.kpi.leshchenko.commands.ICommand;

public class CHelper {

	private static Logger logger = Logger.getLogger(CHelper.class.getName());
	private static CHelper instance = null;
	private HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

	private CHelper() {
		commands.put("signin", new CommandLogin());
		commands.put("signup", new CommandSignUp());
		commands.put("logout", new CommandLogout());
		commands.put("tosignup", new CommandToSignUp());
		commands.put("acceptBet", new CommandAcceptBet());
		commands.put("menu", new CommandMenu());
		commands.put("editprofile", new CommandEditProfile());
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
