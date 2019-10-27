package com.knowledgewala.book;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.knowledgewala.common.KWConstants;
import com.knowledgewala.common.KWFormattedColumns;
/** 
 * This class helps to implement business logic for Books.
 * 
 * @author dsahu1
 *
 */
public class KWBookImpl implements KWBook{
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
	@Override
	public Boolean addBook(KWBookDetails kwBookDetails,Map<Long, KWBookDetails> kwBookMap) {
		//Add book to map
		kwBookMap.put(kwBookDetails.getBookID(), kwBookDetails);
		//Return true once book added
		return Boolean.TRUE.booleanValue();
	}
	/**
	 * This method helps to delete book details from the map.
	 * 
	 * @param bookID
	 *            -Contains BookID information
	 * @param kwBookMap
	 *            - Contains Books Map
	 * @return Boolean - Contains true or false value based on record deletion
	 */
	@Override
	public Boolean deleteBook(Long bookID,Map<Long, KWBookDetails> kwBookMap) {
		//Iterate Book map
		Iterator<Entry<Long, KWBookDetails>> itr = kwBookMap
		.entrySet().iterator();
		//Iterate Books
		while (itr.hasNext()) {			
			Entry<Long, KWBookDetails> entry = itr.next();
			//Compare bookID and remove
			if(bookID == entry.getKey()){
				
				if(entry.getValue().getIssued()){
					System.out.println("You can not delete issued book!");
					break;
				}
				//Remove book entry from the map
				itr.remove();
				//Return true
				return Boolean.TRUE.booleanValue();
			}			
		}
		//Return false if book not deleted
		return Boolean.FALSE.booleanValue();
	}

	/**
	 * This method helps to update book information.
	 * 
	 * @param kwBookDetails
	 *            - Contains Book Details
	 * @param kwBookMap
	 *            - Contains Book in the map
	 * @return KWBookDetails - Contains Book details
	 */
	@Override
	public KWBookDetails updateBook(KWBookDetails kwBookDetails, Map<Long, KWBookDetails> kwBookMap) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method helps to display all available book.
	 * 
	 * @param kwBookMap
	 * 		- Contains Books information in the map
	 */
	@Override
	public void displayAvailableBookInfo(Map<Long, KWBookDetails> kwBookMap) {
		
		//Iterate Book map
		Iterator<Entry<Long, KWBookDetails>> itr = kwBookMap
				.entrySet().iterator();
		//Instantiate Column object
		KWFormattedColumns formattedColumnsObj = new KWFormattedColumns();		
		formattedColumnsObj.addLine(KWConstants.KWBOOKID,KWConstants.KWAUTHOR,KWConstants.KWTITLE);
		//Iterate Books object
		while (itr.hasNext()) {			
			Entry<Long, KWBookDetails> entry = itr.next();
			KWBookDetails kwBookDetails = entry.getValue();
			//Check issued indicator as false
			if(kwBookDetails!=null && !kwBookDetails.getIssued()){
				formattedColumnsObj.addLine(entry.getKey().toString(),
						kwBookDetails.getAuthor(), kwBookDetails.getTitle());
			}			
		}
		//print the column
		formattedColumnsObj.print();		
	}

	/**
	 * This method helps to display all issued book.
	 * 
	 * @param kwBookMap
	 * 		- Contains Books information in the map
	 */
	@Override
	public void displayIssuedBookInfo(Map<Long, KWBookDetails> kwBookMap) {
		//Iterate Book map
		Iterator<Entry<Long, KWBookDetails>> itr = kwBookMap
		.entrySet().iterator();
		//Instantiate Column object
		KWFormattedColumns formattedColumnsObj = new KWFormattedColumns();		
		formattedColumnsObj.addLine(KWConstants.KWBOOKID,KWConstants.KWAUTHOR,KWConstants.KWTITLE);
		//Iterate Books object
		while (itr.hasNext()) {			
			Entry<Long, KWBookDetails> entry = itr.next();
			KWBookDetails kwBookDetails = entry.getValue();
			//Check issued indicator and it should be true
			if(kwBookDetails.getIssued()){				
				formattedColumnsObj.addLine(entry.getKey().toString(),
						kwBookDetails.getAuthor(), kwBookDetails.getTitle());
			}			
		}
		//print the column
		formattedColumnsObj.print();
	}

}
