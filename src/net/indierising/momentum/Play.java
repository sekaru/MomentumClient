package net.indierising.momentum;
import java.io.IOException;

import net.indierising.momentum.network.Network;
import net.indierising.momentum.network.Network.Key;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState{
	// stores the state of the game
	int stateID = 0;
	
	// holds our registered classes and the client
	Network network;
	
	public Play(int stateID){
		this.stateID = stateID;
	}
	 
	public int getID() {
		return stateID;
	}
	
	public void init(GameContainer gc,StateBasedGame sc) throws SlickException {
		// eventually load these with the tagreader
		try {
			network = new Network("localhost",9000,9001);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void render(GameContainer gc,StateBasedGame sc, Graphics g) throws SlickException {
		
	}

	public void update(GameContainer gc,StateBasedGame sc, int delta) throws SlickException {
		
	}

	public void keyPressed(int key,char c){
		// TODO eventually load a list of all keys that can be pressed to avoid clogging the server
		Key packet = new Key();
		packet.keyCode = key;
		packet.pressed = true;
		Network.client.sendUDP(packet);
	}
	
	public void keyReleased(int key,char c){
		Key packet = new Key();
		packet.keyCode = key;
		packet.pressed = true;
		Network.client.sendUDP(packet);
	}
}