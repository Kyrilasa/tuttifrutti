

import java.awt.Graphics;

import java.util.Random;



public class SourApple extends Creature {
	Random rand = new Random();
	protected int xBefore, yBefore;
	private boolean isLiving = false;

	public SourApple(int x, int y) {
		super(x, y);
		isLiving = true;
	}

	@Override
	public void update() {
		/*
		 * r==1 fel r==2 le r==3 jobbra r==4 balra
		 */
		int r = rand.nextInt(5) + 1;
		if (isLiving) {
			
				if ((((this.x + 64) < Main.getWidth()) && World.getTile((this.x + 64) / 64, this.y / 64).isMoveable())) {
				if (World.getTile(this.x / 64, (this.y + 64) / 64).isMoveable()|| World.getTile(this.x / 64, (this.y - 64) / 64).isMoveable()) {
				
					
					if ((r == 1) && World.getTile(this.x / 64, (this.y - 64) / 64).isMoveable()&&((y-64)>0)) {
						if(xBefore==x&&yBefore==y-64)
							return;
						this.y -= 64;
						this.hitbox.y = y;
					} else if ((r == 2) && World.getTile(this.x / 64, (this.y + 64) / 64).isMoveable()&&((y+64)<Main.getHeight())) {
						if(xBefore==x&&yBefore==y+64)
							return;
						this.y += 64;
						this.hitbox.y = y;
					}else {
						this.x += 64;
						this.hitbox.x = x;
					}
				} 
			} 
			else if ((((this.x - 64) > 0) && World.getTile((this.x - 64) / 64, this.y / 64).isMoveable())) {
					if (World.getTile(this.x / 64, (this.y + 64) / 64).isMoveable()|| World.getTile(this.x / 64, (this.y - 64) / 64).isMoveable()) {
						
						System.out.println(r);
						if ((r == 1) && World.getTile(this.x / 64, (this.y - 64) / 64).isMoveable()&&((y-64)>0)) {
							if(xBefore==x&&yBefore==y-64)
								return;
							this.y -= 64;
							this.hitbox.y = y;
						} else if ((r == 2) && World.getTile(this.x / 64, (this.y + 64) / 64).isMoveable()&&((y+64)<Main.getHeight())) {
							if(xBefore==x&&yBefore==y+64)
								return;
							this.y += 64;
							this.hitbox.y = y;
						} else {
							this.x -= 64;
							this.hitbox.x = x;
						}
				}
			} else if ((((this.y + 64) > Main.getHeight())&& World.getTile((this.x) / 64, (this.y + 64) / 64).isMoveable())) {
				if (World.getTile((this.x + 64) / 64, (this.y) / 64).isMoveable()|| World.getTile((this.x - 64) / 64, (this.y) / 64).isMoveable()) {
				
					System.out.println(r);
					if ((r == 3) && World.getTile((this.x + 64) / 64, (this.y) / 64).isMoveable()) {
						if(xBefore==x+64&&yBefore==y)
							return;
						this.x += 64;
						this.hitbox.x = x;
					} else if ((r == 4) && World.getTile((this.x - 64) / 64, (this.y) / 64).isMoveable()) {
						if(xBefore==x+64&&yBefore==y)
							return;
						this.x -= 64;
						this.hitbox.x = x;
					}else {
						this.y += 64;
						this.hitbox.y = y;
					}
				} 
			} else if ((((this.y - 64) > Main.getHeight())&& World.getTile((this.x) / 64, (this.y - 64) / 64).isMoveable())) {
				if (World.getTile((this.x + 64) / 64, (this.y) / 64).isMoveable()
						|| World.getTile((this.x - 64) / 64, (this.y) / 64).isMoveable()) {
				
					System.out.println(r);
					if ((r == 3) && World.getTile((this.x + 64) / 64, (this.y) / 64).isMoveable()) {
						if(xBefore==x+64&&yBefore==y)
							return;
						this.x += 64;
						this.hitbox.x = x;
					} else if ((r == 4) && World.getTile((this.x - 64) / 64, (this.y) / 64).isMoveable()) {
						if(xBefore==x+64&&yBefore==y)
							return;
						this.x -= 64;
						this.hitbox.x = x;
					}else {
						this.y -= 64;
						this.hitbox.y = y;
					}
				} 
			}

			if (health == 0) {
				isLiving = false;
			}
		}
		xBefore = x;
		yBefore = y;

	}

	@Override
	public void render(Graphics g) {
		if (isLiving) {
			g.drawImage(Assets.sour_apple, (int) x, (int) y, null);
		}
	}

}
