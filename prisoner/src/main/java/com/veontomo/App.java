package com.veontomo;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		final Player p1 = new GoodPlayer();
		final Player p2 = new RandomPlayer();
		final Game game = new TwoPlayerGame(p1, p2, 100);
		List<Integer> result = game.play();
		System.out.println(result);
	}
}
