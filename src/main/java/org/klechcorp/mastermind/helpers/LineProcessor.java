package org.klechcorp.mastermind.helpers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LineProcessor {
	private HashMap<Character, Set<Integer> > compChoice = new HashMap<>(Constants.NBR_OF_PINS);
	
	public void setSolution(String _solution) {
		this.compChoice = prepareLine(_solution);
	}
	
	private HashMap<Character, Set<Integer> > prepareLine(String _line) {
		HashMap<Character, Set<Integer> > trans = new HashMap<>();
		for(int i = 0; i < _line.length(); ++i) {
			Character c = _line.charAt(i);
			Set<Integer> posOfc = trans.get(c);
			if(posOfc == null) {
				posOfc = new HashSet<Integer>();
				trans.put(c, posOfc);
			}
			posOfc.add(i);
		}
		return trans;
	}
	
	public LineResult processLine(String _line, int _attNbr) {
		
		HashMap<Character, Set<Integer> > playerChoice = prepareLine(_line);
		
		// Compare the two HashMaps
		int nbrOfPinsRightPlace = 0, nbrOfPinsWrongPlace = 0;
		// for each position set of a color present in the player's choice
		for(Character c : playerChoice.keySet()) { 
			Set<Integer> compSet = this.compChoice.get(c);
			Set<Integer> playSet = playerChoice.get(c);
			if(compSet != null) { // if the color is present in the computer choice
				int rightPlace = 0;
				for(Integer i : compSet) {
					//IF Position is correct
					if(playSet.contains(i))
						++rightPlace;
				}
				nbrOfPinsRightPlace += rightPlace;
				//For a given color, the nbr of eligible pins is the minimum between the player nbr of pins and the computer nbr of pins.
				// If the computer has more than the player we don't want to give it away.
				// If the player has more than the computer the additional pins are errors.
				//the nbr of eligible pins = nbrOfWronglyPlaced + nbrOfRightlyPlaced
				nbrOfPinsWrongPlace += Math.min(playSet.size(), compSet.size()) - rightPlace;
				
			}
		}
		
		return new LineResult(_line, nbrOfPinsRightPlace, nbrOfPinsWrongPlace, _attNbr);
	}
}
