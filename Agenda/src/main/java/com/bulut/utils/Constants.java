package com.bulut.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Constants {
	
	public static String DB_URL = "jdbc:mysql://localhost:3306/Agenda";
	public static String DB_DRIVER = "com.mysql.jdbc.Driver";
	public static String DB_USER_NAME = "root";
	public static String DB_PASSWORD = "1234";
	

	public static String insertEvent = "INSERT INTO toDoList(EVENT_NAME, " +
														   "EVENT_DETAIL, " +
														   "EVENT_START_DATE, " +
														   "EVENT_START_TIME, " +
														   "EVENT_END_DATE, " +
														   "EVENT_END_TIME, " +
														   "EVENT_PLACE, " +
														   "EVENT_COMPLETE) " +
											  "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

	public static String retriveAllEvents = "SELECT * FROM toDoList";
	
	public static String deleteEvent = "DELETE FROM toDoList WHERE id = ?";
	
	public static String updateEvent = "UPDATE toDoList SET EVENT_COMPLETE = ? WHERE id = ?";
	
	
	static {
		Properties prop = new Properties();
		try {
			File fileCheckWin = new File("db.properties"); //Linux File check  
			prop.load(new FileInputStream(fileCheckWin));

			DB_URL = prop.getProperty("DB_URL", DB_URL).trim();
			DB_DRIVER = prop.getProperty("DB_DRIVER", DB_DRIVER).trim();
			DB_USER_NAME = prop.getProperty("DB_USER_NAME",DB_USER_NAME).trim();
			DB_PASSWORD = prop.getProperty("DB_PASSWORD", DB_PASSWORD).trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}