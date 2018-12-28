package it.techgap.challenge.java.senior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Challenge07ArrayFlattener {

	/**
	 * Gets the flatten array from nested array Objects
	 * @param nested Array
	 * @return single flatten array
	 * @throws IllegalArgumentException If anything goes wrong
	 */
	public static Integer[] flatten(Object[] inputArray) throws IllegalArgumentException {

		List<Integer> flatList = new ArrayList<Integer>();

		if (inputArray == null) return null;
		for (Object element : inputArray) {
			if (element instanceof Integer) {
				flatList.add((Integer) element);
			} else if (element instanceof Object[]) {
				flatList.addAll(Arrays.asList(flatten((Object[]) element)));
			} else {
				throw new IllegalArgumentException("Input must be an array of Integers or nested arrays of Integers");
			}
		}

		return flatList.toArray(new Integer[flatList.size()]);
	}

}
