package data;



import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;


import helpers.Clock;

import static org.lwjgl.opengl.GL11.*;

import static helpers.Artist.*;
public class Boot {
	
	public static final int WIDTH = 1280, HEIGHT = 960;
	
	public Boot() {
		BeginSession();
		
		int [][] map = {
				{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2},
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				
		};
		
		Game game = new Game(map);
		while (!Display.isCloseRequested()) {
			Clock.update();
			
			game.update();
			System.out.println("Points: "+Enemy.points);
			if(Enemy.points >= 10) {
				Display.destroy();
				System.out.print("GAME OVER - YOU WIN");
			}
			if (Enemy.points < 0) {
				Display.destroy();
				System.out.print("GAME OVER - YOU LOSE");
			}
			
			
			
			
			
			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
	}
	
	public static void main(String[] args) {
		new Boot();
	}

}
