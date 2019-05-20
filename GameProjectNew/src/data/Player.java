package data;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import helpers.Clock;

import static helpers.Artist.*;

import java.util.ArrayList;
public class Player {

	private TileGrid grid;
	private TileType[] types;
	private int index;
	private WaveManager waveManager;
	private ArrayList<TowerCannon> towerList;
	private boolean leftMouseButtonDown;
	private boolean firstTower = true;
	
	public Player(TileGrid grid, WaveManager waveManager) {
		this.grid=grid;
		this.types = new TileType[3];
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Dirt;
		this.types[2] = TileType.Water;
		this.index = 0;
		this.waveManager = waveManager;
		this.towerList = new ArrayList<TowerCannon>();
		this.leftMouseButtonDown = false;
		
	}
	
	public void updateEnemyLists(ArrayList<Enemy> newList) {
		for (TowerCannon t: towerList)
				t.updateEnemyList(waveManager.getCurrentWave().getEnemyList());
			
	}
	
	public void SetTile() {
		grid.setTile((int)Math.floor(Mouse.getX() / 64),(int) Math.floor((HEIGHT - Mouse.getY() - 1) / 64), types[index]);
	}
	
	//Mouse Input
	public void Update() {
		for (TowerCannon t: towerList) {
			t.update();
			t.updateEnemyList(waveManager.getCurrentWave().getEnemyList());
		}
		
		
		if (Mouse.isButtonDown(0)&&!leftMouseButtonDown) {
			if (firstTower==false) {
				Enemy.points -= 3;
				
			}
			towerList.add(new TowerCannon(QuickLoad("cannonBase"), grid.GetTile(Mouse.getX() / 64, (HEIGHT - Mouse.getY() - 1) / 64),10,1000,waveManager.getCurrentWave().getEnemyList()));
			firstTower = false;
			
			
			//SetTile();
		}
		
		leftMouseButtonDown = Mouse.isButtonDown(0);
		//Handle Keyboard 
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				Clock.ChangeMultiplier(0.2f);
				
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()) {
				Clock.ChangeMultiplier(-0.2f);
				
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_T && Keyboard.getEventKeyState()) {
				towerList.add(new TowerCannon(QuickLoad("cannonBase"), grid.GetTile(18, 9),10,1000,waveManager.getCurrentWave().getEnemyList()));
			}
		}
	}
	
	private void moveIndex() {
		index++;
		if (index > types.length - 1) {
			index=0;
		}
	}
}

