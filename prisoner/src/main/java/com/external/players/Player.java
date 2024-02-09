package com.external.players;

public interface Player {

	MatchOutcome play();

	void remember(MatchOutcome o);

	String getName();

}
