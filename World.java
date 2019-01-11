

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class World {
	// a map szelte es hossza a matrixos kezeleshez
	private int width, height;
	// egy int matrix az adott id eltarolasahoz h adott helyen milyen tile
	// legyen
	private int spawnX,spawnY;
	public static int[][] tile;
	public static  int cherryCount = 0;
	public World(String path)
	{

		loadWorld(path);

	}

	public void update() {
		

	}

	public void render(Graphics g) {

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				// az y és x kordinatakat 64*64 pixeles blokkokra oztjuk
				getTile(x, y).render(g, x * Tile.tile_width, y * Tile.tile_height);
				
				
			}
		}

	}

	public  static Tile getTile(int x, int y) {
		// egy tile valtozo ami olyan asset.* vezs fel hogy az adott int id tomb milyen
		// ertekkel kerul bele
		Tile t = Tile.tiles[tile[x][y]];
		
		// ha az adott indexen nincs semmi visszater egy sima tileval
		return t;
	}

	private void loadWorld(String path) {
		String file = loadFileAsString(path);
		String tokens[] = file.split("\\s+");
		spawnX = parseInt(tokens[2]);
		spawnX = parseInt(tokens[3]);
		width = Main.getWidth()/64;
		height = Main.getHeight()/64;
		tile = new int [width][height];
		
		for(int y = 0;y <height;y++) {
			for(int x = 0;x <width;x++) {
			tile[x][y]= parseInt(tokens[(x + y * width)+4]);
			if(tile[x][y]==3) {
				cherryCount++;
			}
			}
		}
	}

	public int getSpawnX() {
		return spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}
	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine())!= null)
				builder.append(line + "\n");
			
			
			br.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return builder.toString();
		
	}
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}

	
}
