package com.knowledgewala.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.knowledgewala.book.KWBook;
import com.knowledgewala.book.KWBookDetails;
import com.knowledgewala.book.KWBookImpl;
import com.knowledgewala.common.KWConstants;
import com.knowledgewala.common.KWFormattedColumns;
import com.knowledgewala.library.KWLibrary;
import com.knowledgewala.library.KWLibraryDetails;
import com.knowledgewala.library.KWLibraryImpl;

/**
 * ******************************************************************* 
 * This
 * class helps to maintain library like - 1. Start Library Application as Java
 * 2. Stop Library Application 3. Add new Library and address 4. Add new Book
 * and it's association with library. 5. Update books and library details
 * *******************************************************************
 * 
 * @author dsahu1
 * 
 */
@SuppressWarnings("rawtypes")
public class KnowledgeWalaMaintainLibrary {
	
	//This attribute stores library related information
	static Map<Long, KWLibraryDetails> kwLibraryMap = new TreeMap<Long, KWLibraryDetails>(); 
	//This attribute stores book related information
	static Map<Long, KWBookDetails> kwBookMap = new TreeMap<Long, KWBookDetails>();
	//This attribute store library and book association	
	static Map<Long, Set> kwLibraryBookAssociation = new TreeMap<Long, Set>();
	//This attribute helps to take input from keyboard
	//static Scanner scanner = new Scanner(System.in);
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader bufferedReader = new BufferedReader(isr);
	//Instantiate KWLibrary object to call methods 
	static KWLibrary kwLibraryObj = new KWLibraryImpl();
	//Instantiate KWBook object to call methods
	static KWBook kwBookObj = new KWBookImpl();
	//Declare variable to generate unique number
	static Long index = 0l;
	/**
	 * This method helps to start knowledgewala library application.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.println("********************************************");
		System.out.println("  Welcome to KnowledgeWala Library  ");
		System.out.println("********************************************");
		System.out.println("--- Please select you obtion to take action --- ");
		//Call method to display menu
		mainMenu();		
		//Call scanner to get value as input
		//Scanner scanner = new Scanner(System.in);
		//set boolean to exit application
		Boolean isNotExit = true;
		//Start loop to get option multiple time
		while(isNotExit){
			System.out.println("********* Please Enter your Option *********");
			try{
			Integer selectedOption = Integer.valueOf(bufferedReader.readLine());
			//Call method to take action based on input value
			
				action(selectedOption);
			}catch (Exception e) {
				System.out.println("Error Input : "+e.getMessage());	
				continue;
			}
						
		}	
	}
	/**
	 * This method helps to stop current running Java Virtual Machine.
	 */
	private static void  stopApplication(){
		// Call method to stop application
		System.exit(1);
	}
	/**
	 * This method helps to invoke action based on selected options from the menu.
	 * @param selectedOption
	 * 		- Contains options value from 1 to 6
	 * @throws IOException 
	 */
	private static void action(Integer selectedOption) throws IOException{	
		//pass selected input parameter
		switch(selectedOption){	
		case 0: 
			System.out.println("****Library Details****"+KWConstants.KWLINECHANGE);
			//Call method to display Library Information
			iterateAndDispLibraryMap(kwLibraryMap);
			//Call method to display main menu
			mainMenu();
			break;
			
		case 1: 
			System.out.println("****Library and Book Association Details****"+KWConstants.KWLINECHANGE);
			//Call method to display Books associated to Library
			displayLibraryBookAss(kwLibraryBookAssociation);
			//Call method to display main menu
			mainMenu();
			break;
		case 2:
			System.out.println("****Display Existing Available Books****"+KWConstants.KWLINECHANGE);
			//Call method to display library information
			displayAvailableBookInfo(kwBookMap);
			break;
		case 3:
			System.out.println("****Display Existing Issued Books****"+KWConstants.KWLINECHANGE);
			//call method to display issued books
			displayIssuedBookInfo(kwBookMap);
			//Call method to display main menu
			mainMenu();
			break;
		case 4:
			System.out.println("****Add New Libray****"+KWConstants.KWLINECHANGE);
			//Call method to add Library
			addLibrary();
			//Call method to display main menu
			mainMenu();
			break;
		case 5:
			System.out.println("****Add New Book****"+KWConstants.KWLINECHANGE);
			//Call method to add Book
			addBook();
			//Call method to display main menu
			mainMenu();
			break;
		case 6:
			System.out.println("****Issue a Book****"+KWConstants.KWLINECHANGE);
			//Call method to issue Book
			issueBook();
			//Call method to display main menu
			mainMenu();
			break;
		case 7:
			System.out.println("****Delete a Book****"+KWConstants.KWLINECHANGE);
			//Call method to issue Book
			deleteBook(kwBookMap);
			//Call method to display main menu
			mainMenu();
			break;
		case 8:
			System.out.println("Application Stoped......Have a Nice Day! :)");
			//Call method to stop application
			stopApplication();
			//Call method to display main menu
			mainMenu();
			break;
		default:
			System.out.println("Option Not Recognized!");
			//Call method to display main menu
			mainMenu();
			break;
		
		}
	}
	/**
	 * This method helps to create main menu.
	 */
	private static void mainMenu() {
		//Instantiate FormattedColumns Object to print line
		KWFormattedColumns formattedColumnsObj = new KWFormattedColumns();
		//Add lines of record
		formattedColumnsObj
				.addLine(
						"********** MAIN MENU **********")
				.addLine(
						"Press '0' To Display Existing Libraries")
				.addLine(
						"Press '1' To Display Existing Libraries and Books Details")
				.addLine("Press '2' To Display Existing Available Books")
				.addLine("Press '3' To Display Existing Issues Books")
				.addLine("Press '4' To Add New Libray")
				.addLine("Press '5' To Add New Book")
				.addLine("Press '6' Issue a Book")
				.addLine("Press '7' Delete a Book")
				.addLine("Press '8' To Stop KnowledgeWala Application");
		//print the output
		formattedColumnsObj.print();
		
	}
	/**
	 * This method helps to add book.
	 * 
	 * @return Boolean
	 * 		- Contains Boolean value as true or false
	 * @throws IOException 
	 */
	private static Boolean addBook() throws IOException{
		try{
			//Scanner tempScanner = new Scanner(System.in);
			//Set default values
			KWBookDetails kwBookDetails = new KWBookDetails();
			kwBookDetails.setTotalPage((int) (Math.random()*100));
			kwBookDetails.setBookID(++index);
			kwBookDetails.setIssued(false);	
			
			//get Book details as input		
			System.out.println("Enter Book Title -");
			kwBookDetails.setTitle(bufferedReader.readLine());
			System.out.println("Enter Book Author -");
			kwBookDetails.setAuthor(bufferedReader.readLine() );
			System.out.println("Enter Associated LibraryID -");
			kwBookDetails.setLibraryID(Long.valueOf(bufferedReader.readLine()));			
			System.out.println("Enter Publisher -");
			kwBookDetails.setPublisher(bufferedReader.readLine());
			//Check Library ID available or Not
			validateLibraryID(kwBookDetails);
			
			return kwBookObj.addBook(kwBookDetails,kwBookMap);
		}catch(NumberFormatException nfe){
			nfe.getMessage();
			
		}		
		return Boolean.FALSE.booleanValue();
		
	}
	
	/**
	 * This method helps to issue a book.
	 * 
	 * @return Boolean
	 * 		- Contains Boolean value as true or false
	 * @throws IOException 
	 */
	private static Boolean issueBook() throws IOException{
		
		//Check Map empty
		if(kwBookMap.isEmpty()){
			System.out.println("No Book Added Yet!");		
			
			return Boolean.FALSE.booleanValue();
		}else{			
			try{
				displayAvailableBookInfo(kwBookMap);
				System.out.println("Enter BookID from above to issue");
				Long bookID = Long.valueOf(bufferedReader.readLine());
				if(kwBookMap.containsKey(bookID)){					
					//update book
					kwBookMap.get(bookID).setIssued(Boolean.TRUE.booleanValue());
				}else{
					System.out.println("BookID Not available!");
					//return true once book issues
					return Boolean.TRUE.booleanValue();
				}				
				//return true once book issues
				return Boolean.TRUE.booleanValue();
			}catch(NumberFormatException nfe){
				nfe.getMessage();
				
			}
		}		
		return Boolean.FALSE.booleanValue();
		
	}
	
	/**
	 * This method helps to delete a book.
	 * 
	 * @return Boolean
	 * 		- Contains Boolean value as true or false
	 * @throws IOException 
	 */
	private static Boolean deleteBook(Map<Long,KWBookDetails> kwBookMap) throws IOException{
		//Check Map empty
		if(kwBookMap.isEmpty()){
			System.out.println("No Book Added Yet!");		
			
			return Boolean.FALSE.booleanValue();
		}else{			
			try{
				displayAvailableBookInfo(kwBookMap);
				System.out.println("Enter BookID from above to delete");
				Long bookID = Long.valueOf(bufferedReader.readLine());
				if(kwBookMap.containsKey(bookID)){
					
					//Call method to delete book
					kwBookObj.deleteBook(bookID, kwBookMap);
				}else{
					System.out.println("BookID Not available!");
					//return true once book issues
					return Boolean.TRUE.booleanValue();
				}			
				
				//return true once book issues
				return Boolean.TRUE.booleanValue();
			}catch(NumberFormatException nfe){
				nfe.getMessage();
				
			}
		}			
		
		return Boolean.FALSE.booleanValue();
		
	}
	
	
	/**
	 * This method helps to add Library information.
	 * 
	 * @return Boolean
	 * @throws IOException 
	 */
	private static Boolean addLibrary() throws IOException {
		
		//Scanner tempScanner = new Scanner(System.in);
		//Set default values
		KWLibraryDetails kwLibraryDetails = new KWLibraryDetails();
		kwLibraryDetails.setLibraryID(++index);
		kwLibraryDetails.setIsActive(Boolean.TRUE.booleanValue());
		kwLibraryDetails.setIsPublicLibrary(Boolean.TRUE.booleanValue());
		kwLibraryObj.addLibrary(kwLibraryDetails, kwLibraryMap);
		
		//get Library details as input		
		System.out.println("Enter Library Name -");
		String name = bufferedReader.readLine();
		kwLibraryDetails.setName(name);
		System.out.println("Enter Library Address -");
		String address = bufferedReader.readLine();
		kwLibraryDetails.setAddress(address);
		System.out.println("Enter Library Owner Name -");
		String ownerName = bufferedReader.readLine();
		kwLibraryDetails.setOwnerName(ownerName);
		
		return Boolean.TRUE.booleanValue();

	}
	/**
	 * This method helps to display library and book association information.
	 * 
	 * @param kwLibraryBookAssociation
	 * 		- Contains map  with bookID and LibraryID information
	 */
	private static void displayLibraryBookAss(
			Map<Long, Set> kwLibraryBookAssociation) {
		//Check Empty and return
		if(kwLibraryBookAssociation.isEmpty()){
			System.out.println("No Book assigned to Library Yet!"+KWConstants.KWLINECHANGE);
			
			return;
		}		
		//Iterate Map
		Iterator<Entry<Long, Set>> itr = kwLibraryBookAssociation.entrySet()
				.iterator();
		//Instantiate FormattedColumns object to print
		KWFormattedColumns formattedColumnsObj = new KWFormattedColumns();
		formattedColumnsObj.addLine(KWConstants.KWLibraryName,KWConstants.KWTITLE,KWConstants.KWAUTHOR,KWConstants.KWPUBLISHER);
		while (itr.hasNext()) {
			Entry<Long, Set> entry = itr.next();
			Long key = entry.getKey();			
			Iterator itrSet = entry.getValue().iterator();
			while (itrSet.hasNext()) {
				Long bookID = (Long) itrSet.next();
				if(kwBookMap.containsKey(bookID)){
					KWBookDetails kwBookDetails = kwBookMap.get(bookID);
					formattedColumnsObj.addLine(kwLibraryMap.get(key).getName(),
							kwBookDetails.getTitle(), kwBookDetails.getAuthor(),
							kwBookDetails.getPublisher());				
				}				
			}
		}
		//Print output
		formattedColumnsObj.print();		
	}
	/**
	 * This method helps to iterate Library Map
	 * 
	 * @param kwLibraryMap
	 * 		- Contains Library details
	 * @return Boolean
	 * 		- Contains true/false once records available then true otherwise false
	 */
	private static Boolean iterateAndDispLibraryMap(Map<Long, KWLibraryDetails> kwLibraryMap){
		
		if(kwLibraryMap.isEmpty()){
			System.out.println("No Library Added Yet!");
			
			return Boolean.FALSE.booleanValue();
		}
		//Iterate Map
		Iterator<Entry<Long, KWLibraryDetails>> itr = kwLibraryMap.entrySet()
		.iterator();
		//Instantiate FormattedColumns object to print
		KWFormattedColumns formattedColumnsObj = new KWFormattedColumns();		
		formattedColumnsObj.addLine(KWConstants.KWLIBRARYID,KWConstants.KWLibraryName);
		while (itr.hasNext()) {
			Entry<Long, KWLibraryDetails> entry = itr.next();
			formattedColumnsObj.addLine(entry.getKey().toString(),entry.getValue().getName());			
		}
		//Print output
		formattedColumnsObj.print();

		return Boolean.TRUE.booleanValue();
	}

	/**
	 * This method helps to validate library ID while adding books. it set 0
	 * once ID not available.
	 * 
	 * @param kwBookDetails
	 * 		- Contains Books details
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	@SuppressWarnings("unchecked")
	private static void validateLibraryID(KWBookDetails kwBookDetails) throws NumberFormatException, IOException{
		//Check library ID available in the map or not
		if(!kwLibraryMap.containsKey(kwBookDetails.getLibraryID())){			
			System.out.println("Entered Library ID not available, Added Default Value as 0!");
			//Iterate Library Map
			if(iterateAndDispLibraryMap(kwLibraryMap)){ 
				//get Input again if library available
				System.out.println("Enter Associated LibraryID -");
				kwBookDetails.setLibraryID(Long.valueOf(bufferedReader.readLine()));
				validateLibraryID(kwBookDetails);
			}else{
				//set 0 once it is not available
				kwBookDetails.setLibraryID(0l);
			}
		}else{
			Set bookIDSet = kwLibraryBookAssociation.get(kwBookDetails.getLibraryID());
			if(bookIDSet == null){
				bookIDSet = new HashSet();
			}
			//Set BookID
			bookIDSet.add(kwBookDetails.getBookID());
			//Add BookID corresponding to its Library ID
			kwLibraryBookAssociation.put(kwBookDetails.getLibraryID(), bookIDSet);
		}
		
	}
	
	/**
	 * This method helps to display all available book.
	 * 
	 * @param kwBookMap
	 * 		- Contains Books information in the map
	 */	
	public static void displayAvailableBookInfo(Map<Long, KWBookDetails> kwBookMap) {
		//Check Map empty
		if(kwBookMap.isEmpty()){
			System.out.println("No Book Added Yet!");		

			return;
		}else{
			//Call method to display book
			kwBookObj.displayAvailableBookInfo(kwBookMap);

		}
	}
	/**
	 * This method helps to display all issued book.
	 * 
	 * @param kwBookMap
	 * 		- Contains Books information in the map
	 */	
	public static void displayIssuedBookInfo(Map<Long, KWBookDetails> kwBookMap) {
		//Check Map empty
		if(kwBookMap.isEmpty()){
			System.out.println("No Book Added Yet!");		

			return;
		}else{
			//Call method to display book
			kwBookObj.displayIssuedBookInfo(kwBookMap);

		}
	}

}
