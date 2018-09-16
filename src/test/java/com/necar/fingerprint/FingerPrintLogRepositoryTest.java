package com.necar.fingerprint;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.necar.fingerprint.beans.FingerPrintLog;
import com.necar.fingerprint.repositories.FingerPrintLogCrudRepository;
import com.necar.fingerprint.repositories.FingerPrintLogJpaRepository;
@RunWith(SpringRunner.class)
@DataJpaTest
public class FingerPrintLogRepositoryTest {

    @Autowired
    private FingerPrintLogCrudRepository fingerPrintLogCrudRepository;
 
    @Autowired
    private FingerPrintLogJpaRepository fingerPrintLogJpaRepository;
	
	@Before
	public void setUp() throws Exception {
		fingerPrintLogCrudRepository.deleteAll();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSaveValidFingerPrint() {
		FingerPrintLog fingerPrintLog = new FingerPrintLog();
		
		fingerPrintLog.setnOrder(6);
		fingerPrintLog.setRow1("ATGCGA");
		fingerPrintLog.setRow1("CAGTGC");
		fingerPrintLog.setRow1("TTATGT");
		fingerPrintLog.setRow1("AGAAGG");
		fingerPrintLog.setRow1("CCCCTA");
		fingerPrintLog.setRow1("TCACTG");
		fingerPrintLog.setResult('S');
		
		fingerPrintLogCrudRepository.save(fingerPrintLog);
		
		List<FingerPrintLog> list = fingerPrintLogJpaRepository.findAllByResult('S');
		
		assertEquals(list.size(), 1);			
	}

}
