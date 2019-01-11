
import java.awt.Rectangle;

public	abstract class Creature extends Entity {
	protected int health;

	public Creature(int x, int y) {
		super(x, y);
		
		health = 1;
		//hitbox
		hitbox = new Rectangle(x,y,Assets.getTileWidth(),Assets.getTileHeight());
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	
}
