package net.indierising.momentum.client;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Game extends StateBasedGame {
	public static AppGameContainer app;
	
	// list of states
	public static final int MENU = 0;
    public static final int PLAY = 1;
    
    public final static int WIDTH = 1280;
    public final static int HEIGHT = 720;
	
	public Game() {
		super("Momentum Client");
		
		// add our states
		this.addState(new Menu());
		this.addState(new Play());
        this.enterState(MENU);
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(MENU).init(gc, this);
		this.getState(PLAY).init(gc, this);
	}

	public static void main(String args[]) throws SlickException {
		 app = new AppGameContainer(new Game());
	     app.setShowFPS(false);
	     app.setDisplayMode(WIDTH, HEIGHT, false);
	     app.setTargetFrameRate(60);
	     app.setAlwaysRender(true);
	     app.setUpdateOnlyWhenVisible(false);
	     
	     // minimum deltas between frames
	     app.setMaximumLogicUpdateInterval(10);
		 app.setMaximumLogicUpdateInterval(60);
	     
	     app.start();
	}
}