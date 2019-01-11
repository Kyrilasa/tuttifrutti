
import java.awt.Graphics;
import java.awt.Rectangle;



public class Player extends Creature {
	
	private Game game;
	private boolean isShooting = false; 
	 String merre;
	public Player(Game game,int x, int y) {
		super(x, y);
		this.game=game;
		health = 3;
		
	}

	@Override
	public void update() {
		//a player mozgasa
		if(game.getKeyManager().up&&(game.getKeyManager().down||game.getKeyManager().left||game.getKeyManager().right))
				return;
		if(game.getKeyManager().down&&(game.getKeyManager().up||game.getKeyManager().left||game.getKeyManager().right))
			return;
		if(game.getKeyManager().left&&(game.getKeyManager().down||game.getKeyManager().up||game.getKeyManager().right))
			return;
		if(game.getKeyManager().right&&(game.getKeyManager().down||game.getKeyManager().left||game.getKeyManager().up))
			return;
		if(game.getKeyManager().up) {
			if(y<=0)
				return;
			y-=64;
			hitbox.y=y;
		
			merre = "up";
			
		}
		if(game.getKeyManager().down) {
			//azert - 64 mert a player hitboxa a x,y balfelso kordinataja és a 64 pixeles kep alja +64 y ra van
			if(y>=Main.getHeight()-64)
				return;
			y+=64;
			hitbox.y=y;
			
			merre = "down";
		}
		if(game.getKeyManager().left) {
			if(x<=0)
				return;
			x-=64;
			hitbox.x=x;
		
			merre = "left";
		}
		if(game.getKeyManager().right) {
			if(x>=Main.getWidth()-64)
				return;
			x+=64;
			hitbox.x=x;
			merre = "right";
		}
		if(health==0) {
			System.exit(1);
		}
		if(World.tile[x/Tile.tile_width][y/Tile.tile_height]==1) {
			World.tile[x/Tile.tile_width][y/Tile.tile_height]=2;
		}
		if(World.tile[x/Tile.tile_width][y/Tile.tile_height]==3) {
			World.cherryCount--;
			World.tile[x/Tile.tile_width][y/Tile.tile_height]=2;
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		if(game.getKeyManager().up) {
			g.drawImage(Assets.player_up, x, y, null);
			return;
		}
		if(game.getKeyManager().down) {
			g.drawImage(Assets.player_down, x, y, null);
			return;
		}
		if(game.getKeyManager().left) {
			g.drawImage(Assets.player_left, x, y, null);
			return;
		}
		if(game.getKeyManager().right) {
			g.drawImage(Assets.player_right, x, y, null);
			return;
		}
		g.drawImage(Assets.player_down, x, y, null);
		
	}
		
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}

	public boolean isShooting() {
		return isShooting;
	}

	public void setShooting(boolean isShooting) {
		this.isShooting = isShooting;
	}



	public String getMerre() {
		return merre;
	}

	public Rectangle getHitbox() {
		// TODO Auto-generated method stub
		return this.hitbox;
	}

}
