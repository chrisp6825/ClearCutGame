package com.chrisp6825.clearcut.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.chrisp6825.clearcut.controllers.WorldController;
import com.chrisp6825.clearcut.controllers.inputs.WorldInput;
import com.chrisp6825.clearcut.controllers.inputs.WorldInputKeys;
import com.chrisp6825.clearcut.views.WorldRenderer;

public class PlayScreen implements Screen {
	
	private Game game;
	private WorldRenderer worldRenderer;
	private WorldController worldController;
	private WorldInput worldInput;
	
	public PlayScreen(Game game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        if (WorldInputKeys.isPressed(WorldInputKeys.B)) {
        	worldController.getLogController().startDrop();;
        }
        if (WorldInputKeys.isPressed(WorldInputKeys.A)) {
        	worldController.getLogController().resetLogs();
        }
        if (WorldInputKeys.isPressed(WorldInputKeys.ENTER)) {
        	worldController.getLogController().randomizeLogs();
        }
        if (WorldInputKeys.isPressed(WorldInputKeys.DOWN)) {
        	worldController.getLogController().swingAtLog();
        }
        if (WorldInputKeys.isPressed(WorldInputKeys.UP)) {
        	worldController.getLogController().reviewLogs();
        }

        
        worldController.update(delta);
        worldRenderer.render(delta);
        worldRenderer.renderDegub(delta);
        
        WorldInputKeys.update();
        
	}

	@Override
	public void resize(int width, int height) {
		worldRenderer.resize(width,height);
	}

	@Override
	public void show() {
		worldRenderer = new WorldRenderer(this);
		worldController = new WorldController(this);
		Gdx.input.setInputProcessor(new WorldInput(this));
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		worldController.dispose();
		worldRenderer.dispose();
	}

	public WorldRenderer getWorldRenderer() {
		return worldRenderer;
	}

	public void setWorldRenderer(WorldRenderer worldRenderer) {
		this.worldRenderer = worldRenderer;
	}

	public WorldController getWorldController() {
		return worldController;
	}

	public void setWorldController(WorldController worldController) {
		this.worldController = worldController;
	}

}
