package com.jesseboyd.warGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WarApp {

	private List<WarPlayer> playerList;

	public static void main(String[] args) {
		WarApp w = new WarApp();

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of players: ");
		int numPlayers = Integer.valueOf(scan.nextLine());
		for (int i = 0; i < numPlayers; i++) {
			System.out.println("Enter players name: ");
			String nameIn = scan.nextLine();
			w.createPlayerAndAddToList(nameIn);
		}
		System.out.println("Enter number of Suits: ");
		int numSuits = Integer.valueOf(scan.nextLine());
		System.out.println("Enter number of Ranks: ");
		int numRanks = Integer.valueOf(scan.nextLine());
		scan.close();

		w.play(numSuits, numRanks, numPlayers, w.playerList);
	}

	public void play(int numberOfSuits, int numberOfRanks, int numberOfPlayers, List<WarPlayer> players) {
		Deck deck = new Deck();
		deck.create(numberOfSuits, numberOfRanks, numberOfPlayers, players);
		deck.shuffle();
		deck.deal();
		boolean looper = true;
		while (looper) {
			looper = deck.getNextCards();
		}
		System.out.println(deck.getWinner());
	}

	public WarPlayer createPlayerAndAddToList(String name) {
		WarPlayer wp = new WarPlayer(name);
		if(playerList == null){
			playerList = new ArrayList<WarPlayer>();
		}
		playerList.add(wp);
		return wp;
	}

	public List<WarPlayer> getPlayerList() {
		return playerList;
	}
	
	

}
