package com.chrisp6825.clearcut.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
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
		
		float logFallCount = playScreen.getWorldController().getLogController().getLogFallCount();
		float sliceMark = playScreen.getWorldController().getLogController().getLogList().get(0).getSliceMark();
		
		sr.begin(ShapeType.Filled);
		sr.setColor(Color.BLACK);
		
		// players cut line
		sr.rect(0,.40f*Gdx.graphics.getHeight(),Gdx.graphics.getWidth(),3);
		
		sr.rect(100, (float) (300 - logFallCount), 35, 316);
		sr.setColor(Color.RED);
		sr.rect(75, (float) (300 - logFallCount)+sliceMark, 75, 2);
		sr.end();
	}

	public void dispose() {
		sr.dispose();
	}

}
