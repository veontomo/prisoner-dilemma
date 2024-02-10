package com.veontomo;

import com.external.players.RoundOutcome;

public class RandomSkewedPlayer extends RandomPlayer {

	private double rate;

	/**
	 * A player that betrays with given probability.
	 */
	public RandomSkewedPlayer() {
		this.rate = 0.2d;
	}

	@Override
	public RoundOutcome play() {
		return this.random.nextDouble() < this.rate ? RoundOutcome.BETRAY : RoundOutcome.COOPERATE;
	}

	@Override
	public String getName() {
		return String.format("%2.0f/%2.0f player", 100 * this.rate, 100 - 100 * this.rate);
	}

}
