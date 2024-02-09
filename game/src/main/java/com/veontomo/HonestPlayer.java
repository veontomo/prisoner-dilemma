package com.veontomo;

import java.util.Optional;

import com.external.players.MatchOutcome;
import com.external.players.Player;

public class HonestPlayer implements Player {



	private Optional<MatchOutcome> last;

	public HonestPlayer() {
		this.last = Optional.empty();
	}

	@Override
	public MatchOutcome play() {
		return this.last.orElse(MatchOutcome.COOPERATE);
	}

	@Override
	public void opponentDecision(MatchOutcome o) {
		this.last = Optional.of(o);

	}

	@Override
	public String getName() {
		return "honest player";
	}

}
