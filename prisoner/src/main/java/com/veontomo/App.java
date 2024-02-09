package com.veontomo;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		final Player p1 = new GoodPlayer();
		final Player p2 = new RandomBinaryPlayer();
		final Player p3 = new HonestPlayer();
		final Player p4 = new RandomSkewedPlayer(0.0d);
		final Game game = new TwoPlayerGame(p3, p4, 1000);
		List<Integer> result = game.play();
		System.out.println(result);
	}
}
