public class Main{
	protected static  int width;
	protected static int height;
	public static void main(String[] args) {
		
		
		width = 768;
		height = 640;
		
		
		Game TuttiFrutti = new Game("Tutti_Frutti",width,height);
		TuttiFrutti.start();
		
	}
	public static  int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		Main.width = width;
	}
	public static int getHeight() {
		return height;
	}
	public  void setHeight(int height) {
		Main.height = height;
	}

}
