package ua.kpi.leshchenko.dao;

import java.util.ArrayList;

import ua.kpi.leshchenko.beans.Game;

public interface GameDAO {

	public boolean create(Game game);

	public Game read(int id);

	public boolean update(Game game);

	public boolean delete(int id);

	public ArrayList<Game> findAll();

}
