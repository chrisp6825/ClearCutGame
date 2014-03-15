package com.chrisp6825.clearcut.models;

public class Log {
	
	private int index;
	private String state;
	private float target;
	
	private float x, y, width, height;
	
	public Log(int n) {
		this.index = n;
		this.setState("ready");
		this.setTarget(20); // lower is down
		this.setY(300);
		this.setX(90 * (this.index+1));
		this.setWidth(35);
		this.setHeight(250);
		System.out.println("log created : " + n);
	}
	
	// get and set
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public float getTarget() {
		return target;
	}

	public void setTarget(float f) {
		this.target = f;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

}
