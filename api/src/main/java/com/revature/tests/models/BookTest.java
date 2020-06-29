package com.revature.tests.models;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.LibraryRestAPI.models.Author;
import com.revature.LibraryRestAPI.models.Book;

public class BookTest {

	@Test
	public void sameBookTest() {
		Book book1 = new Book();
		book1.setAuthor(new Author("Navin", "Mathew"));
		book1.setTitle("Specture in the Glass");

		Book book2 = new Book();
		book2.setAuthor(new Author("Navin", "Mathew"));
		book2.setTitle("Specture in the Glass");
		assertTrue(book1.equals(book2));

	}
}
