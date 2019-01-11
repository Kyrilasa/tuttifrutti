
import java.awt.*;
import java.awt.image.BufferStrategy;



public class Game implements Runnable {

	// 5.letrehoztam a kepernyőobjektumot a jatekban
	private Display display;

	// 6.letrehoztam seged string, szelesseg/magassag valtozokat hogy ebbe taroljam
	// a kepernyovaltozoit és itt is tudjam hasznalni setter/getter nelkul
	public int width, height;
	public String title;

	// 7.csinalok egy szalat "threadet"
	private Thread thread;

	private boolean running = false;

	private BufferStrategy bs;

	// ez az ecsetobjektumunk ezzel abrazolunk akarmit a canvasra
	private Graphics g;
	
	

	//States jatekallapot
	private State gameState;

	
	//input object
	private KeyManager keyManager;
	//
	

	public Game(String TITLE, int WIDTH, int HEIGHT) {

		// eltarolom a helyivaltozokban a width/height
		this.width = WIDTH;
		this.height = HEIGHT;
		this.title = TITLE;
		//inicializalom a key listenert
		keyManager = new KeyManager();
	}

	private void initialize() {

		// inicializalom a kepernyot és a billentyuzetet
		display = new Display(title, width, height);
		//a framehez hozzadadjuk a keyboard listenert
		display.getFrame().addKeyListener(keyManager);
		// inicializalom a spritesheetet
		Assets.init();
		
		//inicializalom a GameStatet
		gameState = new GameState(this);

		State.setState(gameState);
	}
	private void update() {
		keyManager.update();
		if(State.getState()!=null) {
			State.getState().update();
		}
		
		
	}

	private void render() {

		bs = display.getCanvas().getBufferStrategy();

		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
		//
		
		//
		if(State.getState()!=null) {
			State.getState().render(g);
		}
		bs.show();
		g.dispose();

	}

	@Override
	public void run() {

		initialize();
		double fps =1;
		double timePerTick = 100000000/fps;
		double delta = 0;
		long now ;
		long lastTime = System.nanoTime();
		
		while (running) {
				now = System.nanoTime();
				delta+=(now - lastTime)/timePerTick;
			
				lastTime = now ;
				
				if(delta >= 1) {
					update();
					render();
					
					delta--;
				}
				
				
		}
		stop();
	}
	public KeyManager getKeyManager() {
		return keyManager;
	}

	public synchronized void start() {
		if (running) {
			return;
		}	
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running) {
			return;
		} else {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public Graphics getG() {
		return g;
	}
}

