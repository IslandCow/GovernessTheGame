package com.kautown.governess;

import jgame.base.JGObject;
import jgame.jre.platform.JGEngine;

public class Notes extends JGObject {
	private boolean direction;
	private JGEngine eng;
	private final double STEP = 2.8;
	
	public Notes (double xPos, double yPos, boolean right, JGEngine en) {
		super("note", true, xPos, yPos, 4, "Notes", 160);
		direction = right;
		eng = en;
	}
	
	public void move() {
		if (direction) {
			x += STEP*gamespeed;
		}
		else {
			x -= STEP*gamespeed;
		}
	}
	
	public void hit() {
		remove();
	}
}
