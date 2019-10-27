package com.knowledgewala.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;  
/**
 * This method helps to display output in formatted string.
 * 
 * @author dsahu1
 *
 */
public class KWFormattedColumns {

    List<List<String>> lines = new ArrayList<List<String>>();
    List<Integer> maxLengths = new ArrayList<Integer>();
    int numColumns = -1;

    public KWFormattedColumns addLine(String... line) {

        if (numColumns == -1){
            numColumns = line.length;
            for(int i = 0; i < numColumns; i++) {
                maxLengths.add(0);
            }
        }

        if (numColumns != line.length) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < numColumns; i++) {
            maxLengths.set(  i, Math.max( maxLengths.get(i), line[i].length() )  );
        }

        lines.add( Arrays.asList(line) );

        return this;
    }
	/**
	 * This method helps to print output.
	 */
    public void print(){
        System.out.println( toString() );
    }

    public String toString(){
        String result = KWConstants.KWBLANKSTRING;
        for(List<String> line : lines) {
            for(int i = 0; i < numColumns; i++) {
                result += pad( line.get(i), maxLengths.get(i) + 1 );                
            }
            result += KWConstants.KWLINECHANGE;
        }
        return result;
    }

    private String pad(String word, int newLength){
        while (word.length() < newLength) {
            word += KWConstants.KWSPACESTRING;            
        }       
        return word;
    }
}