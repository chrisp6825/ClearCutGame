package com.chrisp6825.clearcut.controllers;

import com.chrisp6825.clearcut.screens.PlayScreen;

public class WorldController {
	
	private LogController logController;
	
	public WorldController(PlayScreen playScreen) {
		setLogController(new LogController(1,10));
	}
	
	public void dispose() {
		
	}

	public void update(float delta) {
		logController.update(delta);
	}

	public LogController getLogController() {
		return logController;
	}

	public void setLogController(LogController logController) {
		this.logController = logController;
	}

}
