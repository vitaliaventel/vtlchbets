package ua.kpi.leshchenko.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.kpi.leshchenko.manager.Config;

public class CommandToSignUp implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException {
		return Config.getInstance().getProperty(Config.SIGNUP);
	}

}
