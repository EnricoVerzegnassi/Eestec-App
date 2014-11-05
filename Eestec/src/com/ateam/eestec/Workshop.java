package com.ateam.eestec;

public class Workshop {


	/**
	 * Item Id
	 */
	@com.google.gson.annotations.SerializedName("id")
	private String mId;
	
	@com.google.gson.annotations.SerializedName("data")
	private String mdata;
	

	@com.google.gson.annotations.SerializedName("task")
	private String mtask;

	@com.google.gson.annotations.SerializedName("loc_x")
	private long mloc_x;
	 
	@com.google.gson.annotations.SerializedName("loc_y")
	private long mloc_y;
	
	@com.google.gson.annotations.SerializedName("deskription")
	private String mdescription;
	 
}
