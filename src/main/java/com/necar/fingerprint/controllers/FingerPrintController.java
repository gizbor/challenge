package com.necar.fingerprint.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.necar.fingerprint.lib.FingerPrintTools;
import com.necar.fingerprint.wrappers.MatrixWrapper;


@RestController
public class FingerPrintController {

	@PostMapping("/fingerPrint")
//	public @ResponseBody ResponseEntity<?> fingerPrint(@RequestBody MatrixWrapper mat){
	public @ResponseBody Map<String, String> fingerPrint(@RequestBody MatrixWrapper mat){
		
		Map<String, String> result = new HashMap<String, String>();
		
//		List<String> _matrix = new ArrayList<String>();
//		_matrix.add("ATGCGA");
//		_matrix.add("CAGTGC");
//		_matrix.add("TTATGT");
//		_matrix.add("AGAAGG");
//		_matrix.add("CCCCTA");
//		_matrix.add("TCACTG"};
//		
		
		if (FingerPrintTools.analize(mat.getMatrix())){
			result.put("status", "200");
			result.put("message", "Data found");
		} else {
			result.put("status", "404");
			result.put("message", "Data not found");			
		}
		return result;
//		if (FingerPrintTools.analize(mat.getMatrix())){
//			return new ResponseEntity<>("",HttpStatus.OK);
//		} 
//	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("hello")
	public String hello(){
		return "Hello";
	}
	
	
}
