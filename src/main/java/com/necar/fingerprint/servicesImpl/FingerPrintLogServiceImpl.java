package com.necar.fingerprint.servicesImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.necar.fingerprint.beans.FingerPrintLog;
import com.necar.fingerprint.dao.FingerPrintLogDAO;
import com.necar.fingerprint.services.FingerPrintLogService;

/**
 * Implementación de la interfaz de servicio FingerPrintLogService
 * @author Gustavo M. Borello
 *
 */

@Service
public class FingerPrintLogServiceImpl implements  FingerPrintLogService {
	@Autowired
	FingerPrintLogDAO fingerPrintLogDAO;
	
	@Override
	public boolean save(FingerPrintLog fingerPrintLog) {		
		return fingerPrintLogDAO.save(fingerPrintLog);
	}

	@Override
	public Map<String, Float> getStats() {
		Map<String, Float> stats = new HashMap<String, Float>();
		
		List<FingerPrintLog> sucessfulList= fingerPrintLogDAO.findAllSucessful();
		Integer count_valid_fingerPrint = 0;
		Integer count_not_valid_fingerPrint = 0;
		
		if (sucessfulList!=null){		
			count_valid_fingerPrint = sucessfulList.size();
		}
		List<FingerPrintLog> failedList = fingerPrintLogDAO.findAllFailed();
		if (failedList!=null){		
			count_not_valid_fingerPrint = sucessfulList.size();
		}
		Integer ratio = count_valid_fingerPrint;
		if (count_not_valid_fingerPrint > 0) {
			ratio = count_valid_fingerPrint/count_not_valid_fingerPrint;
		} 
		
		stats.put("count_valid_fingerPrint", (float) count_valid_fingerPrint);
		stats.put("count_not_valid_fingerPrint", (float) count_not_valid_fingerPrint);
		stats.put("ratio", (float) ratio);
		
		return stats;
	}



}
