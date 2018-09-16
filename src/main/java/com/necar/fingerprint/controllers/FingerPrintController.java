package com.necar.fingerprint.controllers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
//	public @ResponseBody ResponseEntity<?> fingerPrint(@RequestBody MatrixWrapper mat){
	public @ResponseBody Map<String, String> fingerPrint(@RequestBody MatrixWrapper matrixWrapper) {
		
		Map<String, String> result = new HashMap<String, String>();
		
		// Hidrata un objeto FingerPrintLog a partir de la matriz.
		FingerPrintLog fingerPrintLog = FingerPrintTools.createFingerPrintLogBean(matrixWrapper.getMatrix());
		// TODO: ponerle fecha
//		fingerPrintLog.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
		
		if (FingerPrintTools.analize(matrixWrapper.getMatrix())){			
			fingerPrintLog.setResult(FingerPrintTools.SUCESS_RESULT);					
			result.put("status", "200");
			result.put("message", "Data found");
		} else {
			fingerPrintLog.setResult(FingerPrintTools.FAILED_RESULT);
			result.put("status", "404");
			result.put("message", "Data not found");			
		}
		
		fingerPrintLogService.save(fingerPrintLog);	
		
		return result;
//		if (FingerPrintTools.analize(mat.getMatrix())){
//			return new ResponseEntity<>("",HttpStatus.OK);
//		} 
//	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/stats")
	public @ResponseBody Map<String, Float> stats(){
		Map<String, Float> stats = fingerPrintLogService.getStats();
		return stats;
	}
	
	
}
