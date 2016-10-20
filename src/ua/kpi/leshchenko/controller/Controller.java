package ua.kpi.leshchenko.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.kpi.leshchenko.commands.ICommand;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {

	private CHelper helper = CHelper.getInstance();
	private static Logger logger = Logger.getLogger(Controller.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = null;
		try {
			ICommand command = helper.getCommand(request);
			page = command.execute(request, response);
		} catch (ServletException e) {;
			logger.error("Servlet exception", e);
		} catch (IOException e) {
			logger.error("IOExeption", e);
		}
		logger.info("Forwarding to " + page);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
