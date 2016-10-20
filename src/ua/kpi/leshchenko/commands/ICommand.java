package ua.kpi.leshchenko.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {

	String execute(HttpServletRequest request, HttpServletResponse responce)
			throws ServletException, IOException;
}
