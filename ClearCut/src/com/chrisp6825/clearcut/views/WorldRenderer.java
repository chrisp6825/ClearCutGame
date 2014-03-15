package com.chrisp6825.clearcut.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.chrisp6825.clearcut.models.Log;
import com.chrisp6825.clearcut.screens.PlayScreen;

public class WorldRenderer {
	
	private PlayScreen playScreen;
	
	private ShapeRenderer sr;
	private OrthographicCamera camera;
	
	public WorldRenderer(PlayScreen playScreen) {
		this.playScreen = playScreen;
		sr = new ShapeRenderer();
		camera = new OrthographicCamera();
	}
	
	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
		camera.position.x = width/2;
		camera.position.y = height/2;
		camera.update();
	}
	
	public void render(float delta) {
		
	}
	
	public void renderDegub(float delta) {
		sr.setProjectionMatrix(camera.combined);
		
		sr.begin(ShapeType.Filled);
		
		// players cut line
		sr.setColor(Color.BLUE);
		sr.rect(0,.40f*Gdx.graphics.getHeight(),Gdx.graphics.getWidth(),1);
		
		// draw logs
		for (Log log : playScreen.getWorldController().getLogController().getLogList()) {
			sr.setColor(Color.BLACK);
			sr.rect(log.getX(), log.getY(), log.getWidth(), log.getHeight());
			sr.setColor(Color.WHITE);
			sr.rect(log.getX() - 5, log.getY() + log.getTarget(), log.getWidth() + 10, 3);
		}
		
		sr.end();
	}

	public void dispose() {
		sr.dispose();
	}

}
