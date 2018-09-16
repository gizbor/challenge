package com.necar.fingerprint;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.necar.fingerprint.controllers.FingerPrintController;
import com.necar.fingerprint.services.FingerPrintLogService;

@RunWith(SpringRunner.class)
@WebMvcTest(FingerPrintController.class)
public class FingerPrintLogControllerTests {

    @Autowired
    private MockMvc mvc;
 
    @MockBean
    private FingerPrintLogService service;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	}

}
