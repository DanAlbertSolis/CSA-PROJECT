package helpers;

import org.lwjgl.Sys;
import static helpers.Clock.*;

public class Clock {

	private static boolean paused = false;
	public static long lastFrame = getTime(), totalTime;
	public static float d = 0, multiplier = 1;
	
	public static long getTime() {
		return Sys.getTime() * 1000 / Sys.getTimerResolution();
	}
	
	public static float getDelta() {
		long currentTime = getTime();
		int delta = (int) (currentTime - lastFrame);
		lastFrame = getTime();
		if (delta * 0.001f > 0.05f) 
			return 0.05f;
		
		return delta * 0.001f;
	}
	
	public static float delta() {
		if (paused)
			return 0;
		else 
			return d * multiplier;
	}
	
	public static float totalTime() {
		return totalTime;
	}
	
	public static float multiplier() {
		return multiplier;
		
	}
	
	public static void update() {
		d = getDelta();
		totalTime += d;
	}
	
	public static void ChangeMultiplier(float change) {
		if (multiplier + change < -1 && multiplier + change > 7) {
			
		} else {
			multiplier += change;
		}
	}
	
	public static void pause() {
		if (paused)
			paused = false;
		else
			paused = true;
	}
}
