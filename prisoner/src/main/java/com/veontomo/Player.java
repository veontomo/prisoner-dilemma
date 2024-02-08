package com.veontomo;

public interface Player {

	MatchOutcome play();

	void remember(MatchOutcome o);

}
