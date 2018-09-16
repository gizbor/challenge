package com.necar.fingerprint.wrappers;

/**
 * Clase "wrapper" para recibir la matriz por parámetro desde el cliente.
 * El objeto se hidrata directamente desde JSON por spring.
 * @author Gustavo M. Borello
 *
 */
public class MatrixWrapper {
	private String[] matrix;
	public String[] getMatrix() {
		return matrix;
	}
	public void setMatrix(String[] matrix) {
		this.matrix = matrix;
	}
}
