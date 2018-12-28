package it.techgap.challenge.java.senior;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.log4j.Logger;


import it.techgap.challenge.java.senior.beans.impl.SqlQueries;

/**
 * This test uses an in-memory <a href="http://www.h2database.com/">H2 database</a>
 */
public class Challenge04SSQL {

	static Logger log = Logger.getLogger(Challenge04SSQL.class.getName());
	   

//	static String sqlQuery1 = "SELECT subordinate.cf AS cf " +
//			"FROM subordinate " +
//			"LEFT JOIN employee ON employee.cf = subordinate.manager_cf " +
//			"WHERE employee.SALARY > ?";
//	
//	static String sqlQuery2 = "SELECT subordinate.manager_cf AS manager_cf, COUNT(manager_cf) AS counter " +
//			"FROM subordinate " +
//			"LEFT JOIN employee ON employee.cf = subordinate.manager_cf " +
//			"GROUP BY subordinate.manager_cf";

	public static class  ManagerWithCount {

		
		String cf;
		long count;
		

		public  ManagerWithCount(String cf, long count) {
		
			this.cf = cf;
			this.count = count;
			
			
		}

		public ManagerWithCount() {
		
		}

		public String getCf() {
			return cf;
		}

		public void setCf(String cf) {
			this.cf = cf;
		}

		public long getCount() {
			return count;
		}

		public void setCount(long count) {
			this.count = count;
		}
		public void listed() {
			
			
		}
		
		@Override
		public boolean equals(Object obj) {
		    if (obj == null) return false;
		    if (!(obj instanceof ManagerWithCount))
		        return false;
		    if (obj == this)
		        return true;
		    return this.getCount() == ((ManagerWithCount) obj).getCount();
		}

	}

	/**
	 * Gets the CF of all employees aged more than minAge
	 *
	 * @param connection A JDBC Connection
	 * @param minAge     Minimum age to consider
	 * @return A set of employees's CF
	 * @throws SQLException If anything goes wrong
	 * @throws ClassNotFoundException 
	 */
	public static Collection<String> selectCFOfEmployeesAgedMoreThan(Connection connection, int minAge) throws SQLException {

		List<String> employeResult= new ArrayList<String>();


		PreparedStatement ps = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE " + "AGE > ? ");
		PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM SUBORDINATE WHERE " + "AGE > ? ");

		ps.setInt(1, minAge);
		ps1.setInt(1, minAge);
		
		ResultSet rs1 = ps1.executeQuery(); 
		while(rs1.next()) { 
			employeResult.add(rs1.getString("CF"));
		}
		ResultSet rs = ps.executeQuery(); 
		while(rs.next()) { 
			employeResult.add(rs.getString("CF"));
		}

		return employeResult;
	}
	
	

	/**
	 * Gets the CF of all employees whose manager has a salary of more than minSalary euros
	 *
	 * @param connection A JDBC Connection
	 * @param minSalary  Minimum salary to consider
	 * @return A set of employees' CF
	 * @throws SQLException If anything goes wrong
	 */
	public static Collection<String> selectCFOfEmployeesWhoseManagerHasASalaryofMoreThan(Connection connection, int minSalary) throws SQLException {


		List<String> selectedRows= new ArrayList<String>();
		PreparedStatement ps1 = connection.prepareStatement(SqlQueries.sqlQuery1);

		ps1.setInt(1, minSalary);
		
		ResultSet rs1 = ps1.executeQuery(); 
		log.debug("Hello this is a debug message");
	      log.info("Hello this is an info message");
		while(rs1.next()) { 
			selectedRows.add(rs1.getString("cf"));
		}

		return selectedRows;
	}
	
	

	/**
	 * Retrieves all the managers with their respective subordinates count if and only if the manager has more than
	 * minSubordinates subordinates
	 *
	 * @param connection      A JDBC Connection
	 * @param minSubordinates Minimum number of subordinates to consider
	 * @return A well-built collection of {@link ManagerWithCount}
	 * @throws SQLException If anything goes wrong
	 */
	public static Collection<Challenge04SSQL.ManagerWithCount> getManagersWithMoreThanXSubordinates(Connection connection,int minSubordinates) throws SQLException {
		
		Collection<Challenge04SSQL.ManagerWithCount> mangerCount = new ArrayList<Challenge04SSQL.ManagerWithCount>();
		PreparedStatement ps = connection.prepareStatement(SqlQueries.sqlQuery2);
		
		ResultSet rs = ps.executeQuery(); 
		while(rs.next()) { 
				
			if(rs.getInt("counter") > minSubordinates) {
				mangerCount.add(new Challenge04SSQL.ManagerWithCount(rs.getString("manager_cf"),rs.getLong("counter")));
			}
		}
	
		return mangerCount;
	}

}
