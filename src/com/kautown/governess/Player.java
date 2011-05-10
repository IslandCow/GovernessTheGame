package com.kautown.governess;

import jgame.base.JGObject;
import jgame.jre.platform.JGEngine;

public class Player extends jgame.base.JGObject {	
	private final double STEP = 1.5;

	public Player(double xPos, double yPos, JGEngine engine) {
		super("Claire", false, xPos, yPos, 0, "Claire");
		eng = engine;
	}

	private JGEngine eng;
	private boolean goingRight = true;
	private int beats = 0;

	public void move() {
		if (beats == 0 || beats > 20) {
			beats = 0;

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
			else if (eng.getKey(' ')) {
				beats++;
				if (eng.countObjects("note", 0) < 3){
					new Notes(x, y-10, goingRight, eng);
					if (goingRight) {
						setAnim("ThrowR");
					}
					else {
						setAnim("ThrowL");
					}
				}
				eng.clearKey(' ');
			}
			else {
				if(goingRight) {
					setAnim("ClaireSR");
				}
				else {
					setAnim("ClaireSL");
				}
			}
		}
		else {
			beats++;
		}


		return;
	}

	public void hit(JGObject obj) {
		return;
	}
}
