package com.chrisp6825.clearcut.models;

public class Log {
	
	private int index;
	private String state;
	private int sliceMark;
	
	public Log(int n) {
		this.index = n;
		this.setState("ready");
		this.setSliceMark(20); // lower is down
		System.out.println("log created : " + n);
	}
	
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}



	public int getSliceMark() {
		return sliceMark;
	}



	public void setSliceMark(int sliceMark) {
		this.sliceMark = sliceMark;
	}

}
