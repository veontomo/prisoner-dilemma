package com.veontomo;

import com.external.players.RoundOutcome;

public class RandomBinaryPlayer extends RandomPlayer {

	@Override
	public RoundOutcome play() {
		return this.random.nextBoolean() ? RoundOutcome.COOPERATE : RoundOutcome.BETRAY;
	}

	@Override
	public String getName() {
		return "50/50 player";
	}


}
