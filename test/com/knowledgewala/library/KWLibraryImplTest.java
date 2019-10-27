package com.knowledgewala.library;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

/**
 * This class helps to test maintain library functionality.
 * @author dsahu1
 *
 */
public class KWLibraryImplTest extends TestCase{
	
	//Instantiate KWLibrary object to call methods 
	static KWLibrary kwLibraryObj = new KWLibraryImpl();
	//Instantiate Map
	Map<Long, KWLibraryDetails> kwLibraryMap = new HashMap<Long, KWLibraryDetails>();
	
	/**
	 * This method helps to test addition of library.
	 */
	public void testAddLibrary(){
		
		//Instantiate kwLibraryDetails object
		KWLibraryDetails kwLibraryDetails = new KWLibraryDetails();
		//Set library attribute values
		kwLibraryDetails.setName("MyLibrary1");
		kwLibraryDetails.setOwnerName("Dharmendra");
		kwLibraryDetails.setIsActive(Boolean.TRUE.booleanValue());
		kwLibraryDetails.setAddress("521 Lal Baag India");
		kwLibraryDetails.setLibraryID(1l);
		
		//Call method to add library into map
		kwLibraryObj.addLibrary(kwLibraryDetails , kwLibraryMap );
		//Check size of the map as one library added
		assertEquals(1, kwLibraryMap.size());
		//Set attribute values for second library
		kwLibraryDetails.setName("MyLibrary2");
		kwLibraryDetails.setOwnerName("Dharmendra");
		kwLibraryDetails.setIsActive(Boolean.TRUE.booleanValue());
		kwLibraryDetails.setLibraryID(2l);
		kwLibraryDetails.setAddress("521 Lal Baag India");
		//Call method to add library
		kwLibraryObj.addLibrary(kwLibraryDetails , kwLibraryMap );
		//check size of the map
		assertEquals(2, kwLibraryMap.size());
		//check size of the map
		assertNotSame(1, kwLibraryMap.size());
	}
	/**
	 * This method helps to display map attribute.
	 */
	public void testDisplayLibraryInfo(){
		//Call method to add library
		testAddLibrary();
		//Call method to display all library
		kwLibraryObj.displayLibraryInfo(kwLibraryMap);
		//Check assert with size
		assertEquals(2, kwLibraryMap.size());
		//Check assert with name		
		assertTrue(kwLibraryMap.containsKey(1l));
		assertEquals("MyLibrary2", kwLibraryMap.entrySet().iterator().next().getValue().getName());
	}

}
