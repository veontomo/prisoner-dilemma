package com.veontomo;

import java.util.List;

import com.external.players.MatchOutcome;
import com.external.players.Player;

public class TwoPlayerGame implements Game {

	private final Player player1;
	private final Player player2;
	private final int rounds;

	public TwoPlayerGame(Player p1, Player p2, int rounds) {
		this.player1 = p1;
		this.player2 = p2;
		this.rounds = rounds;
	}

	@Override
	public List<Integer> play() {
		System.out.println(this.player1.getName() + " vs " + this.player2.getName());
		Scores total = new Scores(0, 0);
		for (int i = 0; i < this.rounds; i++) {
			MatchOutcome outcome1 = this.player1.play();
			MatchOutcome outcome2 = this.player2.play();
			this.player1.remember(outcome2);
			this.player2.remember(outcome1);
			final Scores score = this.calculateScore(outcome1, outcome2);
			total = total.add(score);
		}
		return List.of(total.score1, total.score2);
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
			return outcome2 == MatchOutcome.COOPERATE ? new Scores(1, 1) : new Scores(3, 0);
		}
		return outcome2 == MatchOutcome.COOPERATE ? new Scores(0, 3) : new Scores(2, 2);

	}

	private static record Scores(int score1, int score2) {
		public Scores add(Scores s) {
			return new Scores(this.score1 + s.score1, this.score2 + s.score2);
		}
	}

}
