package com.veontomo;

public class GoodPlayer implements Player {



	@Override
	public MatchOutcome play() {
		return MatchOutcome.COOPERATE;
	}

	@Override
	public void remember(MatchOutcome o) {
		// nothing to do here
	}

}
