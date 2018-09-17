package com.necar.fingerprint.lib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.necar.fingerprint.beans.FingerPrintLog;

/**
 * Clase que encapsula la lógica pedida de la API.
 * 
 * @author Gustavo M. Borello
 *
 */
public class FingerPrintTools {
	public static final Character SUCESS_RESULT = 'S';
	public static final Character FAILED_RESULT = 'F';
	private static int correctAdjacentLetterQuant = 4;
	private static int correctMatchesToReach = 3;
	private static int n_matrix = 6; // #Rows

	private static int RIGHT_SCANNING_DIR = 1;
	private static int DOWN_SCANNING_DIR = 2;
	private static int DIAGONAL_DOWN_RIGHT_SCANNING_DIR = 3;
	private static int DIAGONAL_DOWN_LEFT_SCANNING_DIR = 4;
	
	/**
	 * Convierte la estructura enviada por el cliente String[] en una
	 * matriz char[][] para facilitar el análisis.
	 * @param data matriz original String[]
	 * @return matriz en formato char[][]
	 */
	private static char[][] convertToMatrix(String[] data) {
		char[][] matrix = new char[n_matrix][n_matrix];
		for (int i = 0; i < n_matrix; i++) {
			for (int j = 0; j < n_matrix; j++) {
				matrix[i][j] = data[i].charAt(j);
				/* System.out.print(matrix[i][j]); */
			}
			/* System.out.println(""); */
		}
		return matrix;
	}
	
	/**
	 * Función expuesta al usuario para hacer el análisis
	 * @param data array de String enviada por el cliente.
	 * @return true si se encontraron "correctMatchesToReach" repeticiones de
	 * "correctAdjacentLetterQuant" caracteres dentro de la matriz, false en
	 * caso contrario.
	 */
	public static boolean isFingerPrint(String[] data) {		
		char[][] matrix = convertToMatrix(data);

		boolean validFingerprint = false;
		int col = 0, row = 0;
		int[] dirs = { RIGHT_SCANNING_DIR, 
					   DOWN_SCANNING_DIR, 
					   DIAGONAL_DOWN_RIGHT_SCANNING_DIR,
					   DIAGONAL_DOWN_LEFT_SCANNING_DIR };
		int seqMatchesCounter = 0;
		while (!validFingerprint && row < n_matrix) {
			col = 0;
			while (!validFingerprint && col < n_matrix) {

				for (int direction : dirs) {
					if (evaluateTo(direction, matrix, row, col)) {
						seqMatchesCounter++;
					}
				}

				if (seqMatchesCounter == correctMatchesToReach) {
					validFingerprint = true;
				} else {
					col++;
				}
			}
			if (!validFingerprint) {
				row++;
			}
		}
		return validFingerprint;
	}
	
	/**
	 * Evalua los caracteres de la matriz en la dirección y celda especificada en busqueda
	 * de caracteres "correctAdjacentLetterQuant" repetidos.
	 * @param direction dirección de barrido.
	 * @param matrix matriz analizada.
	 * @param row celda
	 * @param col columna
	 * @return true si se encontró cadena de caracteres "correctAdjacentLetterQuant" de longitud,
	 * false en caso contrario.
	 */
	private static boolean evaluateTo(int direction, char[][] matrix, int row, int col) {
		char letterToMatch = matrix[row][col];
		char actualLetter;
		boolean maxReached = false, notValidSequenceFound = false;
		int _col = col;
		int _row = row;
		int sequenceCounter = 0;
		// TODO: poner una condicion antes para verificar que hay caracteres
		// suficientes.
		while (((_col < n_matrix && _col >= 0) && (_row < n_matrix && _row >= 0))
				&& !(maxReached || notValidSequenceFound)) {
			actualLetter = matrix[_row][_col];
			if (actualLetter == letterToMatch) {
				sequenceCounter++;
				if (sequenceCounter == correctAdjacentLetterQuant) {
					maxReached = true;
				}

				if (direction == RIGHT_SCANNING_DIR) {
					_col++;
				} else if (direction == DOWN_SCANNING_DIR) {
					_row++;
				} else if (direction == DIAGONAL_DOWN_LEFT_SCANNING_DIR) {
					_col++;
					_row++;
				} else if (direction == DIAGONAL_DOWN_RIGHT_SCANNING_DIR) {
					_row++;
					_col--;
				}
			} else {
				notValidSequenceFound = true;
			}
		}
		return maxReached;
	}
	
	/**
	 * Deserealiza la matriz en un objeto FingerPrintLog
	 * @param matrix array de String con los datos de la matriz.
	 * @return objeto FingerPrintLog
	 */
	public static FingerPrintLog createFingerPrintLogBean(String[] matrix) {
		FingerPrintLog fingerPrintLog = new FingerPrintLog();
		fingerPrintLog.setnOrder(matrix.length);

		for (int i = 1; i<=fingerPrintLog.getnOrder(); i++){			
	        try {
	        	Method method;
	        	method = FingerPrintLog.class.getMethod("setRow"+i, String.class);	        
				method.invoke(fingerPrintLog, matrix[i-1]);
			} catch (NoSuchMethodException | SecurityException |
					IllegalAccessException | IllegalArgumentException | 
					InvocationTargetException e) {
				e.printStackTrace();
			}		        
		}
		return fingerPrintLog;
	}

}
