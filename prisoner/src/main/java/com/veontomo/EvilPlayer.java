package com.veontomo;

import java.util.ArrayList;
import java.util.List;

public class EvilPlayer implements Player {



	private final List<MatchOutcome> states;

	public EvilPlayer() {
		this.states = new ArrayList<>(10);
	}

	@Override
	public MatchOutcome play() {
		return MatchOutcome.BETRAY;
	}

	@Override
	public void remember(MatchOutcome o) {
		this.states.add(o);

	}

}
