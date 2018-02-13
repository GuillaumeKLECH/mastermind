package org.klechcorp.mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

import org.klechcorp.mastermind.helpers.Color;
import org.klechcorp.mastermind.helpers.Constants;
import org.klechcorp.mastermind.helpers.LineProcessor;
import org.klechcorp.mastermind.helpers.LineResult;
import org.klechcorp.mastermind.helpers.LineValidator;
import org.klechcorp.mastermind.helpers.SolutionGenerator;

public class Mastermind {
	private static final String GAME_STATE_HEADER_FOOTER = "|----------------------|";
	private final LineProcessor lineProcessor = new LineProcessor();
	private List<LineResult> tries = new ArrayList<>(Constants.MAX_TRIES);

	public void displayManual() {
		StringJoiner sj = new StringJoiner(",", "{", "}");
		for (Color col : Color.values())
			sj.add(col.toString());
		System.out.println("Vous devez choisir quatre punaises.");
		System.out.printf("Pour ce faire merci d'entrer quatre caractères parmi %s\n", sj.toString());
	}

	private void displayGameState() {
		System.out.println(GAME_STATE_HEADER_FOOTER);
		for(LineResult lr: tries) {
			System.out.println(lr.toString());
		}
		System.out.println(GAME_STATE_HEADER_FOOTER);
	}

	public void play() {
		Scanner scan = new Scanner(System.in);
		String line;
		this.lineProcessor.setSolution(SolutionGenerator.generateSolution());
		while (tries.size() < Constants.MAX_TRIES) {
			displayManual();
			line = scan.nextLine();
			if (LineValidator.isLineAcceptable(line)) {
				LineResult lr = this.lineProcessor.processLine(line, tries.size()+1);
				tries.add(lr);
				displayGameState();
				if(lr.isTheSolution()) {
					System.out.printf("Félicitations vous avez trouvé en %d essai(s)\n", tries.size());
					break;
				}
			}
		}
		scan.close();
	}

	public static void main(String[] args) {
		System.out.println("===============================================");
		System.out.println("MASTERMIND");
		System.out.println("===============================================");

		Mastermind mastermind = new Mastermind();
		mastermind.play();
		
	}

}
