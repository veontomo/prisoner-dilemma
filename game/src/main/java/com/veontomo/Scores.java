package com.veontomo;

public record Scores(int score1, int score2) {
	public Scores add(Scores s) {
		return new Scores(this.score1 + s.score1, this.score2 + s.score2);
	}
}
