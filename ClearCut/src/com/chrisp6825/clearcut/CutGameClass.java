package com.chrisp6825.clearcut;

import com.badlogic.gdx.Game;
import com.chrisp6825.clearcut.screens.PlayScreen;

public class CutGameClass extends Game {
	
	@Override
	public void create() {		
		setScreen(new PlayScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {	
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
