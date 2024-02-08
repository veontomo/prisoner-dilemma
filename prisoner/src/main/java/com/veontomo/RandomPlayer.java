package com.veontomo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPlayer implements Player {



	private final List<MatchOutcome> states;
	private final Random random;

	public RandomPlayer() {
		this.states = new ArrayList<>(10);
		this.random = new Random();
	}

	@Override
	public MatchOutcome play() {
		return this.random.nextBoolean() ? MatchOutcome.COOPERATE : MatchOutcome.BETRAY;
	}

	@Override
	public void remember(MatchOutcome o) {
		this.states.add(o);

	}

}
