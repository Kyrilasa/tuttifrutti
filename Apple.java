

import java.awt.Graphics;
import java.awt.Rectangle;


public class Apple extends Creature {
	private int gravitY = 64;
	private boolean isFalling = false;

	public Apple(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		isFalling = false;
		if ((y + Tile.tile_height) < Main.getHeight()) {
			if (World.tile[x / Tile.tile_width][(y + Tile.tile_height) / Tile.tile_height] == 1)
				return;
		}

		if (y >= Main.getHeight() - 64) {
			return;
		} else {
			isFalling = true;
			hitbox.y += gravitY;
			y += gravitY;

		}

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.apple, x, y, null);
	}

	public boolean isMoveable() {
		return false;
	}

	public boolean isFalling() {
		return isFalling;
	}

	public Rectangle getHitbox() {
	
		return this.hitbox;
	}
}
