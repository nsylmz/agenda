package com.bulut.utils;

import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;

public class DbUtils {

	public static BasicDataSource DBSOURCE = new BasicDataSource();
    
    static {
	    DBSOURCE.setDriverClassName(Constants.DB_DRIVER);
	    DBSOURCE.setUsername(Constants.DB_USER_NAME);
	    DBSOURCE.setPassword(Constants.DB_PASSWORD);
	    DBSOURCE.setUrl(Constants.DB_URL);
	    DBSOURCE.setValidationQuery("SELECT 1");
	    DBSOURCE.setPoolPreparedStatements(true);
	    DBSOURCE.setInitialSize(1);
 	    DBSOURCE.setMaxActive(3);
        DBSOURCE.setMaxIdle(-1);
        DBSOURCE.setMaxOpenPreparedStatements(-1);
    }

	public static Connection getConnection() throws Exception {
		
		try {
			Connection connection = DBSOURCE.getConnection();
			return connection;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void closecon(Connection connection) {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
