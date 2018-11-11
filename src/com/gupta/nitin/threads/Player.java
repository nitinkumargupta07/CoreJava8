package com.gupta.nitin.threads;
import java.util.*;

public class Player implements Runnable {
	private static int numPlayers;
	private int turnOrder;
	private Thread turn;
	boolean takingTurn = false;
	public Player() {
		numPlayers++;
		turnOrder = numPlayers;
		turn = new Thread(this);
	}
	public void run() {
		System.out.println("Player " + turnOrder + " is taking their turn");
		
		//do turn stuff;
		int turnTime = (int) ((Math.random() * 5000) + 1000);
		try {
			Thread.currentThread().sleep(turnTime);
			takingTurn = false;
		} catch (InterruptedException ie) {
			System.out.println(ie);
		}
	}
	public int getTurnOrder() {
		return turnOrder;
	}	
	public int getNumPlayers() {
		return numPlayers;
	}
	public boolean isTakingTurn() {
		return takingTurn;
	}
	public Thread getTurn() {
		return turn;
	}
	void takeTurn(List<Player> players) {
		takingTurn = true;
		//check if other players are still going
		boolean go = true;
		for(Player p : players) {
			if(p.isTakingTurn() == true && p.getTurnOrder() != turnOrder)	{
				go = false;
			}
		}
		synchronized(turn) {
			if(go) {
				turn.start();
				for(Player p : players) {
					try {
						p.getTurn().notify();
					} catch (IllegalMonitorStateException imse) {
						System.out.println(imse);
					}
				}
			} else {	
				try {
					System.out.println(turn.getId() + " is waiting");
					turn.wait();
				} catch (InterruptedException ie) {
					System.out.println(ie);
				}
			}
		}
	}

	
}



