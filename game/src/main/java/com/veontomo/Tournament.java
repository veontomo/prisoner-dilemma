package com.veontomo;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.external.players.Player;

public class Tournament {

	private final List<Player> prototypes;
	final Game game;
	private final int rounds;

	public Tournament(List<Player> prototypes, Game game, int rounds) {
		if (prototypes == null || prototypes.size() < 2) {
			throw new IllegalArgumentException("Tournament requires at least two players.");
		}
		this.prototypes = Collections.unmodifiableList(prototypes);
		this.game = game;
		this.rounds = rounds;
	}

	public Map<String, Integer> play() {
		final Map<String, Integer> allScores = new HashMap<>(this.prototypes.size());

		for (int r = 0; r < this.rounds; r++) {
			final List<Player> players = this.initPlayers(this.prototypes);
			final int s = players.size();
			for (int i = 0; i < s - 1; i++) {
				for (int j = i + 1; j < s; j++) {
					final Player p1 = players.get(i);
					final Player p2 = players.get(j);
					Scores scores = this.game.play(p1, p2);
					this.addScore(allScores, p1.getName(), scores.score1());
					this.addScore(allScores, p2.getName(), scores.score2());
				}
			}
		}
		return allScores;
	}

	private List<Player> initPlayers(List<Player> proto) {
		return proto.stream().map(p -> {
			try {
				return p.getClass().getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				return null;
			}
		}).filter(Objects::nonNull).map(s -> (Player) s).toList();
	}

	private void addScore(Map<String, Integer> target, String p, int score) {
		int initValue = target.containsKey(p) ? target.get(p) : 0;
		target.put(p, initValue + score);
	}

}
