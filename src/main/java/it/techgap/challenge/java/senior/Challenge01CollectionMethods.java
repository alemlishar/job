package it.techgap.challenge.java.senior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Challenge01CollectionMethods {

	/**
	 * @param in  integer array 
	 * return int maximum number from the array integer
	 */
	public static int max(int[] in){

		int max = Arrays.stream(in)
				.max()
				.getAsInt();

		return max;
	}


	/**
	 * @param in  integer array 
	 * return int minimum number from the array integer
	 */
	public static int min(int[] in){

		int min = Arrays.stream(in)
				.min()
				.getAsInt();

		return min;
	}


	/**
	 * @param in  integer array 
	 * return int sorted array ascending
	 */
	public static int[] sortIt(int[] in){

		int [] sortedArray = in;
		Arrays.sort(sortedArray);

		return  sortedArray; 
	}


	/**
	 * @param in  boolean array 
	 * return Boolean sorted array boolean
	 */
	public static Boolean[] sortIt(Boolean[] in){

		Boolean [] sortedArray 	= new Boolean[in.length];
		int boleant=0,boleanf=0;

		for (Boolean boolean1 : in) {
			if(boolean1) {
				sortedArray[boleant] = true;
				boleant= boleant+1;
			}
			else
				boleanf= boleanf+1;
		}

		for(int i=boleant; i < in.length; i++ ) {
			sortedArray[i] = false;
		}

		return sortedArray ;
	}

	/**
	 * @param in  number array 
	 * return Boolean negative numbers removed  array 
	 */
	public static int[] removeNegative(int[] in){

		List<Integer> postiveNumber = new ArrayList<>();
		for (int j : in) {
			if(j>=0)
				postiveNumber.add(j);
		}
		Collections.sort(postiveNumber);
		int[] arrayPostiveNumber = postiveNumber.stream().distinct().mapToInt(i->i).toArray();


		return arrayPostiveNumber;
	}


	/**
	 * @param in  String array
	 * @param e  String  
	 * return int occurrence of string from the sstring array
	 */
	public static int count(String[] in, String e){

		int counter = 0;
		for (String string : in) {
			if(e.equals(string)) {
				counter ++; 
			}
		}

		return counter;
	}
	
	
	/**
	 * @param in  string array 
	 * return int maximum  repetition of character from the string
	 */
	public static int maxRepetitions(String[] in){


		List<String> lintall = new ArrayList<String>();
		lintall = new ArrayList( Arrays.asList( in ) );	
		int  maxRepetition  = 0;

		for (String d : lintall) {
			int count = Collections.frequency(lintall, d);
			if(count > maxRepetition)
				maxRepetition = count;
		}

		return maxRepetition;
	}


	/**
	 * @param in   integer array 
	 * return int  sorted and merged array
	 */
	public static int[] mergeAndSort(int[]... in){

		List<Integer> mergedList = new ArrayList<>();

		for (int[] singleArray : in) {
			List<Integer> lint = Arrays.stream(singleArray)
					.boxed()  		
					.collect(Collectors.toList());
			mergedList.addAll(lint);
		}
		
		Collections.sort(mergedList);
		int[] flatenArray = mergedList.stream().distinct().mapToInt(i->i).toArray();

		return flatenArray;

	}

}
