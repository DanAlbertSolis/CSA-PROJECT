package data;

public class WaveManager {

		private float timeSinceLastWave, timeBetweenEnemies;
		private static int waveNumber, enemiesPerWave;
		private Enemy enemyType;
		private Wave currentWave;
		
		public WaveManager(Enemy enemyType,float timeBetweenEnemies, int enemiesPerWave) {
			this.enemyType = enemyType;
			this.timeBetweenEnemies = timeBetweenEnemies;
			this.enemiesPerWave = enemiesPerWave;
			this.timeSinceLastWave = 0;
			this.waveNumber = 0;
			
			this.currentWave = null;
			
			newWave();
		}
		
		
		public void update() {
			if (!currentWave.isCompleted())
				currentWave.Update();
			else
				newWave();
		}
		
		private void newWave() {
			currentWave = new Wave(enemyType, timeBetweenEnemies, enemiesPerWave);
			waveNumber++;
			System.out.println("Wave " + waveNumber);
		}
		public Wave getCurrentWave() {
			return currentWave;
		}
		public static int getWaveNumber() {
			return waveNumber;
		}
}
