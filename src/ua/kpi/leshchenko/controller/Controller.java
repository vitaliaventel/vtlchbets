package ua.kpi.leshchenko.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.kpi.leshchenko.commands.ICommand;
import ua.kpi.leshchenko.dao.DAOFactory;
import ua.kpi.leshchenko.dao.EventDAO;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {

	private CHelper helper = CHelper.getInstance();
	private static Logger logger = Logger.getLogger(Controller.class.getName());
	private EventDAO daoEvent = DAOFactory.createEventDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = null;
		ServletContext context = request.getSession().getServletContext();
		try {
			ICommand command = helper.getCommand(request);
			page = command.execute(request, response);
			context.setAttribute("eventListUp", daoEvent.findNotFinished());
			context.setAttribute("eventListFinish", daoEvent.findFinished());
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
