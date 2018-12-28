package it.techgap.challenge.java.senior.beans.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.techgap.challenge.java.senior.beans.ValueCounter;

public class StringValueCounterImpl implements ValueCounter<String> {

	private List<String> stringCounter  = new ArrayList<String>();
	
	@Override
	public void addValue(String value) {
		// TODO Auto-generated method stub
		stringCounter.add(value);
		
	}

	@Override
	public int howMany(String value) {
		// TODO Auto-generated method stub
		return Collections.frequency(stringCounter, value);
	}

}
