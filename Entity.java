
import java.awt.Graphics;
import java.awt.Rectangle;
//abstract classs az "oroklesre van" tehat a gyermekosztályok specifikaljak a metodusokat
public	abstract class  Entity {
	protected int x,y;
	protected Rectangle hitbox;
	public Entity(int x,int y) {
		
		this.x=x;
		this.y=y;

		
	}
	public abstract void update();
	public abstract void render(Graphics g);
	public Rectangle getHitbox() {
		return hitbox;
	}
}