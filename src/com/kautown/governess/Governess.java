package com.kautown.governess;

import jgame.base.JGColor;
import jgame.base.JGFont;
import jgame.jre.platform.JGEngine;

import com.kautown.governess.Player;

public class Governess extends JGEngine{
	private static final long serialVersionUID = 1L;

	public static void main (String args[]) {
		new Governess(640, 480);
	}
	
	public Governess() {
		initEngineApplet();
	}
	
	public Governess(int x, int y) {
		initEngine(x, y);
	}
	
	@Override
	public void initCanvas() {
		setCanvasSettings(6, 8, 80, 80, JGColor.white, JGColor.black, new JGFont("Plain", JGFont.PLAIN, 10.0));
	}

	@Override
	public void initGame() {
		defineImage("Claire", "#", 0, "Claire/Walk2.png", "");
		setFrameRate(60, 10);
		setGameState("Start");
		new Player("Claire", true, pfWidth()-50, pfHeight()-20, 42, "Claire");
	}
	
	public void doFrameInGame() {
		moveObjects();
	}
}
