
import java.awt.Graphics;

public abstract class State {
	//State manager
	private static State currentState=null;
	
	public static void setState(State state) {
		currentState = state;
	}
	public static State getState() {
		return currentState;
	}
	
	//
	//letrehozok egy game objektumot 
	protected Game game;
	public State(Game game) {
		this.game=game;
	}
	public abstract void update();
	public abstract void render(Graphics g);
}
