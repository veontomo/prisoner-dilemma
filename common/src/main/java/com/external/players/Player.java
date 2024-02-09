package com.external.players;

public interface Player {

	MatchOutcome play();

	String getName();

	void opponentDecision(MatchOutcome o);
}
