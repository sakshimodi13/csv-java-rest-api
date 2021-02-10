package com.example.demo.Reader;

import java.util.*;

public class Row {
	 public int getLabel() {
		return label;
	}

	String line = null;
	private final int att1;
	private final int att2;
	private final int att3;
	private final int att4;
	private final int att5;
	private final int att6;
	private final int att7;
	private final int label;
	
	 public Row(String[] values) {
	        this.att1 = Integer.valueOf(values[0]);
	        this.att2 = Integer.valueOf(values[1]);
	        this.att3 = Integer.valueOf(values[2]);
	        this.att4 = Integer.valueOf(values[3]);
	        this.att5 = Integer.valueOf(values[4]);
	        this.att6 = Integer.valueOf(values[5]);
	        this.att7 = Integer.valueOf(values[6]);
	        this.label = Integer.valueOf(values[7]);
	       
	    }	
	 
}

	 