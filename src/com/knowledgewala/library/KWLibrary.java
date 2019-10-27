package com.knowledgewala.library;

import java.util.Map;
/**
 * This class helps to maintain library.
 * 
 * @author dsahu1
 *
 */
public interface KWLibrary {
	/**
	 * This method helps to add library
	 * 
	 * @param kwLibraryDetails
	 * 		- Contains Library details
	 * @param map
	 * 		- Contains libraries information in the map
	 */
	public void addLibrary(KWLibraryDetails kwLibraryDetails,Map<Long, KWLibraryDetails> map);
	/**
	 * This method helps to search library from storage.
	 * 
	 * @param Name
	 * 		- Contains Name of the library
	 * @param map
	 * 		- Contains libraries information in the map
	 */
	public void searchKWLibrary(String Name,Map<Long, KWLibraryDetails> map);
	/**
	 * This method helps to update library information.
	 * 
	 * @param kwLibraryDetails
	 * 		- Contains library details
	 * @param map
	 * 		- Contains libraries information in the map
	 */
	public void updateKwLibrary(KWLibraryDetails kwLibraryDetails,Map<Long, KWLibraryDetails> map);
	/**
	 * This method helps to display library information
	 * 
	 * @param kwLibraryMap
	 * 		- Contains libraries information in the map
	 */
	public void displayLibraryInfo(Map<Long, KWLibraryDetails> kwLibraryMap);

}
