package org.klechcorp.mastermind.helpers;

import java.util.Random;

public class SolutionGenerator {
	protected static Random rand = new Random();
	
	public static String generateSolution() {
		Color[] colorArr =  Color.values();
		char[] solution = new char[Constants.NBR_OF_PINS];
		for(int i = 0; i < Constants.NBR_OF_PINS; ++i) {
			char c = colorArr[rand.nextInt(colorArr.length)].getChar();
			solution[i] = c;
		}
		return new String(solution);
		
	}
}
