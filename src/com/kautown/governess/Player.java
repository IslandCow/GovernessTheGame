package com.kautown.governess;

import jgame.base.JGObject;
import jgame.jre.platform.JGEngine;

public class Player extends jgame.base.JGObject {	
	private final double STEP = 1.5;
	
	public Player(String name, boolean uniqueId, double xPos, double yPos,
			int collisionid, String gfxname, JGEngine engine) {
		super("Claire", false, xPos, yPos, 0, "Claire");
		eng = engine;
	}
	
	private JGEngine eng;
	private boolean goingRight = true;
	
	public void move() {
		if (eng.getKey(JGEngine.KeyLeft)) {
			x -= STEP*gamespeed;
			setAnim("ClaireL");
			goingRight = false;
		}
		else if (eng.getKey(JGEngine.KeyRight)) {
			x += STEP*gamespeed;
			setAnim("ClaireR");
			goingRight = true;
		}
		else {
			if(goingRight) {
				setAnim("ClaireSR");
			}
			else {
				setAnim("ClaireSL");
			}
		}
		return;
	}
	
	public void hit(JGObject obj) {
		return;
	}
}
