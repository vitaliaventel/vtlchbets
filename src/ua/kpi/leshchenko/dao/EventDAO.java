package ua.kpi.leshchenko.dao;

import java.util.ArrayList;

import ua.kpi.leshchenko.beans.Event;

public interface EventDAO {

	boolean create(Event event);

	Event read(int id);

	boolean update(Event event);

	boolean delete(int id);

	ArrayList<Event> findByTeam(String team);

	ArrayList<Event> findAll();

	ArrayList<Event> findByResult(String result);

	ArrayList<Event> findByGametype(int gameType);

}
