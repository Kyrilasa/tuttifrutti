
 import java.awt.image.BufferedImage;



public class Assets {
	
	private static final int tile_width = 64,tile_height = 64;
	public static BufferedImage apple,dirt,sand,player_up,player_down,player_left,player_right,sour_apple,ball,cherry;
	
	public static void init() {
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet1.0.png"));
		//egyenkent inicializalja a kivagott kepeket és egy Asset.* valtozohoz rendelu
		//map
		sand = sheet.crop(0, 0, tile_width, tile_height);
		apple = sheet.crop(tile_width,0,tile_width,tile_height);
		dirt = sheet.crop(tile_width*6, 0, tile_width,tile_height);
		cherry = sheet.crop(tile_width,tile_height, tile_width ,tile_height);
		//player
		player_down = sheet.crop(tile_width*2, 0, tile_width,tile_height);
		player_left = sheet.crop(tile_width*3, 0, tile_width,tile_height);
		player_right = sheet.crop(tile_width*4, 0, tile_width,tile_height);
		player_up = sheet.crop(tile_width*5, 0, tile_width,tile_height);
		
		ball = sheet.crop(0,tile_height, tile_width ,tile_height);
		//sourapple
		sour_apple = sheet.crop(tile_width*7, 0, tile_width, tile_height);
						
		
		
		
	}

	public static int getTileWidth() {
		return tile_width;
	}

	public static int getTileHeight() {
		return tile_height;
	}
	
}
