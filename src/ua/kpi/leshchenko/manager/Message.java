package ua.kpi.leshchenko.manager;

import java.util.ResourceBundle;

public class Message {

	private static Message instance;
	private ResourceBundle resource;
	private static final String BUNDLE_NAME = "ua.kpi.leshchenko.manager.messages";
	public static final String SERVLET_EXECPTION = "SERVLET_EXCEPTION";
	public static final String IO_EXCEPTION = "IO_EXCEPTION";
	public static final String LOGIN_ERROR = "LOGIN_ERROR";
	public static final String REGISTER_ERROR = "REGISTER_ERROR";
	public static final String SESSION_END = "SESSION_END";
	public static final String BLACK_LIST = "BLACK_LIST";
	public static final String MISS_ORDER = "MISS_ORDER";
	public static final String CREATE_BET_ERROR = "CREATE_BET_ERROR";
	public static final String UPDATE_EVENT_ERROR = "UPDATE_EVENT_ERROR";
	public static final String UPDATE_USER_ERROR = "UPDATE_USER_ERROR";
	public static final String CREATE_EVENT_ERROR = "CREATE_EVENT_ERROR";
	public static final String DELETE_EVENT_ERROR = "DELETE_EVENT_ERROR";
	public static final String DELETE_BET_ERROR = "DELETE_BET_ERROR";
	public static final String ADMIN_VIEW_ERROR = "ADMIN_VIEW_ERROR";
	
	public static Message getInstance() {
		if (instance == null) {
			instance = new Message();
			instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
		}
		return instance;
	}

	public String getProperty(String key) {
		return (String) resource.getObject(key);
	}
}
