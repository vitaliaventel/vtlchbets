package ua.kpi.leshchenko.dao;

import java.util.ArrayList;
import ua.kpi.leshchenko.beans.User;

public interface UserDAO {

	boolean create(User user);

	User read(int id);

	boolean update(User user);

	boolean delete(int id);

	boolean find(String email, String password);

	ArrayList<User> findAll();

	User findByEmail(String email);

	ArrayList<User> findByUsertype(int userType);

	ArrayList<User> findByBalance();

}
