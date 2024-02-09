package com.veontomo;

import com.external.players.MatchOutcome;
import com.external.players.Player;

public class GoodPlayer implements Player {



	@Override
	public MatchOutcome play() {
		return MatchOutcome.COOPERATE;
	}

	@Override
	public void opponentDecision(MatchOutcome o) {
		// nothing to do here
	}

	@Override
	public String getName() {
		return "good player";
	}

}
