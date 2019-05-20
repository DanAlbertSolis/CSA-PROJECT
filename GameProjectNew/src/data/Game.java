package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.QuickLoad;
import static helpers.Clock.*;


public class Game {
	
	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	public static final int TILE_SIZE = 64;
	
	private float test;
	
	
	public Game(int[][]map) {
		grid = new TileGrid(map);
		waveManager = new WaveManager(new Enemy(QuickLoad("alex"), grid.GetTile(14, 8), grid,64,64,70,25),
				2,2);
		player = new Player(grid, waveManager);
		
		
	}
	
	public void update() {
		
	
		grid.Draw();
		waveManager.update();
		player.Update();

		
		
	}

}
