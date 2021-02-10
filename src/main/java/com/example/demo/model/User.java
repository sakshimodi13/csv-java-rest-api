package com.example.demo.model;

import com.opencsv.bean.CsvBindByName;

public class User {
	 	@CsvBindByName
	    private long att1;
	 	@CsvBindByName
	    private long att2;
	 	@CsvBindByName
	    private long att3;
	 	@CsvBindByName
	    private long att4;
	 	
	 	@CsvBindByName
	    private long att5;
	 	@CsvBindByName
	    private long att6;
	 	@CsvBindByName
	    private long att7;
	    @CsvBindByName
	    private String label;
	    @CsvBindByName
	    private float a1;
	    @CsvBindByName
	    private float a2;
	    @CsvBindByName
	    private float a3;
	    @CsvBindByName
	    private float a4;
	    @CsvBindByName
	    private int id;
	    
	    
	    public float getA1() {
			return a1;
		}


		public void setA1(float a1) {
			this.a1 = a1;
		}


		public float getA2() {
			return a2;
		}


		public void setA2(float a2) {
			this.a2 = a2;
		}


		public float getA3() {
			return a3;
		}


		public void setA3(float a3) {
			this.a3 = a3;
		}


		public float getA4() {
			return a4;
		}


		public void setA4(float a4) {
			this.a4 = a4;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public User() {

	    }


		public long getAtt1() {
			return att1;
		}


		public void setAtt1(long att1) {
			this.att1 = att1;
		}


		public long getAtt2() {
			return att2;
		}


		public void setAtt2(long att2) {
			this.att2 = att2;
		}


		public long getAtt3() {
			return att3;
		}


		public void setAtt3(long att3) {
			this.att3 = att3;
		}


		public long getAtt4() {
			return att4;
		}


		public void setAtt4(long att4) {
			this.att4 = att4;
		}


		public long getAtt5() {
			return att5;
		}


		public void setAtt5(long att5) {
			this.att5 = att5;
		}


		public long getAtt6() {
			return att6;
		}


		public void setAtt6(long att6) {
			this.att6 = att6;
		}


		public long getAtt7() {
			return att7;
		}


		public void setAtt7(long att7) {
			this.att7 = att7;
		}


		public String getLabel() {
			return label;
		}


		public void setLabel(String label) {
			this.label = label;
		}


		@Override
		public String toString() {
			return "User [att1=" + att1 + ", att2=" + att2 + ", att3=" + att3 + ", att4=" + att4 + ", att5=" + att5
					+ ", att6=" + att6 + ", att7=" + att7 + ", label=" + label + ", a1=" + a1 + ", a2=" + a2 + ", a3="
					+ a3 + ", a4=" + a4 + ", id=" + id + "]";
		}


		

		
}
