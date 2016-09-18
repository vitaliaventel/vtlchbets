package ua.kpi.leshchenko.dao;

import java.util.ArrayList;

import ua.kpi.leshchenko.beans.Bet;

public interface BetDAO {

	public boolean create(Bet bet);

	public Bet read(int id);

	public boolean update(Bet bet);

	public boolean delete(int id);

	public ArrayList<Bet> findByUser(int id);

	public ArrayList<Bet> findAll();

	public ArrayList<Bet> findByEvent(int id);

}
