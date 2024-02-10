package com.veontomo;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.external.players.Player;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		List<Player> players = loadPlayers(args[0]);
		final List<Player> local = Arrays.asList(new EvilPlayer(), new GoodPlayer(), new RandomBinaryPlayer(),
				new HonestPlayer(), new RandomSkewedPlayer());
		players.addAll(local);
		final int gameRounds = 20;
		final int tournamentRounds = 1000;
		final Tournament tour = new Tournament(players, new TwoPlayerGame(gameRounds), tournamentRounds);
		final int prizePool = 3 * players.size() * (players.size() - 1) * gameRounds * tournamentRounds;
		final Map<String, Integer> scores = tour.play();
		System.out.println("Prize pool: " + prizePool);
		showResults(scores);
	}

	private static void showResults(Map<String, Integer> scores) {
		List<Entry<String, Integer>> list = scores.entrySet().stream().sorted((s1, s2) -> s2.getValue() - s1.getValue())
				.toList();
		final int total = list.stream().mapToInt(Entry::getValue).sum();
		System.out.println("Total sum: " + total);
		list.forEach(s -> System.out.println(String.format("%s: %.4f", s.getKey(), (1.d * s.getValue()) / total)));

	}

	private static List<Player> loadPlayers(String folder) {
		System.out.println("Loading player jars from " + folder);
		List<Player> plugins = new ArrayList<>();
		File pluginsDir = new File(folder);

		File[] jarFiles = pluginsDir.listFiles((dir, name) -> name.endsWith(".jar"));

		if (jarFiles != null) {
			for (File jarFile : jarFiles) {
				try (URLClassLoader classLoader = new URLClassLoader(new URL[] { jarFile.toURI().toURL() })) {
					Class<?> pluginClass = classLoader.loadClass("com.external.players.HonestPlayer");

					final Object obj = pluginClass.getDeclaredConstructor().newInstance();
					if (obj instanceof Player p) {
						plugins.add(p);
					}
				} catch (Exception e) {
					System.err.println("Failed to load the class from " + jarFile.getAbsolutePath());
				}
			}
		}

		return plugins;
	}

}
