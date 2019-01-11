
import java.awt.image.BufferedImage;

public class SpriteSheet {
		
		private BufferedImage sheet;
		
		public SpriteSheet(BufferedImage sheet) {
			
			this.sheet=sheet;
			
		}
		// kivagjaa a spritesheetrol a megfelelo kepet
		public BufferedImage crop(int x ,int y , int width , int height) {
			return sheet.getSubimage(x, y, width, height);
		}
}
