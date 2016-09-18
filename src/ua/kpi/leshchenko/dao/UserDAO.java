package ua.kpi.leshchenko.dao;

import java.util.ArrayList;
import ua.kpi.leshchenko.beans.User;

public interface UserDAO {

	public boolean create(User user);

	public User read(int id);

	public boolean update(User user);

	public boolean delete(int id);

	public boolean find(String email, String password);

	public ArrayList<User> findAll();

	public User findByEmail(String email);

	public ArrayList<User> findByUsertype(int userType);

	public ArrayList<User> findByBalance();

}
