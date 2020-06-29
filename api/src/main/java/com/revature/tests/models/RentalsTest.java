package com.revature.tests.models;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.revature.LibraryRestAPI.models.Author;
import com.revature.LibraryRestAPI.models.Book;
import com.revature.LibraryRestAPI.models.Rental;

public class RentalsTest{
	private Book book;

	@Before
	public void makeBook() {
		book = new Book();
		book.setAuthor(new Author("Gerald", "Sussman")); 
		book.setCategory("educational");
	}
	@Test
	public void DateTime() {

	    LocalDate date = LocalDate.now(); 
		Rental rental1 = new Rental();
		rental1.setBook(book);
		rental1.setStartDate(LocalDate.now().toString());
		
		Rental rental2 = new Rental();
		rental2.setBook(book);
		rental1.setStartDate(LocalDate.now().toString());
		
		assertTrue(rental2.equals(rental1));
		
		
		
		
	}

}

