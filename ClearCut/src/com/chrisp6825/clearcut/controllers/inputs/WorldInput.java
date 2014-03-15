package com.chrisp6825.clearcut.controllers.inputs;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.chrisp6825.clearcut.screens.PlayScreen;

public class WorldInput extends InputAdapter{

	public WorldInput(PlayScreen playScreen) {
		// TODO Auto-generated constructor stub
	}

	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean keyDown(int k) {
		if(k == Keys.UP) WorldInputKeys.setKey(WorldInputKeys.UP, true);
		if(k == Keys.RIGHT) WorldInputKeys.setKey(WorldInputKeys.RIGHT, true);
		if(k == Keys.DOWN) WorldInputKeys.setKey(WorldInputKeys.DOWN, true);
		if(k == Keys.LEFT) WorldInputKeys.setKey(WorldInputKeys.LEFT, true);
		if(k == Keys.ESCAPE) WorldInputKeys.setKey(WorldInputKeys.ESCAPE, true);
		if(k == Keys.ENTER) WorldInputKeys.setKey(WorldInputKeys.ENTER, true);
		if(k == Keys.A) WorldInputKeys.setKey(WorldInputKeys.A, true);
		if(k == Keys.B) WorldInputKeys.setKey(WorldInputKeys.B, true);
		if(k == Keys.M) WorldInputKeys.setKey(WorldInputKeys.M, true);
		return true;
	}
	
	public boolean keyUp(int k) {
		if(k == Keys.UP) WorldInputKeys.setKey(WorldInputKeys.UP, false);
		if(k == Keys.RIGHT) WorldInputKeys.setKey(WorldInputKeys.RIGHT, false);
		if(k == Keys.DOWN) WorldInputKeys.setKey(WorldInputKeys.DOWN, false);
		if(k == Keys.LEFT) WorldInputKeys.setKey(WorldInputKeys.LEFT, false);
		if(k == Keys.ESCAPE) WorldInputKeys.setKey(WorldInputKeys.ESCAPE, false);
		if(k == Keys.ENTER) WorldInputKeys.setKey(WorldInputKeys.ENTER, false);
		if(k == Keys.A) WorldInputKeys.setKey(WorldInputKeys.A, false);
		if(k == Keys.B) WorldInputKeys.setKey(WorldInputKeys.B, false);
		if(k == Keys.M) WorldInputKeys.setKey(WorldInputKeys.M, false);
		return true;
	}



}
