package ua.kpi.leshchenko.dao;

import java.util.ArrayList;

import ua.kpi.leshchenko.beans.UserType;

public interface UserTypeDAO {

	boolean create(UserType type);

	UserType read(int id);

	boolean update(UserType type);

	boolean delete(int id);
	
	ArrayList<UserType> findAll();

}
