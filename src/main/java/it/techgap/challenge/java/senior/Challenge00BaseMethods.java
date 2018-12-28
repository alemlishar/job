package it.techgap.challenge.java.senior;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Challenge00BaseMethods {
	
	static String regexNumber = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";
	
	
	public static int round(double d) {

		return (int) Math.round(d);
	
	}

	/**
	 *Get rounding of String 
	 * @param d    a string 
	 * return int round of the string
	 */
	public static int round(String d) {

		double valueDoubble = Double.parseDouble(d);
		
		return (int) Math.round(valueDoubble);
	}

	/**
	 *Get needed bit for the  number
	 * @param i    a number 
	 * return bitCounter 	number of bit needed for representing the number 
	 */
	public static int bitNeeded(int i) {
		
		int value = i;
		int bitCounter = 0;
		
		while (value > 0) {
			bitCounter++;
		    value = value >> 1;
		}
		
		return bitCounter;
	}

	/**
	 *Check the equality of number with its reverse
	 * @param num    a number 
	 * return boolean 	check whether its reverse of the number equals with the number 
	 */
	public static boolean palindromic(int num){

		int sumNumber=0, reverseNumber;
		int temp = num;
		
		while(temp>0){    
			reverseNumber=temp%10;  
			sumNumber=(sumNumber*10)+reverseNumber;    
			temp=temp/10;    
		}    
		
		if(num == sumNumber){
			return true;
		}
		
		return false;

	}

	
	public static int hex(String i){
		
		return  (int) Long.parseLong(i, 16);
	
	}
	
	/**
	 * Swapped letter x with y and letter y with x
	 * @param i    a string
	 * return String 	value of x and y replaced String
	 */
	public static String swapXY(String i){

		String swapped= "";
		for (int j = 0; j < i.length(); j++){

			if(i.charAt(j) == 'x' || i.charAt(j) == 'X')
				swapped = swapped + "y";
			else if(i.charAt(j) == 'y' || i.charAt(j) == 'Y')
				swapped = swapped + "x";
			else 
				swapped = swapped + i.charAt(j);
		}

		return swapped;
	}

	/**
	 * Get the numbers from the a String
	 * @param i    a number
	 * return Number[] 	numbers from the string 
	 */		
	public static Number[] findNumbers(String i){
		
		List<Float> num = new ArrayList<Float>();
		Pattern p = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?");
		Matcher m = p.matcher(i);
	
		while(m.find()) {

				try {
					float number = (Integer) NumberFormat.getInstance().parse(m.group());
					num.add(number);
				} catch (ParseException e) {
					
					e.printStackTrace();
				}

		}
		
		Number[] targetArray = num.toArray(new Number[num.size()]);
		
		return targetArray;
	}
		
		
}
