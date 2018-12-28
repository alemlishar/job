package it.techgap.challenge.java.senior;

public class Challenge06Extra {

	/**
	 * Gets the flatten array from nested array Objects
	 * @param String to get reversed
	 * @param position reversing starting point on the string
	 * @return spited and reversed string
	 */
	public static String splitAndReverse(String i, int positions) {

		String frontString = "", endString = "", temp;

		if(i=="")
			return frontString + endString;

		temp = i.substring(positions, i.length());
		endString =i.substring(0, positions);

		for(int x = temp.length()-1; x>=0; x--){ 
			frontString = frontString + temp.charAt(x);     
		}

		return frontString + endString;
	}
}
