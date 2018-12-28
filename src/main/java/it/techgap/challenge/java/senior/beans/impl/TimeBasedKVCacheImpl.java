package it.techgap.challenge.java.senior.beans.impl;

import static it.techgap.challenge.java.senior.Challenge05BaseDataMethods.newTimeBasedKVCache;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import it.techgap.challenge.java.senior.beans.TimeBasedKVCache;

public class TimeBasedKVCacheImpl implements TimeBasedKVCache<String, Integer> {
	
	
	Map<String, Integer> cacheData = new LinkedHashMap<String, Integer>();
	int limit;
	
	@Override
	public void setMaximumElements(int elements) {
		// TODO Auto-generated method stub

		limit = elements;
	}

	@Override
	public void setElementsTimeToLive(long duration, TimeUnit timeunit) {
		// TODO timeunit not needed default timer counted in milisecond
		
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		                cacheData.clear();
		                System.out.println("executed" + cacheData.size());
		            }
		        }, 
		        duration 
		);
		
	}

	@Override
	public Integer getValue(String key) {
		// TODO Auto-generated method stub
	
		return cacheData.get(key);
	}

	@Override
	public void addValue(String key, Integer value) {
		// TODO Auto-generated method stub
		
		if(cacheData.containsKey(key)) {

			 cacheData.put(key, value);

		}else if(cacheData.size() == limit) {
			 removeEldest();
			 cacheData.put(key, value);
		}
		else {
			cacheData.put(key, value);
			
		}
		 
	}
	
	
	private void removeEldest() {
        Iterator <String> iterator =cacheData.keySet().iterator();
        if (iterator.hasNext()){
        	cacheData.remove(iterator.next());
        }
    }

}
