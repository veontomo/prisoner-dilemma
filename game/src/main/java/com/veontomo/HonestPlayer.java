package com.veontomo;

import java.util.Optional;

import com.external.players.RoundOutcome;
import com.external.players.Player;

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
	public void opponentDecision(RoundOutcome o) {
		this.last = Optional.of(o);

	}

	@Override
	public String getName() {
		return "honest player";
	}

}
