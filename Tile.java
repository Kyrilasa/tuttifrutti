
import java.awt.Graphics;

import java.awt.image.BufferedImage;

public class Tile {
	//
	public static Tile[] tiles =new Tile[256];
	public static Tile dirtTile = new DirtTile(1);
	public static Tile sandTile = new SandTile(2);
	public static Tile cherryTile = new CherryTile(3);
	
	//
	public static final int tile_width =64,tile_height = 64;
	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture,int id) {
			this.texture=texture;
			this.id = id;
			tiles[id]=this;
	}
	public void update() {
		
	}
	public void render(Graphics g,int x,int y) {
		g.drawImage(texture, x, y, tile_width, tile_height, null);
	
	}
	public  boolean isMoveable() {
		return false;
	}
	public int getId() {
		return id;
	}
}
