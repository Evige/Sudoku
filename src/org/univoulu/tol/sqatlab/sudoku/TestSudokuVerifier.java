package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSudokuVerifier {
	
	private SudokuVerifier verifier;
	private List<Integer> expectedResult = new ArrayList();
	private String correctSolution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	private String incorrectSolution = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	
	@Before
	public void setup() {
		verifier = new SudokuVerifier();
		
		int looper = 0;
		while (looper < 9) {
			int y = 1;
			for (y = 1; y <= 9; y++) {
				expectedResult.add(y);	
			}
			looper = looper + 1;
		}
		Collections.sort(expectedResult);
	}
	
	@Test
	public void testFirstRowWontContainDuplicatesCorrectSolution() {
		List<Integer> firstRow = new ArrayList();
		List<Integer> expectedFirstRow = new ArrayList();
		
		for (int x = 0; x < 9; x++) {
			int number = Integer.parseInt(String.valueOf(correctSolution.charAt(x)));
			firstRow.add(number);
		}
		
		for (int y = 1; y <= 9; y++) {
			expectedFirstRow.add(y);	
		}
		
		Collections.sort(firstRow);
		
		assertEquals(expectedFirstRow, firstRow);
	}
	
	@Test
	public void testGlobalRowsWontContainDuplicates() {
		int result = verifier.verify(correctSolution);
		
		assertEquals(0, result);
	}

	@Test
	public void testSolution81LongWithCorrectSolution() {
		verifier.verify(correctSolution);
		String solution = verifier.getCandidateSolution();
		
		assertEquals(81, solution.length());
	}
	
	@Test
	public void testSolution81LongWithIncorrectSolution() {
		verifier.verify(incorrectSolution);
		String solution = verifier.getCandidateSolution();
		
		assertEquals(81, solution.length());
	}

}
