package com.revature.tests.models;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.LibraryRestAPI.models.User;

public class UserTest {
	@Test
	public void sameUser() {
		User user1 = new User();
		user1.setUserName("nmathew13");
		user1.setFirstName("Elmo");
		user1.setLastName("Patrick");

		User user2 = new User(); 
		user2.setUserName("nmathew13");
		user1.setFirstName("Navin");
		user1.setLastName("Mathew");
		
		assertTrue(user1.equals(user2));
		
	}
}
