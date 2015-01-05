package net.indierising.momentum.client.network;

import net.indierising.momentum.client.entitydata.PlayerData;

public class Packets {
	// inputs
	public static class Key {
		public int key;
		public boolean pressed; // whether the key was pressed or released.
	}
	
	public static class PlayerPacket {
		public PlayerData data;
	}
	
	public static class PlayerMove {
		public int connectionID;
		public float x, y;
		public int dir;
	}
	
	public static class EntityPacket{
		public float x,y,speed;
		public int direction;
		public String imageLocation;
		public int id;
	}
}