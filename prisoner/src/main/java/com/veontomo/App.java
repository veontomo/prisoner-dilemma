package com.veontomo;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import com.external.players.Player;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
//		final Player p1 = new GoodPlayer();
//		final Player p2 = new RandomBinaryPlayer();
//		final Player p3 = new HonestPlayer();
		final Player p4 = new RandomSkewedPlayer(0.2d);
		List<Player> players = loadPlayers();
		final Player p5 = new RandomSkewedPlayer(0.1d);
		final Game game = new TwoPlayerGame(players.get(0), p5, 1000);
		List<Integer> result = game.play();
		System.out.println(result);

	}

	private static List<Player> loadPlayers() {
		List<Player> plugins = new ArrayList<>();
		File pluginsDir = new File(
				"c:/Users/a.shcherbakov.WE-COM/Documents/projects/sandbox/prisoner-dilemma/player1/target/");

		File[] jarFiles = pluginsDir.listFiles((dir, name) -> name.endsWith(".jar"));

		if (jarFiles != null) {
			for (File jarFile : jarFiles) {
				try (URLClassLoader classLoader = new URLClassLoader(new URL[] { jarFile.toURI().toURL() })) {
					Class<?> pluginClass = classLoader.loadClass("com.external.players.HonestPlayer");
					Player plugin = (Player) pluginClass.getDeclaredConstructor().newInstance();
					plugins.add(plugin);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return plugins;
	}
}
