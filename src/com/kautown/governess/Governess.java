package com.kautown.governess;

import jgame.base.JGColor;
import jgame.base.JGFont;
import jgame.jre.platform.JGEngine;

import com.kautown.governess.Player;

public class Governess extends JGEngine{
	private static final long serialVersionUID = 1L;

	public static void main (String args[]) {
		new Governess(800, 600);
	}
	
	public Governess() {
		initEngineApplet();
	}
	
	public Governess(int x, int y) {
		initEngine(x, y);
		setGameSpeed(1.0);
	}
	
	@Override
	public void initCanvas() {
		setCanvasSettings(20, 15, 32, 32, JGColor.white, JGColor.blue, new JGFont("Plain", JGFont.PLAIN, 10.0));
	}

	@Override
	public void initGame() {
		defineImage("CW1R", "p", 0, "Claire/Walk1.png", "");
		defineImage("CW2R", "p", 0, "Claire/Walk2.png", "");
		defineImage("CW3R", "p", 0, "Claire/Walk3.png", "");
		
		defineImage("TR", "p", 0, "Claire/Throw.png", "");
		defineImage("TL", "p", 0, "Claire/Throw.png", "x");
		
		defineImage("CW1L", "p", 0, "Claire/Walk1.png", "x");
		defineImage("CW2L", "p", 0, "Claire/Walk2.png", "x");
		defineImage("CW3L", "p", 0, "Claire/Walk3.png", "x");
		
		defineImage("Notes", "p", 0, "Other/Charm.png", "");
		
		defineAnimation("ClaireR",new String[]{"CW1R", "CW2R", "CW3R", "CW2R"}, 0.2);
		defineAnimation("ClaireSR",new String[]{"CW2R"}, 0.2);
		defineAnimation("ClaireSL",new String[]{"CW2R"}, 0.2);
		defineAnimation("ThrowR", new String[] {"TR"}, 0.5);
		defineAnimation("ThrowL", new String[] {"TL"}, 0.5);
		defineAnimation("ClaireL",new String[]{"CW1L", "CW2L", "CW3L", "CW2L"}, 0.2);
		
		setFrameRate(40, 10);
		setGameState("InGame");
		new Player(80, 400, this);
		//new Notes(80, 380, true, this);
	}
	
	public void doFrameInGame() {
		moveObjects();
	}
}

