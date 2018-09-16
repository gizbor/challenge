package com.necar.fingerprint;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.necar.fingerprint.lib.FingerPrintTools;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FingerPrintApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testValidFingerPrint (){		
		String[] matrix = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};		
		boolean result= FingerPrintTools.isFingerPrint(matrix);		
		assertTrue(result);
	}
	
	@Test
	public void testInvalidFingerPrint (){		
		String[] matrix = {"TTGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};		
		boolean result= FingerPrintTools.isFingerPrint(matrix);		
		assertFalse(result);
	}
}
