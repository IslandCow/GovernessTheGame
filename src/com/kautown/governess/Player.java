package com.kautown.governess;

import jgame.base.JGObject;
import jgame.jre.platform.JGEngine;

public class Player extends jgame.base.JGObject {	
	public Player(String name, boolean uniqueId, double xPos, double yPos,
			int collisionid, String gfxname) {
		super(name, uniqueId, xPos, yPos, collisionid, gfxname);
	}
	public void move() {
		if (eng.getKey(JGEngine.KeyLeft)  && x > 14)              x -= 14*gamespeed;
		if (eng.getKey(JGEngine.KeyRight) && x < eng.pfWidth()) x += 14*gamespeed;
		return;
	}
	public void hit(JGObject obj) {
		return;
	}
}
