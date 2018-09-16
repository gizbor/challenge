package com.necar.fingerprint.controllers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.necar.fingerprint.beans.FingerPrintLog;
import com.necar.fingerprint.lib.FingerPrintTools;
import com.necar.fingerprint.services.FingerPrintLogService;
import com.necar.fingerprint.wrappers.MatrixWrapper;


@RestController
public class FingerPrintController {
	
	@Autowired
	private FingerPrintLogService fingerPrintLogService;  

	@PostMapping("/fingerPrint")
	public ResponseEntity<String> fingerPrint(@RequestBody MatrixWrapper matrixWrapper) {
		
		Map<String, String> result = new HashMap<String, String>();
		
		// Hidrata un objeto FingerPrintLog a partir de la matriz.
		FingerPrintLog fingerPrintLog = FingerPrintTools.createFingerPrintLogBean(matrixWrapper.getMatrix());
		ResponseEntity<String> response;
		if (FingerPrintTools.isFingerPrint(matrixWrapper.getMatrix())){			
			fingerPrintLog.setResult(FingerPrintTools.SUCESS_RESULT);					
			response = new ResponseEntity<String>(HttpStatus.OK);
		} else {
			fingerPrintLog.setResult(FingerPrintTools.FAILED_RESULT);
			response = new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}
		
		fingerPrintLogService.save(fingerPrintLog);	
		
		return response;
	}
	
	@PostMapping("/stats")
	public @ResponseBody Map<String, Float> stats(){
		Map<String, Float> stats = fingerPrintLogService.getStats();
		return stats;
	}
	
	
}
