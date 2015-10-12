package org.univoulu.tol.sqatlab.sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuVerifier {
	
	private String candidateSolution = "";
	private List<Integer> expectedGlobalRow = new ArrayList();
	private List<Integer> expectedGlobalColumn = new ArrayList();

	public int verify(String candidateSolution) {
		// returns 1 if the candidate solution is correct
		this.candidateSolution = candidateSolution;
		int result = 0;
		
		List<Integer> solutionNumbers = new ArrayList();
		
		for (int x = 0; x < 81; x++) {
			int number = Integer.parseInt(String.valueOf(candidateSolution.charAt(x)));
			solutionNumbers.add(number);
		}
		
		result = checkDuplicatesInGlobalRows(solutionNumbers);
		
		return result;
	}
	
	private int checkDuplicatesInGlobalRows(List<Integer> solutionNumbers) {
		int result = 0;
		
		int looper = 0;
		int solutionDigitLocation = 0;
		while (looper < 9) {
			int y = 1;
			expectedGlobalRow = new ArrayList();
			List<Integer> checkedSolutionRow = new ArrayList();
			for (y = 1; y <= 9; y++) {
				expectedGlobalRow.add(y);
				checkedSolutionRow.add(solutionNumbers.get(solutionDigitLocation));
				solutionDigitLocation = solutionDigitLocation + 1;
			}
			Collections.sort(checkedSolutionRow);
			
			if (!expectedGlobalRow.equals(checkedSolutionRow)) {
				result = -3;
				break;
			}
			looper = looper + 1;
		}
		
		return result;
	}
}
