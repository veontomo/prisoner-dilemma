package com.veontomo;

import java.util.Random;

import com.external.players.MatchOutcome;
import com.external.players.Player;

public class RandomBinaryPlayer implements Player {



	private final Random random = new Random();

	@Override
	public MatchOutcome play() {
		return this.random.nextBoolean() ? MatchOutcome.COOPERATE : MatchOutcome.BETRAY;
	}

	@Override
	public void remember(MatchOutcome o) {
		// nothing to do here
	}

	@Override
	public String getName() {
		return "yes/no player";
	}

}
