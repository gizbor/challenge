package com.necar.fingerprint.services;

import java.util.Map;

import com.necar.fingerprint.beans.FingerPrintLog;

/**
 * Clase de servicio.
 * @author Gustavo M. Borello
 *
 */
public interface FingerPrintLogService {
	public boolean save(FingerPrintLog fingerPrintLog);
	public Map<String, Float> getStats();
}