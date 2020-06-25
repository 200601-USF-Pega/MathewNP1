package com.revature.LibraryRestApi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.LibraryRestAPI.models.Author;
import com.revature.LibraryRestAPI.services.ConnectionService;

public class CategoryRepoDB {

    public Author addCategory(String category){
        try{
            PreparedStatement userStatement = ConnectionService.getInstance().getConnection()
                    .prepareStatement("INSERT INTO Category(category) VALUES(?)");
            userStatement.setString(1, category);
            userStatement.executeUpdate();
        } catch(SQLException e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getAllCategories() {
        List<String> allCategories= new ArrayList();
        try{
            Statement getAllCategories= ConnectionService.getInstance().getConnection().createStatement();
            getAllCategories.executeQuery("SELECT * from Category");
            ResultSet rs  = getAllCategories.getResultSet();

            while(rs.next()) {
                allCategories.add(rs.getString("category"));
            }
            return allCategories;
        } catch(SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
}
