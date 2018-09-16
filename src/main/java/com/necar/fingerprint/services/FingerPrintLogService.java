package com.necar.fingerprint.services;

import java.util.List;
import java.util.Map;

import com.necar.fingerprint.beans.FingerPrintLog;

public interface FingerPrintLogService {
//	public List<FingerPrintLog> list();
//	public FingerPrintLog findById(Integer id);
//	public boolean delete( FingerPrintLog fingerPrintLog);
	public boolean save(FingerPrintLog fingerPrintLog);
	public Map<String, Float> getStats();
}