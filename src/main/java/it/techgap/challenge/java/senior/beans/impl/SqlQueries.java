package it.techgap.challenge.java.senior.beans.impl;

public class SqlQueries {
	
	
	public static String regexNumber = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";
	public static String sqlQuery1 = "SELECT subordinate.cf AS cf " +
			"FROM subordinate " +
			"LEFT JOIN employee ON employee.cf = subordinate.manager_cf " +
			"WHERE employee.SALARY > ?";
	
	public static String sqlQuery2 = "SELECT subordinate.manager_cf AS manager_cf, COUNT(manager_cf) AS counter " +
			"FROM subordinate " +
			"LEFT JOIN employee ON employee.cf = subordinate.manager_cf " +
			"GROUP BY subordinate.manager_cf";


}
