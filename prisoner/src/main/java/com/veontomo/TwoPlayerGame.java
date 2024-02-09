package com.veontomo;

import java.util.ArrayList;
import java.util.List;

import com.external.players.MatchOutcome;
import com.external.players.Player;

public class TwoPlayerGame implements Game {

	private final Player player1;
	private final Player player2;
	private final int rounds;
	private Scores scores = new Scores(0, 0);
	private final List<MatchOutcome> history1;
	private final List<MatchOutcome> history2;

	public TwoPlayerGame(Player p1, Player p2, int rounds) {
		this.player1 = p1;
		this.player2 = p2;
		this.rounds = rounds;
		this.history1 = new ArrayList<>(rounds);
		this.history2 = new ArrayList<>(rounds);
	}

	@Override
	public List<Integer> play() {
		System.out.println(this.player1.getName() + " vs " + this.player2.getName());
		this.scores = new Scores(0, 0);
		for (int i = 0; i < this.rounds; i++) {
			MatchOutcome outcome1 = this.player1.play();
			MatchOutcome outcome2 = this.player2.play();
			this.history1.add(outcome1);
			this.history2.add(outcome2);
			this.player1.opponentDecision(outcome2);
			this.player2.opponentDecision(outcome1);
			final Scores score = this.calculateScore(outcome1, outcome2);
			this.scores = this.scores.add(score);
		}
		return List.of(this.scores.score1, this.scores.score2);
	}

	/**
	 * See https://en.wikipedia.org/wiki/Prisoner%27s_dilemma
	 * 
	 * @param outcome1
	 * @param outcome2
	 * @return
	 */
	private Scores calculateScore(MatchOutcome outcome1, MatchOutcome outcome2) {
		if (outcome1 == MatchOutcome.COOPERATE) {
			return outcome2 == MatchOutcome.COOPERATE ? new Scores(3, 3) : new Scores(0, 5);
		}
		return outcome2 == MatchOutcome.COOPERATE ? new Scores(5, 0) : new Scores(1, 1);

	}

	private static record Scores(int score1, int score2) {
		public Scores add(Scores s) {
			return new Scores(this.score1 + s.score1, this.score2 + s.score2);
		}

		public int total() {
			return score1 + score2;
		}
	}

	@Override
	public Integer score() {
		return this.scores.total();
	}

}
