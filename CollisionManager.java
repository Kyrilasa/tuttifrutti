


public class CollisionManager {
	
	public Player player;
	public Apple apple;
	
	public CollisionManager(Player player,Apple apple) {
		this.player=player;
		this.apple=apple;
	
		
	}
	public void update() {
		if((player.getHitbox().intersects(apple.getHitbox()))&&apple.isFalling()) {
			player.setHealth(player.getHealth()-1);
		}
	}
	
}
