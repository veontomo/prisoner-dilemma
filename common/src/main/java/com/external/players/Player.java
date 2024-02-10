package com.external.players;

public interface Player {

	String getName();

	RoundOutcome play();

	void opponentDecision(RoundOutcome o);
}
