package com.veontomo;

import java.util.Random;

import com.external.players.MatchOutcome;
import com.external.players.Player;

public class RandomSkewedPlayer implements Player {



	private final Random random = new Random();
	private double rate;

	/**
	 * A player that betrays with given probability.
	 */
	public RandomSkewedPlayer(double rate) {
		if (rate < 0 || rate > 1) {
			throw new IllegalArgumentException("The rate must be in range from 0 to 1");
		}
		this.rate = rate;

	}

	@Override
	public MatchOutcome play() {
		return this.random.nextDouble() < this.rate ? MatchOutcome.BETRAY : MatchOutcome.COOPERATE;
	}

	@Override
	public void remember(MatchOutcome o) {

	}

	@Override
	public String getName() {
		return String.format("%2.0f/%2.0f player", 100 * this.rate, 100 - 100 * this.rate);
	}

}
