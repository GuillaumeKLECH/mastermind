package org.klechcorp.mastermind.helpers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.klechcorp.mastermind.helpers.LineValidator;

public class LineValidatorTest {
	@Test
	public void lineAcceptableTooShort() throws Exception {
		String line = "RJB";
		assertFalse(LineValidator.isLineAcceptable(line));
	}
	
	@Test
	public void lineAcceptableTooLong() throws Exception {
		String line = "RJBON";
		assertFalse(LineValidator.isLineAcceptable(line));
	}
	
	@Test
	public void lineAcceptableWrongChar() throws Exception {
		String line = "RJBX";
		assertFalse(LineValidator.isLineAcceptable(line));
	}
	
	@Test
	public void testName() throws Exception {
		String line = "RJBO";
		assertFalse(LineValidator.isLineAcceptable(line));
	}
}
