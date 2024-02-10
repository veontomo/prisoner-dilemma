package com.veontomo;

import java.util.Random;

import com.external.players.Player;
import com.external.players.RoundOutcome;

public abstract class RandomPlayer implements Player {



	protected final Random random = new Random();

	@Override
	public void opponentDecision(RoundOutcome o) {

	}
}