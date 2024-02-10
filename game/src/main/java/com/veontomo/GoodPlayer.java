package com.veontomo;

import com.external.players.RoundOutcome;
import com.external.players.Player;

public class GoodPlayer implements Player {



	@Override
	public RoundOutcome play() {
		return RoundOutcome.COOPERATE;
	}

	@Override
	public void opponentDecision(RoundOutcome o) {
		// nothing to do here
	}

	@Override
	public String getName() {
		return "good player";
	}

}
