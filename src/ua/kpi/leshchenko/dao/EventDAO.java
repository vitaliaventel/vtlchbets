package ua.kpi.leshchenko.dao;

import java.util.ArrayList;

import ua.kpi.leshchenko.beans.Event;

public interface EventDAO {

	public boolean create(Event event);

	public Event read(int id);

	public boolean update(Event event);

	public boolean delete(int id);

	public ArrayList<Event> findByTeam(String team);

	public ArrayList<Event> findAll();

	public ArrayList<Event> findByResult(String result);

	public ArrayList<Event> findByGametype(int gameType);

}
