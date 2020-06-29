package com.revature.LibraryRestAPI.services;


import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.LibraryRestAPI.web.Props;

public class ConnectionService {


    private static ConnectionService  connectionSingleton = null;
    private Connection connection;
    private static Logger logger = LogManager.getLogger(ConnectionService.class);


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
