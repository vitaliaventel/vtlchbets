package ua.kpi.leshchenko.dao;

import java.util.ArrayList;

import ua.kpi.leshchenko.beans.Bet;

public interface BetDAO {

	boolean create(Bet bet);

	Bet read(int id);

	boolean update(Bet bet);

	boolean delete(int id);

	ArrayList<Bet> findByUser(int id);

	ArrayList<Bet> findAll();

	ArrayList<Bet> findByEvent(int id);

}
