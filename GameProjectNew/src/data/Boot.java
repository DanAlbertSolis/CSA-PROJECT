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
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0},
				
		};
		
		TileGrid grid = new TileGrid(map);
		grid.setTile(3, 4, grid.GetTile(10,8).getType());
		Enemy e=new Enemy(QuickLoad("alex"),grid.GetTile(10, 8),grid,64,64,5);
		Wave wave = new Wave(20,e);
		Player player = new Player(grid);
		
		TowerCannon tower = new TowerCannon(QuickLoad("cannonBase"), grid.GetTile(14, 7),10);
		while (!Display.isCloseRequested()) {
			Clock.update();
			
			
			
			
			grid.Draw();
			wave.Update();
			player.Update();
			tower.update();
			
			
			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
	}
	
	public static void main(String[] args) {
		new Boot();
	}

}
