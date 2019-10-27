package com.knowledgewala.book;

import java.util.Map;
/**
 * This class helps to implement business logic for Books.
 * @author dsahu1
 *
 *
 */
public interface KWBook {
	/**
	 * This method helps to add books.
	 *
	 * @param kwBookDetails
	 * 		- Contains Books Details like title, author etc.
	 * @param kwBookMap
	 * 		- Contains Books information in the map
	 * @return Boolean
	 * 		- Contains true or false value
	 */
	public Boolean addBook(KWBookDetails kwBookDetails,Map<Long, KWBookDetails> kwBookMap);

	/**
	 * This method helps to delete book details from the map.
	 *
	 * @param bookID
	 *            -Contains BookID information
	 * @param kwBookMap
	 *            - Contains Books Map
	 * @return Boolean - Contains true or false value based on record deletion
	 */
	public Boolean deleteBook(Long bookID,Map<Long, KWBookDetails> kwBookMap);

	/**
	 * This method helps to update book information.
	 *
	 * @param kwBookDetails
	 *            - Contains Book Details
	 * @param kwBookMap
	 *            - Contains Book in the map
	 * @return KWBookDetails - Contains Book details
	 */
	public KWBookDetails updateBook(KWBookDetails kwBookDetails,Map<Long, KWBookDetails> kwBookMap);

	/**
	 * This method helps to display all available book.
	 *
	 * @param kwBookMap
	 * 		- Contains Books information in the map
	 */
	public void displayAvailableBookInfo(Map<Long, KWBookDetails> kwBookMap);

	/**
	 * This method helps to display all issued book.
	 *
	 * @param kwBookMap
	 * 		- Contains Books information in the map
	 */
	public void displayIssuedBookInfo(Map<Long, KWBookDetails> kwBookMap);
}
