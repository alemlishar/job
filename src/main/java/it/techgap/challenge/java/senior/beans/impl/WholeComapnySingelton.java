package it.techgap.challenge.java.senior.beans.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WholeComapnySingelton {
	 private static WholeComapnySingelton mInstance;
	 
     private Map<String,Double> salaryCalculatedManager = null;

     public static WholeComapnySingelton getInstance() {
         if(mInstance == null)
             mInstance = new WholeComapnySingelton();

         return mInstance;
     }

     private WholeComapnySingelton() {
    	 salaryCalculatedManager = new HashMap();
     }
  
     public  Map<String,Double> getManagerList() {
      return this.salaryCalculatedManager;
     }
    
     public void addManagerToArray(String name, Double value) {
    	 salaryCalculatedManager.put(name, value);
     }
}
