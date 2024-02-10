package com.veontomo;

import java.util.ArrayList;
import java.util.List;

import com.external.players.Player;
import com.external.players.RoundOutcome;

public class TwoPlayerGame implements Game {

	private final int rounds;

	public TwoPlayerGame(int rounds) {
		this.rounds = rounds;
	}

	@Override
	public Scores play(Player player1, Player player2) {
		Scores scores = new Scores(0, 0);
		List<RoundOutcome> history1 = new ArrayList<>(rounds);
		List<RoundOutcome> history2 = new ArrayList<>(rounds);
		for (int i = 0; i < this.rounds; i++) {
			RoundOutcome outcome1 = player1.play();
			RoundOutcome outcome2 = player2.play();
			history1.add(outcome1);
			history2.add(outcome2);
			player1.opponentDecision(outcome2);
			player2.opponentDecision(outcome1);
			final Scores score = this.calculateScore(outcome1, outcome2);
			scores = scores.add(score);
		}
		return scores;
	}

	/**
	 * See https://en.wikipedia.org/wiki/Prisoner%27s_dilemma
	 * 
	 * @param outcome1
	 * @param outcome2
	 * @return
	 */
	private Scores calculateScore(RoundOutcome outcome1, RoundOutcome outcome2) {
		if (outcome1 == RoundOutcome.COOPERATE) {
			return outcome2 == RoundOutcome.COOPERATE ? new Scores(3, 3) : new Scores(0, 5);
		}
		return outcome2 == RoundOutcome.COOPERATE ? new Scores(5, 0) : new Scores(1, 1);

	}



}
