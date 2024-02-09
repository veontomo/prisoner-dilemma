package com.veontomo;

public class EvilPlayer implements Player {



	@Override
	public MatchOutcome play() {
		return MatchOutcome.BETRAY;
	}

	@Override
	public void remember(MatchOutcome o) {
		// nothing to do here
	}

}
