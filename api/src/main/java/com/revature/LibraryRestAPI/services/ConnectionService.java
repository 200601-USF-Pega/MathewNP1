package com.revature.LibraryRestAPI.services;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Logger;

import com.revature.LibraryRestAPI.web.Props;

public class ConnectionService {

    private static ConnectionService  connectionSingleton = null;
    private Connection connection;
    private static Logger logger = Logger.getLogger("Connection.class");

    public ConnectionService() {
        try  {
        	 Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(Props.url,
            Props.userName, Props.password);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnectionService getInstance() {
       if(connectionSingleton == null) {
           connectionSingleton = new ConnectionService();
           //System.out.println("Connection started.");
           logger.info("Connecton started.");
       }
       return connectionSingleton;
    }

    @Override
    public void finalize() {
        try {
            connection.close();
        } catch(Exception e) {

        }
    }

}
