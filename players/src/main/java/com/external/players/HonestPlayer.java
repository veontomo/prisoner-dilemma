package com.external.players;

import java.util.Optional;

public class HonestPlayer implements Player {

	private Optional<RoundOutcome> last;

	public HonestPlayer() {
		this.last = Optional.empty();
	}

	@Override
	public RoundOutcome play() {
		return this.last.orElse(RoundOutcome.COOPERATE);
	}

	@Override
	public String getName() {
		return "honest";
	}

	@Override
	public void opponentDecision(RoundOutcome o) {
		this.last = Optional.of(o);
	}

}
