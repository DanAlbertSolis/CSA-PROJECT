package data;

import static helpers.Artist.drawQuadTex;
import static helpers.Artist.*;
import static helpers.Clock.*;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class TowerCannon {
	private float x, y, timeSinceLastShot, firingSpeed;
	private int width, height, damage;
	private Texture baseTexture, cannonTexture;
	private Tile startTile;
	private ArrayList<Projectile> projectiles;
	
	public TowerCannon(Texture baseTexture, Tile startTile, int damage) {
		this.baseTexture = baseTexture;
		this.cannonTexture = QuickLoad("cannonGun");
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = (int)startTile.getWidth();
		this.height = (int) startTile.getHeight();
		this.damage = damage;
		this.firingSpeed = 30;
		this.timeSinceLastShot = 0;
		this.projectiles = new ArrayList<Projectile>();
	}
	
	public void update() {
		timeSinceLastShot+= delta();
		if(timeSinceLastShot > firingSpeed)
			shoot();
		for (Projectile p:projectiles)
			p.update();
		
		draw();
	}
	
	public void shoot() {
		timeSinceLastShot = 0;
		projectiles.add(new Projectile(QuickLoad("bullet"),x+32,y+32,5,10));
	}
	
	public void draw() {
		
		drawQuadTex(baseTexture,x,y,width,height);
		drawQuadTex(cannonTexture,x,y,width,height);
	}
}
