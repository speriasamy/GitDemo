package com.knowledgewala.library;

import java.util.Map;
import java.util.Map.Entry;

import com.knowledgewala.common.KWConstants;
/**
 * This class helps to maintain library.
 * 
 * @author dsahu1
 *
 */
public class KWLibraryImpl implements KWLibrary{

	

	@Override
	public void displayLibraryInfo(Map<Long, KWLibraryDetails> kwLibraryMap) {
		
		java.util.Iterator<Entry<Long, KWLibraryDetails>> itr = kwLibraryMap.entrySet().iterator();
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("******* Library Information *******").append(KWConstants.KWLINECHANGE);
		while(itr.hasNext()){
			Entry<Long, KWLibraryDetails> entry = itr.next();
			KWLibraryDetails kwLibraryDetails = entry.getValue();			
			stringBuilder.append(entry.getKey()).append(KWConstants.KWTABSPACE).append(kwLibraryDetails.getName()).append(KWConstants.KWTABSPACE).append(kwLibraryDetails.getAddress()).append(KWConstants.KWLINECHANGE);
		}
		System.out.println(stringBuilder);
	}
	/**
	 * This method helps to add library
	 * 
	 * @param kwLibraryDetails
	 * 		- Contains Library details
	 * @param map
	 * 		- Contains libraries information in the map
	 */
	@Override
	public void addLibrary(KWLibraryDetails kwLibraryDetails,
			Map<Long, KWLibraryDetails> map) {
		
		map.put(kwLibraryDetails.getLibraryID(), kwLibraryDetails);
		
		//return Boolean.TRUE.booleanValue();
		
	}
	/**
	 * This method helps to search library from storage.
	 * 
	 * @param Name
	 * 		- Contains Name of the library
	 * @param map
	 * 		- Contains libraries information in the map
	 */
	@Override
	public void searchKWLibrary(String Name, Map<Long, KWLibraryDetails> map) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * This method helps to update library information.
	 * 
	 * @param kwLibraryDetails
	 * 		- Contains library details
	 * @param map
	 * 		- Contains libraries information in the map
	 */
	@Override
	public void updateKwLibrary(KWLibraryDetails kwLibraryDetails,
			Map<Long, KWLibraryDetails> map) {
		// TODO Auto-generated method stub
		
	}	

}
