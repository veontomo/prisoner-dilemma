package com.external.players;

import java.util.Optional;

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
	public void remember(MatchOutcome o) {
		this.last = Optional.of(o);

	}

	@Override
	public String getName() {
		return "honest";
	}

}
