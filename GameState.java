
import java.awt.Graphics;



public class GameState extends State {
		private World world;
		private   Player player;
		private  Apple apple;
		private SourApple sp;
		
		private CollisionManager cm;

		int tick  = 0;
		

	

	public GameState(Game game) {
		super(game);
		world = new World("worlds/world.txt");
		player = new Player(game,world.getSpawnX(),world.getSpawnY());
		apple = new Apple(192,64);
		sp = new SourApple(192,192);

		cm=new CollisionManager(player, apple);
	
		
		
	}
	
	@Override
	public void update() {
		tick++;	
		world.update();
	
		player.update();
		if(tick%2==0) {
			sp.update();
			apple.update();	
		}
		cm.update();
		
		if(World.cherryCount==0) {
			System.out.println("you win");
			System.exit(-1);
		}
		
		
	}


	public void render(Graphics g) {
		world.render(g);
		player.render(g);
			apple.render(g);
			sp.render(g);
			
				
		
		
	}

	public  Player getPlayer() {
		return player;
	}


	public  Apple getApple() {
		return apple;
	}
}
