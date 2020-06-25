package com.revature.LibraryRestApi.dao;

import java.util.List;

import com.revature.LibraryRestAPI.models.User;

public interface IUserRepo {
    public User addUser(User user);
    public void deleteUser(User user);
    public List<User> getAllUsers();
}
