package com.gupta.nitin.threads;
import java.util.*;

public class TestPlayer {
	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<Player>();
		for(int i = 0; i < 100; i++) {
			players.add(new Player());	
		}
		for(Player p : players) {
			p.takeTurn(players);
		}
	}
}