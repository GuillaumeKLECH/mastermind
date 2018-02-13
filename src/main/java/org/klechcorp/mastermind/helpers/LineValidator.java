package org.klechcorp.mastermind.helpers;

import java.util.StringJoiner;

public class LineValidator {
	
	public static boolean isLineAcceptable(String _line) {
		if (_line.length() == Constants.NBR_OF_PINS) {
			boolean res = true;
			StringJoiner sj = new StringJoiner(",");
			for (int i = 0; i < Constants.NBR_OF_PINS; ++i) {
				Character c = _line.charAt(i);
				if(!Color.colors.contains(c)) {
					sj.add(c.toString());
					res = false;
				}
			}
			if(!res)
				System.out.printf("%s ne sont pas des caractères valides.\n", sj.toString());
			return res;
		} else {
			System.out.println(((_line.length() > Constants.NBR_OF_PINS) ? "Trop de " : "Pas assez de ") +  "caractères");
			return false;
		}
	}
}
