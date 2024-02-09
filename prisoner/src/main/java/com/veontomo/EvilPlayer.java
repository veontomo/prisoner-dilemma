package com.veontomo;

import com.external.players.MatchOutcome;
import com.external.players.Player;

public class EvilPlayer implements Player {



	@Override
	public MatchOutcome play() {
		return MatchOutcome.BETRAY;
	}

	@Override
	public void remember(MatchOutcome o) {
		// nothing to do here
	}

	@Override
	public String getName() {
		return "evil player";
	}

}
