package com.knowledgewala.main;

import com.knowledgewala.book.KWBookImplTest;
import com.knowledgewala.library.KWLibraryImplTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This class helps to run all Junit test cases together.
 * 
 * @author dsahu1
 * 
 */
public class KnowledgeWalaTestSuite extends TestCase{
	
	/**
	 * This method helps to run all test cases together.
	 * @return Test
	 */
	public static Test suite(){
		//Instantiate TestSuite object
		TestSuite testSuite = new TestSuite();
		
		//Added test classes to run
		testSuite.addTestSuite(KWBookImplTest.class);
		testSuite.addTestSuite(KWLibraryImplTest.class);
		
		return testSuite;
	}
}
