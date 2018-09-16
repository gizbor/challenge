package com.necar.fingerprint.dao;

import java.util.List;

import com.necar.fingerprint.beans.FingerPrintLog;

public interface FingerPrintLogDAO {

	public boolean save(FingerPrintLog fingerPrintLog);

	public List<FingerPrintLog> findAllSucessful();

	public List<FingerPrintLog> findAllFailed();
}
