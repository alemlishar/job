package it.techgap.challenge.java.senior;

import it.techgap.challenge.java.senior.beans.OneSecondWait;
import it.techgap.challenge.java.senior.beans.impl.StringValueCounterImpl;
import it.techgap.challenge.java.senior.beans.impl.TimeBasedKVCacheImpl;
import it.techgap.challenge.java.senior.beans.TimeBasedKVCache;
import it.techgap.challenge.java.senior.beans.ValueCounter;

public class Challenge05BaseDataMethods {
	
	
	/**
	 *
	 * @param waitp     time duration to be waited an 
	 * @param times 	number of time to be executed 
	 * 
	 */
	public static void executeWait(OneSecondWait waitp, int times){

		for(int i = 0 ; i < times; i++) {
			OneSecondWait.waitedSeconds.incrementAndGet();
		}

	}

	/**
	 * @return ValueCounter   counted value of a given string of type ValueCounter
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <V> ValueCounter<V> newValueCounter(){

		StringValueCounterImpl stringValueCounter = new StringValueCounterImpl();
		return (ValueCounter<V>) stringValueCounter;
	}
	
	/**
	 * @return TimeBasedKVCache   instance TimeBasedKVCacheImpl time and cache based storage
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <K,V> TimeBasedKVCache<K,V> newTimeBasedKVCache(){
		TimeBasedKVCacheImpl timeBasedCache = new TimeBasedKVCacheImpl();
		
		return (TimeBasedKVCache<K,V>) timeBasedCache;
		
	}

}
