package com.veontomo;

import java.util.ArrayList;
import java.util.List;

public class GoodPlayer implements Player {



	private final List<MatchOutcome> states;

	public GoodPlayer() {
		this.states = new ArrayList<>(10);
	}

	@Override
	public MatchOutcome play() {
		return MatchOutcome.COOPERATE;
	}

	@Override
	public void remember(MatchOutcome o) {
		this.states.add(o);

	}

}
