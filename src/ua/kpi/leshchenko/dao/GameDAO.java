package ua.kpi.leshchenko.dao;

import java.util.ArrayList;

import ua.kpi.leshchenko.beans.Game;

public interface GameDAO {

	boolean create(Game game);

	Game read(int id);

	boolean update(Game game);

	boolean delete(int id);

	ArrayList<Game> findAll();
	
	Game findByName(String name);

}
