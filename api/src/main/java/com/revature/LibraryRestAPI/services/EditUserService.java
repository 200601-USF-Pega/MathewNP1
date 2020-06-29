package com.revature.LibraryRestAPI.services;

import com.revature.LibraryRestAPI.models.User;
import com.revature.LibraryRestApi.dao.UserRepoDB;

public class EditUserService {
	UserRepoDB userRepoDB = new UserRepoDB();


	public void editUser(User user) {
		String userName = user.getUserName();
		userRepoDB.updateFirstName(userName, user.getFirstName());
		userRepoDB.updateLastName(userName, user.getLastName());
		userRepoDB.updatePassword(userName, user.getPwd());
		userRepoDB.updateAccess(userName, user.getAccess().toString());

	}
}
