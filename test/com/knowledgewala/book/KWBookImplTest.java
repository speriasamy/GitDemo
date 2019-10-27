package com.knowledgewala.book;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

/**
 * This class helps to test maintain Book functionality.
 * @author dsahu1
 *
 */
public class KWBookImplTest extends TestCase{
	
	//Instantiate KWLibrary object to call methods 
	static KWBook kwBookObj = new KWBookImpl();
	//Instantiate Map
	Map<Long, KWBookDetails> kwBookMap = new HashMap<Long, KWBookDetails>();
	
	/**
	 * This method helps to add Book into the map.
	 */
	public void testAddBook(){
		//Instantiate KWBookDetails Object
		KWBookDetails kwBookDetails = new KWBookDetails();
		//Set Book details to map
		kwBookDetails.setTitle("CORE JAVA");
		kwBookDetails.setAuthor("Khalid Mughal");
		kwBookDetails.setBookID(1l);
		kwBookDetails.setIssued(Boolean.TRUE.booleanValue());
		kwBookDetails.setLibraryID(1l);
		kwBookDetails.setPublisher("RAJ BOOK");
		kwBookDetails.setTotalPage(252);
		//Call method to add Book
		kwBookObj.addBook(kwBookDetails , kwBookMap);
		//Check map size
		assertTrue(!kwBookMap.isEmpty());
		assertEquals(1, kwBookMap.size());
		assertEquals("CORE JAVA", kwBookMap.get(1l).getTitle());
		
		//Instantiate KWBookDetails Object
		kwBookDetails = new KWBookDetails();
		//Set Book details to map
		kwBookDetails.setTitle("J2EE");
		kwBookDetails.setAuthor("Micheal");
		kwBookDetails.setBookID(2l);
		kwBookDetails.setIssued(Boolean.FALSE.booleanValue());
		kwBookDetails.setLibraryID(1l);
		kwBookDetails.setPublisher("Complete Reference Publi");
		kwBookDetails.setTotalPage(512);
		//Call method to add Book
		kwBookObj.addBook(kwBookDetails , kwBookMap);
		//Check map size
		assertEquals(2, kwBookMap.size());
		assertEquals("CORE JAVA", kwBookMap.get(1l).getTitle());
	}
	/**
	 * This method helps to delete Book from the map.
	 */
	public void testDeleteBook(){
		//Call method to add Book
		testAddBook();
		//Check total Book added before deletion
		assertEquals(2, kwBookMap.size());
		//Call method to delete book
		kwBookObj.deleteBook(2l, kwBookMap);		
		//Check total Book added after deletion
		assertEquals(1, kwBookMap.size());
		//try to remove already issued book
		kwBookObj.deleteBook(1l, kwBookMap);
		//Check total Book added after deletion
		assertEquals(1, kwBookMap.size());		
	}
	/**
	 * This method helps to test display available book.
	 */
	public void testDisplayAvailableBookInfo(){
		//Call method to add Book
		testAddBook();
		//Check total Book added before deletion
		assertEquals(2, kwBookMap.size());
		//Call method to delete book
		kwBookObj.displayAvailableBookInfo(kwBookMap);		
	}
	/**
	 * This method helps to test display issued book.
	 */
	public void testdisplayIssuedBookInfo(){
		//Call method to add Book
		testAddBook();
		//Check total Book added before deletion
		assertEquals(2, kwBookMap.size());
		//Call method to delete book
		kwBookObj.displayIssuedBookInfo(kwBookMap);		
	}
	
	

}
