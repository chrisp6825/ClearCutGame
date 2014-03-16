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
	private int difficulty;
	
	private float playerCutMark;
	
	private float gravity = 9.81f;
	private float velocity;
	private float GRAVITYSCALE = 1f;
	
	private Random rand;
	private long waitTime;
	
	public LogController(int numLogs, int difficulty) {
		this.numberLogs = numLogs;
		this.setDifficulty(difficulty);
		logList = new ArrayList<Log>();
		logState = "ready";
		logFallCount = 0;
		rand = new java.util.Random(System.currentTimeMillis()%200);
		for (int i = 0; i < System.currentTimeMillis()%20; i++) {
			rand.nextFloat();
		}
		playerCutMark = 0;
		
		createLogs();
		randomizeLogs();
	}

	public void update(float delta) {
		if (logState.equals("falling")) {
			velocity += gravity * GRAVITYSCALE * delta;
			logFallCount += velocity;
			for (int i = 0; i < numberLogs; i++) {
				logList.get(i).setY(logList.get(i).getY() - velocity);
			}
			if (logFallCount > 800) {
				logState = "goingToReview";
			}
			
		} else if (logState.equals("waiting")) {
			if (System.currentTimeMillis() >= waitTime) {
				dropLogs();
			}
			
		} else if (logState.equals("goingToReview")) {
			for (int i = 0; i < numberLogs; i++) {
				logList.get(i).setY(logList.get(i).getY() + 3);
				if (logList.get(i).getY() >= 35) {
					reviewLogs();
				}
			}
			
		} else if (logState.equals("reviewing") && System.currentTimeMillis() >= waitTime) {
			logState = "leavingReview";
			
		} else if (logState.equals("leavingReview")) {
			for (int i = 0; i < numberLogs; i++) {
				logList.get(i).setY(logList.get(i).getY() - 4);
				if (logList.get(i).getY() <= -300) {
					randomizeLogs();
					resetLogs();
				}
			}
			
		} else if (logState.equals("resetting")) {
			for (int i = 0; i < numberLogs; i++) {
				logList.get(i).setY(logList.get(i).getY() + 3);
				if (logList.get(i).getY() >= 300) {
					startDrop();
				}
			}
		}
	}
	
	private void createLogs() {
		for (int i = 0; i < numberLogs; i++) {
			logList.add(new Log(i));
		}
	}
	
	public void startDrop() {
		waitTime = (Math.abs(rand.nextInt(5)-3)*1000) + System.currentTimeMillis() + 500;
		System.out.println("Log ready, waiting to drop...");
		logState = "waiting";
	}
	
	public void dropLogs() {
		logState = "falling";
		for (int i = 0; i < numberLogs; i++) {
			logList.get(i).setState("falling");
		}
	}
	
	public void resetLogs() {
		logFallCount = 0;
		logState = "resetting";
		velocity = 0;
		for (int i = 0; i < numberLogs; i++) {
			logList.get(i).setState("ready");
			logList.get(i).setCutMark(0);
		}
	}
	
	public void randomizeLogs() {
		float randnum = rand.nextInt(80) + 10;
		for (int i = 0; i < numberLogs; i++) {
			logList.get(i).setTarget((randnum/100)*logList.get(i).getHeight());
		}
	}

	public void swingAtLog(int log) {
		if (log >= numberLogs)
			return;
		
		setPlayerCutMark((.4f * Gdx.graphics.getHeight()) - logList.get(0).getY());
		logList.get(log).setCutMark((.4f * Gdx.graphics.getHeight()) - logList.get(log).getY());
		if (playerCutMark < 0) {
			//player swung too early
			System.out.println("early!");
		} else if (playerCutMark > logList.get(log).getHeight()) {
			// player swung too late
			System.out.println("late!");
		} else {
			// player hit log
			cutLog(log);
			if (Math.abs(playerCutMark - logList.get(log).getTarget()) < this.getDifficulty()) {
				// close enough
				System.out.println("Target hit");
			}
		}
		
		System.out.println("-----------");
		System.out.println("log  " + log + " cut : " + playerCutMark);
		System.out.println("target cut : " + logList.get(log).getTarget());
		System.out.println("-----------");
	}
	
	public void cutLog(int log) {
		System.out.println("log was cut");
		logList.get(log).setState("cut");
		
	}
	
	public void reviewLogs() {
		logFallCount = 0;
		logState = "reviewing";
		velocity = 0;
		waitTime = System.currentTimeMillis() + 3000;
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

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

}
