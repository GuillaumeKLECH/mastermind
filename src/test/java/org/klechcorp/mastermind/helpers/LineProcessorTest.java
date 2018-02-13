package org.klechcorp.mastermind.helpers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LineProcessorTest {
	
	private LineProcessor lp;
	
	@Before
	public void setUp() {
		lp = new LineProcessor();
	}
	
	private LineResult testLine(String _solution, String _line, int _attNbr) {
		lp.setSolution(_solution);
		return lp.processLine(_line, _attNbr);
	}

	@Test
	public void canWin() throws Exception {
		String line = "RJVB";
		LineResult lr = testLine(line, line, 1);
		assertTrue(lr.isTheSolution());
	}
	
	@Test
	public void canDetectWrongOrder() throws Exception {
		LineResult lr = testLine("RJVB", "BVJR", 1);
		assertTrue(lr.getRightColorWrongPlaceNbr() == 4);
		assertTrue(lr.getRightColorRightPlaceNbr() == 0);
	}
	
	@Test
	public void canWinAllTheSame() throws Exception {
		LineResult lr = testLine("OOOO", "OOOO", 1);
		assertTrue(lr.getRightColorWrongPlaceNbr() == 0);
		assertTrue(lr.getRightColorRightPlaceNbr() == 4);
	}
	
	@Test
	public void solutionHasMoreThanLine() throws Exception {
		LineResult lr = testLine("JJJO", "NBJJ", 1);
		assertTrue(lr.getRightColorWrongPlaceNbr() == 1);
		assertTrue(lr.getRightColorRightPlaceNbr() == 1);
	}
	
	@Test
	public void lineHasMoreThanSolution() throws Exception {
		LineResult lr = testLine("NBJJ", "JJJO", 1);
		assertTrue(lr.getRightColorWrongPlaceNbr() == 1);
		assertTrue(lr.getRightColorRightPlaceNbr() == 1);
	}
	
	@Test
	public void solutionHasSameThanLine() throws Exception {
		LineResult lr = testLine("NBJJ", "JJOV", 1);
		assertTrue(lr.getRightColorWrongPlaceNbr() == 2);
		assertTrue(lr.getRightColorRightPlaceNbr() == 0);
	}
}
