package net.indierising.momentum.client.entities;

import java.util.ArrayList;

import net.indierising.momentum.client.network.Packets.NPCMove;
import net.indierising.momentum.client.network.Packets.NPCPacket;
import net.indierising.momentum.client.network.Packets.PlayerPacket;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class EntityHandler {
	public static ArrayList<Player> players = new ArrayList<Player>();
	public static ArrayList<Entity> npcs = new ArrayList<Entity>();
	
	public static void render(Graphics g){
		for(int i = 0; i < players.size(); i++){
			players.get(i).render(g);
		}
		for(int i = 0; i < npcs.size(); i++){
			npcs.get(i).render(g);
		}
		
		// try to do this, might need optimising, but very little gain from doing so.
		try {
			loadNPCImages();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static Player getPlayerByID(int connectionID){
		for(int i = 0; i < players.size(); i++){
			if(players.get(i).getConnectionID() == connectionID) {
				return players.get(i);
			}
		}
		// if we can't find them sorry.
		return null;
	}
	
	public static void addPlayer(PlayerPacket packet) {
		if(getPlayerByID(packet.data.connectionID) == null) {
			players.add(new Player(packet.data));
			
		} else {
			getPlayerByID(packet.data.connectionID).setX(packet.data.x);
			getPlayerByID(packet.data.connectionID).setY(packet.data.y);
		}
	}
	
	public static Entity getNPCByID(int id){
		for(int i = 0; i < npcs.size(); i++){
			if(npcs.get(i).id == id) {
				return npcs.get(i);
			}
		}
		// if we can't find them sorry.
		return null;
	}
	
	public static void addNPC(NPCPacket packet) {
		npcs.add(new NPC(packet.data));
	}
	
	public static void moveNPC(NPCMove packet) {
		if(getNPCByID(packet.id)!=null) {
			getNPCByID(packet.id).setX(packet.x);
			getNPCByID(packet.id).setY(packet.y);
		}
	}
	
	private static void loadNPCImages() throws SlickException{
		for(int i = 0; i < npcs.size(); i++){
			npcs.get(i).loadImage();
		}
	}
}
