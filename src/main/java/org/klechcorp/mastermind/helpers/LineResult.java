package org.klechcorp.mastermind.helpers;

import java.util.StringJoiner;


public class LineResult {
		private final String line;
		private final int nbrOfPinsInRightPlace;
		private final int nbrOfPinsInWrongPlace;
		private final int attemptNbr;
		
		public LineResult(String line, int nbrOfPinsInRightPlace, int nbrOfPinsInWrongPlace, int attemptNbr) {
			this.line = line;
			this.nbrOfPinsInRightPlace = nbrOfPinsInRightPlace;
			this.nbrOfPinsInWrongPlace = nbrOfPinsInWrongPlace;
			this.attemptNbr = attemptNbr;
		}
		
		@Override
		public String toString() {
			StringJoiner sj = new StringJoiner(" | ", "| ", " |");
			sj.add(line);
			sj.add(Integer.toString(this.nbrOfPinsInRightPlace));
			sj.add(Integer.toString(this.nbrOfPinsInWrongPlace));
			sj.add(String.format("%2d/%d", this.attemptNbr, Constants.MAX_TRIES));
			return sj.toString();
		}
		
		public boolean isTheSolution() {
			return this.nbrOfPinsInRightPlace == Constants.NBR_OF_PINS;
		}
		
		public int getRightColorWrongPlaceNbr() { return this.nbrOfPinsInWrongPlace;}
		public int getRightColorRightPlaceNbr() { return this.nbrOfPinsInRightPlace;}
		
}
