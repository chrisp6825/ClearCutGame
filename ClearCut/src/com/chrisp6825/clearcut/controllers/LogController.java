package com.chrisp6825.clearcut.controllers;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.chrisp6825.clearcut.models.Log;


public class LogController {
	
	private int numberLogs;
	private ArrayList<Log> logList;
	private String logState;
	private float logFallCount;
	
	private float playerCutMark;
	
	private float gravity = 9.81f;
	private float velocity;
	private float GRAVITYSCALE = 1f;
	
	private Random rand;
	
	public LogController(int numLogs) {
		this.numberLogs = numLogs;
		logList = new ArrayList<Log>();
		logState = "ready";
		logFallCount = 0;
		rand = new java.util.Random(42);
		playerCutMark = 0;
		
		createLogs();
	}

	public void update(float delta) {
		if (logState.equals("falling") && logFallCount < 620) {
			velocity += gravity * GRAVITYSCALE * delta;
			logFallCount += velocity;
			for (int i = 0; i < numberLogs; i++) {
				logList.get(i).setState(logState);
				logList.get(i).setY(logList.get(i).getY() - velocity);
			}
		}
	}
	
	private void createLogs() {
		for (int i = 0; i < numberLogs; i++) {
			logList.add(new Log(i));
		}
	}
	
	public void dropLogs() {
		logState = "falling";
		for (int i = 0; i < numberLogs; i++) {
			logList.get(i).setState("falling");
		}
	}
	
	public void resetLogs() {
		logFallCount = 0;
		logState = "ready";
		velocity = 0;
		for (int i = 0; i < numberLogs; i++) {
			logList.get(i).setState("ready");
			logList.get(i).setY(300);
		}
	}
	
	public void randomizeLogs(int dif) {
		float randnum = rand.nextFloat();
		for (int i = 0; i < numberLogs; i++) {
			logList.get(i).setTarget(randnum*logList.get(i).getHeight());
		}
	}

	public void cutLog() {
		setPlayerCutMark((.4f * Gdx.graphics.getHeight()) - logList.get(0).getY());
		// if playercutmark < 0 then player cut before log
		// if playercutmark > Log.height then player cut after log
		// if playercutmark == targetcut then player hit the mark
		logState = "cut";
		for (int i = 0; i < numberLogs; i++) {
			logList.get(i).setState("cut");
		}
		
		System.out.println("-----------");
		System.out.println("player cut : " + playerCutMark);
		System.out.println("target cut : " + logList.get(0).getTarget());
		System.out.println("-----------");
	}
	
	// get and set

	public ArrayList<Log> getLogList() {
		return logList;
	}

	public void setLogList(ArrayList<Log> logList) {
		this.logList = logList;
	}

	public String getState() {
		return logState;
	}

	public float getLogFallCount() {
		return logFallCount;
	}

	public void setLogFallCount(float logFallCount) {
		this.logFallCount = logFallCount;
	}

	public float getPlayerCutMark() {
		return playerCutMark;
	}

	public void setPlayerCutMark(float playerCutMark) {
		this.playerCutMark = playerCutMark;
	}

}
