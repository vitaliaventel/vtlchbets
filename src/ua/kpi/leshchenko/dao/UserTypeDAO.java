package ua.kpi.leshchenko.dao;

import ua.kpi.leshchenko.beans.UserType;

public interface UserTypeDAO {

	public boolean create(UserType type);

	public UserType read(int id);

	public boolean update(UserType type);

	public boolean delete(int id);

}
