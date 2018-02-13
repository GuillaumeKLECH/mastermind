package org.klechcorp.mastermind.helpers;

import java.util.HashSet;

public enum Color {
	Rouge('R'),
	Jaune('J'),
	Bleu('B'),
	Orange('O'),
	Vert('V'),
	Noir('N');
	
	private final Character c;
	private Color(Character _c) {
		this.c = _c;
	}
	
	public Character getChar() {
		return this.c;
	}
	
	@Override
	public String toString() {
		return "'" + getChar() + "'" + " (" + name() + ")";
	}

	static final HashSet<Character> colors = new HashSet<> ();
	static {
		for(Color col : Color.values())
			colors.add(col.c);
	}		
}
