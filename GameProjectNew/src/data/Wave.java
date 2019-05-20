package data;

import java.util.ArrayList;
import static helpers.Clock.*;

public class Wave {
	
	private float timeSinceLastSpawn, spawnTime;
	private Enemy enemyType;
	private ArrayList<Enemy> enemyList;
	private int enemiesPerWave;
	private boolean waveCompleted;
	private int waveNumber;
	
	public Wave(Enemy enemyType,float spawnTime, int enemiesPerWave) {
		this.enemyType = enemyType;
		this.spawnTime = spawnTime;
		this.enemiesPerWave = enemiesPerWave;
		timeSinceLastSpawn = 0;
		enemyList = new ArrayList<Enemy>();
		Spawn();
		this.waveCompleted = false;
		
	}
	
	public void Update() {
		boolean allEnemiesDead = true;
		if(enemyList.size() < enemiesPerWave) {
			timeSinceLastSpawn += delta();
			if (timeSinceLastSpawn > spawnTime) {
				Spawn();
				timeSinceLastSpawn=0;
			}
		}
		
		for (Enemy e: enemyList) {
			if (e.isAlive()) {
				allEnemiesDead=false;
				e.update();
				e.Draw();
			}
		}
	
		if (allEnemiesDead)
			waveCompleted = true;
	}
	
	private void Spawn() {
	
			
			enemyList.add(new Enemy(enemyType.getTexture(),enemyType.getStartTile(),enemyType.getTileGrid(),64,64, enemyType.getSpeed(),enemyType.getHealth()));
		
	}
	
	public boolean isCompleted() {
		return waveCompleted;
	}
	public ArrayList<Enemy> getEnemyList(){
		return enemyList;
	}

}
