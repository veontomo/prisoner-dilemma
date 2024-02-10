package com.veontomo;

import com.external.players.RoundOutcome;
import com.external.players.Player;

public class EvilPlayer implements Player {



	@Override
	public RoundOutcome play() {
		return RoundOutcome.BETRAY;
	}

	@Override
	public void opponentDecision(RoundOutcome o) {
		// nothing to do here
	}

	@Override
	public String getName() {
		return "evil player";
	}

}
